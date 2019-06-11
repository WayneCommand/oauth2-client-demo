package ltd.inmind.oauth2clientdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth/2")
public class AuthController {

    private String CLIENT_ID = "test";
    private String CLIENT_CODE = "test";


    @RequestMapping("/redirect")
    public String redirect(String code) {

        //用户已经在认证服务器通过授权

        //用client_id,client_code,code申请access_token

        //关联到系统内部用户

        return "";
    }

}
