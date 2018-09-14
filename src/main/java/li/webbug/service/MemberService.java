package li.webbug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import li.webbug.entity.Member;

import java.util.List;

public interface MemberService extends IService<Member> {

    List<Member> selectList();

}
