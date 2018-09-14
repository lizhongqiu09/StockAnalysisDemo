package li.webbug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//计划任务
@EnableScheduling
//开启事务
@EnableTransactionManagement
@MapperScan("li.webbug.dao")
public class WebBugApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBugApplication.class, args);
    }
}
