package ltd.inmind.oauth2clientdemo.service;

import feign.Param;
import feign.RequestLine;


public interface Oauth2InterfaceService {

    @RequestLine("POST /access_token")
    String accessToken(@Param("client_id") String clientId, @Param("client_secret") String clientSecret, @Param("code") String code);
}
