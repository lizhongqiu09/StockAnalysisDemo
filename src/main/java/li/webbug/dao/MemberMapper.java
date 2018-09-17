package li.webbug.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import li.webbug.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member> {

    List<Member> selectListByWrapper(@Param("ew")Wrapper wrapper);

}