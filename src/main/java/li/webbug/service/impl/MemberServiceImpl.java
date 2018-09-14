package li.webbug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import li.webbug.dao.MemberMapper;
import li.webbug.entity.Member;
import li.webbug.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> selectList() {
        return null;
    }
}
