package ltd.inmind.oauth2clientdemo.model;

import com.baomidou.mybatisplus.annotation.*;

@TableName("t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 从授权服务器拉取的用户名
     */
    private String nickname;

    /**
     * 用户设定的系统内At的ID
     * 默认为空 可以不设定
     * 如果不设定AtId 则无法查找到用户并且无法被AT
     */
    private String atId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", atId='" + atId + '\'' +
                '}';
    }
}
