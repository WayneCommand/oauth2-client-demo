package ltd.inmind.oauth2clientdemo.service.intf;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import ltd.inmind.oauth2clientdemo.model.intf.AccessTokenResult;
import ltd.inmind.oauth2clientdemo.model.intf.UserResult;

import java.util.HashMap;
import java.util.Map;


public interface Oauth2InterfaceService {

    Map<String, Oauth2InterfaceService> instances = new HashMap<>();

    @RequestLine("POST /access_token")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    AccessTokenResult accessToken(@Param("client_id") String clientId, @Param("client_secret") String clientSecret, @Param("code") String code);

    @RequestLine("GET /api/userinfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json","Authorization: token {oauthToken}"})
    UserResult getUserServiceUserInfo(@Param("oauthToken") String oauthToken);


    static Oauth2InterfaceService getInstance(String url) {
        if (instances.containsKey(url))
            return instances.get(url);

        Oauth2InterfaceService instance = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new FormEncoder())
                .decoder(new GsonDecoder())
                .target(Oauth2InterfaceService.class, url);

        instances.put(url, instance);

        return instance;

    }
}
