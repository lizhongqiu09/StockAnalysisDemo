package li.webbug.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import li.webbug.entity.Member;

import java.util.List;

public interface MemberService extends IService<Member> {

    public List<Member> selectListByWrapper(Wrapper wrapper);

}
