package ltd.inmind.oauth2clientdemo.controller;

import feign.Feign;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import ltd.inmind.oauth2clientdemo.model.AccessTokenResult;
import ltd.inmind.oauth2clientdemo.service.Oauth2InterfaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/oauth/2")
public class AuthController {

    private String CLIENT_ID = "test";
    private String CLIENT_CODE = "test";

    @Value("${oauth2.redirect-url}")
    private String redirectUrl;

    @Value("${oauth2.userservice}")
    private String userservice;

    private Oauth2InterfaceService interfaceService;

    {
        interfaceService = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new FormEncoder())
                .decoder(new GsonDecoder())
                .target(Oauth2InterfaceService.class, userservice);
    }




    @RequestMapping("/redirect")
    public String redirect(String code,HttpServletResponse response) {

        //用户已经在认证服务器通过授权

        //用client_id,client_code,code申请access_token
        AccessTokenResult accessToken = interfaceService.accessToken(CLIENT_ID, CLIENT_CODE, code);

        if (accessToken.getMessage() == null || "".equals(accessToken.getMessage())){

            //TODO 如何和系统内建用户交互

            //登陆

            //跳转
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            }
            return "redirect error";
        }else {
            return "error :" + accessToken.getMessage();
        }

    }

    @RequestMapping("/userservice")
    public void userService(HttpServletResponse response){

        String url = String.format("%s/authorize?client_id=%s&redirect_uri=%s/redirect&scope=%s", userservice, CLIENT_ID, redirectUrl, "user info");

        System.out.println("userservice  " + "[String.format] :" + url);

        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
