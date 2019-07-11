package ltd.inmind.oauth2clientdemo.service.impl;

import feign.Feign;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import ltd.inmind.oauth2clientdemo.model.AccessTokenResult;
import ltd.inmind.oauth2clientdemo.service.AuthService;
import ltd.inmind.oauth2clientdemo.service.intf.Oauth2InterfaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private String CLIENT_ID = "test";
    private String CLIENT_CODE = "test";

    @Value("${oauth2.redirect-url}")
    private String redirectUrl;

    @Value("${oauth2.userservice}")
    private String userservice;

    private Oauth2InterfaceService interfaceService;


    @Override
    public String userServiceRedirectUrl() {
        return String.format("%s/authorize?client_id=%s&redirect_uri=%s/redirect&scope=%s", userservice, CLIENT_ID, redirectUrl, "user info");
    }

    @Override
    public AccessTokenResult userServiceAccessToken(String code) {
        AccessTokenResult accessToken = interfaceService.accessToken(CLIENT_ID, CLIENT_CODE, code);

        if (accessToken.getMessage() == null || "".equals(accessToken.getMessage()))
            return accessToken;
        else
            throw new RuntimeException(accessToken.getMessage());
    }

}
