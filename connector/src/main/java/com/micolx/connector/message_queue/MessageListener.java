package com.micolx.connector.message_queue;

import com.micolx.connector.SpringContext;
import com.micolx.connector.protobuf.AckMessage;
import com.micolx.connector.protobuf.ChatMessage;
import com.micolx.connector.utility.SessionManager;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MQConstants.queue)
public class MessageListener {

    @RabbitHandler
    public void chatMessageListener(ChatMessage chatMessage) {
        String recipientId = chatMessage.getRecipientID();
        SessionManager sessionManager = SpringContext.getBean(SessionManager.class);
        sessionManager.getChannelFromID(recipientId).writeAndFlush(chatMessage);
    }

    @RabbitHandler
    public void ackMessageListener(AckMessage ackMessage) {
        String recipient = ackMessage.getRecipientID();
        SessionManager sessionManager = SpringContext.getBean(SessionManager.class);
        sessionManager.getChannelFromID(recipient).writeAndFlush(ackMessage);
    }
}
