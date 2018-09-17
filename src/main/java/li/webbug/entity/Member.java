package li.webbug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

@TableName("member")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name=" + name  +
                ", mobile=" + mobile  +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
