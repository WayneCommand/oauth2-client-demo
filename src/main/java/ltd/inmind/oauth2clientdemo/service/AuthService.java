package ltd.inmind.oauth2clientdemo.service;

import ltd.inmind.oauth2clientdemo.model.intf.AccessTokenResult;

public interface AuthService {

    String userServiceRedirectUrl();

    AccessTokenResult userServiceAccessToken(String code);

}
