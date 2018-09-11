package li.webbug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("li.webbug.dao")
public class WebBugApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBugApplication.class, args);
    }
}
