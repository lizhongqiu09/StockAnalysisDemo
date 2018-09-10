package li.webbug.MQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "email")
public class Listener {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    @RabbitHandler
    public void process(String todayMessage){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo("");
        message.setSubject("股票消息");
        message.setText(todayMessage);
        javaMailSender.send(message);
    }

}
