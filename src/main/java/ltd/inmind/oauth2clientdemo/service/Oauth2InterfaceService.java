package ltd.inmind.oauth2clientdemo.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import ltd.inmind.oauth2clientdemo.model.AccessTokenResult;


public interface Oauth2InterfaceService {

    @RequestLine("POST /access_token")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    AccessTokenResult accessToken(@Param("client_id") String clientId, @Param("client_secret") String clientSecret, @Param("code") String code);
}
