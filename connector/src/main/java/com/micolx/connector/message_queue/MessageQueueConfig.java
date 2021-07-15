package com.micolx.connector.message_queue;

import com.google.protobuf.InvalidProtocolBufferException;
import com.micolx.connector.protobuf.AckMessage;
import com.micolx.connector.protobuf.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageQueueConfig.class);

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MQConstants.exchange, true, false);
    }

    @Bean
    public Queue queue() {
        return new Queue(MQConstants.queue, true);
    }

    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with(MQConstants.routingKey);
    }

    @Bean
    public MessageConverter createMessageConverter() {
        return new AbstractMessageConverter() {
            @Override
            protected Message createMessage(Object o, MessageProperties messageProperties) {
                if (o instanceof ChatMessage) {
                    ChatMessage chatMessage = (ChatMessage) o;
                    messageProperties.setContentType("chat");
                    return new Message(chatMessage.toByteArray(), messageProperties);
                } else if (o instanceof AckMessage) {
                    AckMessage ackMessage = (AckMessage) o;
                    messageProperties.setContentType("ack");
                    return new Message(ackMessage.toByteArray(), messageProperties);
                } else {
                    throw new MessageConversionException("unknown message type in createMessage()");
                }
            }

            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                if (message.getMessageProperties().getContentType().equals("chat")) {
                    try {
                        return ChatMessage.parseFrom(message.getBody());
                    } catch (InvalidProtocolBufferException e) {
                        LOGGER.error("error parsing message body to chatMessage");
                        e.printStackTrace();
                    }
                } else if (message.getMessageProperties().getContentType().equals("ack")) {
                    try {
                        return AckMessage.parseFrom(message.getBody());
                    } catch (InvalidProtocolBufferException e) {
                        LOGGER.error("error parsing message body to ackMessage");
                        e.printStackTrace();
                    }
                } else {
                    throw new MessageConversionException("unknown message type in fromMessage()");
                }
                return null;
            }
        };
    }
}
