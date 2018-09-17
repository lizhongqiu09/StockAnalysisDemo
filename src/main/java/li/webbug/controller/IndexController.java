package li.webbug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import li.webbug.entity.Member;
import li.webbug.mq.Sender;
import li.webbug.service.MemberService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Api(value = "", tags = "首页")
@RestController
public class IndexController {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Sender sender;
    @Value("${spring.mail.username}")
    private String username;
    @Autowired
    MemberService memberService;

    @ApiOperation(value = "获取股票信息" ,notes  = "获取股票信息")
    @GetMapping("/")
    public void index(){
        String url = "http://stock.finance.sina.com.cn/usstock/quotes/IBB.html";
        try {
            Document document = Jsoup.connect(url).get();
            Element details = document.getElementById("hqDetails");
            System.out.print(details);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getStockInfo")
    //    @Scheduled(cron = "0/5 * * * * *")
    public String getStockInfo(){
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject("http://hq.sinajs.cn/etag.php?rn=1534923485634&list=gb_ibb", String.class);
        String[] strings = object.split("\"");
        analyzeInfo(strings[1]);
        String[] info = strings[1].split(",");
        if(Float.valueOf(info[26]) < Float.valueOf(info[1])){
//            sendMail("今天升了");
            sender.send("今天升了");
        }else{
//            sendMail("今天跌了");
            sender.send("今天跌了");
        }
        return strings[1];
    }


    public String analyzeInfo(String Info){
        String[] info = Info.split(",");
//        info[0];   股票名称
//        info[5];   区间底
//        info[6];   区间顶
//        info[26];   昨天收盘价
//        info[1];   今天收盘价
        return null;
    }

    @ApiOperation(value = "会员列表")
    @GetMapping("/memberList")
    public List<Member> getMemberList(){
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
//        wrapper.lambda().eq(Member::getName,"b");
        List<Member> list = memberService.list(wrapper);
        return list;
    }

    @ApiOperation(value = "获取单个会员")
    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") Long id){
        Member member = memberService.getById(id);
        return member;
    }
}
