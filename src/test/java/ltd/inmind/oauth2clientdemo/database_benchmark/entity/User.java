package ltd.inmind.oauth2clientdemo.database_benchmark.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
public class User {
    private Long id;
    private String nickname;
    private String atId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}

