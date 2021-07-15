package com.micolx.connector.message_queue;

import com.micolx.connector.protobuf.AckMessage;
import com.micolx.connector.protobuf.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessagingService {
    private final RabbitTemplate rabbitTemplate;

    // convertAndSend(exchange, routingKey, message)
    public void forwardMessage(String routingKey, ChatMessage message) {
        rabbitTemplate.convertAndSend(MQConstants.exchange, routingKey, message);
    }

    public void forwardAck(String routingKey, AckMessage ackMessage) {
        rabbitTemplate.convertAndSend(MQConstants.exchange, routingKey, ackMessage);
    }
}
