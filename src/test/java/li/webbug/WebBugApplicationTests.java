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
    @Test
    public void ass(){
        List<Member> memberList = memberService.selectListByWrapper(new QueryWrapper<Member>()
                .lambda().like(Member::getName, "a"));
        System.out.print(memberList);
    }

}
