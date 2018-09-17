package li.webbug;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import li.webbug.dao.MemberMapper;
import li.webbug.entity.Member;
import li.webbug.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebBugApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    MemberService memberService;
    @Autowired
    MemberMapper memberMapper;
    @Test
    public void ass(){
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        List<Member> list = memberService.list(wrapper);
        list.forEach(System.out::println);
    }

}
