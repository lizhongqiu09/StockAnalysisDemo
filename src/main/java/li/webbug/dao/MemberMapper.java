package li.webbug.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import li.webbug.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member> {

    public List<Member> selectListByWrapper(@Param("ew")Wrapper wrapper);

}