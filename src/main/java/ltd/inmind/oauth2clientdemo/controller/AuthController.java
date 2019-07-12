package ltd.inmind.oauth2clientdemo.controller;

import ltd.inmind.oauth2clientdemo.model.intf.AccessTokenResult;
import ltd.inmind.oauth2clientdemo.service.AuthService;
import ltd.inmind.oauth2clientdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/oauth/2")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/redirect")
    public String redirect(String code,HttpServletResponse response) {

        //用户已经在认证服务器通过授权

        //用client_id,client_code,code申请access_token
        AccessTokenResult result;
        try {
            result = authService.userServiceAccessToken(code);
        } catch (Exception e) {
            return e.getMessage();
            //TODO 失败了之后去错误页面
        }


        //登陆

        try {
            loginService.login(result.getAccess_token());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
            //TODO 失败了之后返回失败信息
        }


        //登陆成功跳转
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "";
    }

    @RequestMapping("/userservice")
    public void userService(HttpServletResponse response){

        String url = authService.userServiceRedirectUrl();

        System.out.println("userservice  " + "[String.format] :" + url);

        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
