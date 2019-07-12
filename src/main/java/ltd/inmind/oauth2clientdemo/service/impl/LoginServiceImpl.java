package ltd.inmind.oauth2clientdemo.service.impl;

import ltd.inmind.oauth2clientdemo.model.AuthRecord;
import ltd.inmind.oauth2clientdemo.model.intf.UserResult;
import ltd.inmind.oauth2clientdemo.service.AuthRecordService;
import ltd.inmind.oauth2clientdemo.service.LoginService;
import ltd.inmind.oauth2clientdemo.service.intf.Oauth2InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String SERVICE_NAME = "userservice";

    @Value("${oauth2.userservice}")
    private String userservice;

    private Oauth2InterfaceService oauth2InterfaceService;

    @Autowired
    private AuthRecordService authRecordService;

    @Override
    public void login(String accessToken) {
        //拉取用户信息
        UserResult userServiceUserInfo = oauth2InterfaceService.getUserServiceUserInfo(accessToken);

        if (userServiceUserInfo == null)
            throw new RuntimeException("user info not found");

        //查找系统内用户

        AuthRecord authRecord = authRecordService.findRecordByServerNameAndId(SERVICE_NAME, userServiceUserInfo.getuId().toString());

        //如果找不到
        //  创建用户
        //  绑定
        //  登陆
        if (authRecord == null)
            authRecord = doCreateAndBind(accessToken,userServiceUserInfo.getuId().toString(),userServiceUserInfo.getUsername());

        doLogin(authRecord.getUserId());

    }

    private AuthRecord doCreateAndBind(String accessToken,String authUserId,String nickname) {
        AuthRecord authRecord = new AuthRecord();
        authRecord.setAccessToken(accessToken);
        authRecord.setAuthServerName(SERVICE_NAME);
        authRecord.setAuthUserId(authUserId);

        authRecordService.createAuthRecord(authRecord, nickname);
        return authRecord;
    }

    private void doLogin(Integer userId) {
        //TODO do login
    }

    @PostConstruct
    public void setOauth2InterfaceService() {
        oauth2InterfaceService = Oauth2InterfaceService.getInstance(userservice);
    }
}
