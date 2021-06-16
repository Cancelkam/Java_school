package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.service.api.MessageSender;
import lombok.RequiredArgsConstructor;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import javax.jms.*;

@Service
@RequiredArgsConstructor
public class MessageSenderImpl implements MessageSender {

    private final Environment environment;
    private final ConnectionFactory connectionFactory;


    @Override
    public void sendMessage(String json) {

        try {
            QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(environment.getProperty("spring.activemq.destination"));
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) session.createTextMessage(json);
            messageProducer.send(activeMQTextMessage);

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
