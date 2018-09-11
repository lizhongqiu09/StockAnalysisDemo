package li.webbug.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String message){
        rabbitTemplate.convertAndSend("email",message);
    }
}
