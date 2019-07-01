package ltd.inmind.oauth2clientdemo.model;

public class AuthRecord {
    private Integer id;

    private String authServerName;

    private String authUserId;

    private Integer userId;

    private String accessToken;

    private int expiredTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthServerName() {
        return authServerName;
    }

    public void setAuthServerName(String authServerName) {
        this.authServerName = authServerName;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }
}
