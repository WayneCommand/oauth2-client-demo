package ltd.inmind.oauth2clientdemo.service;

import ltd.inmind.oauth2clientdemo.model.User;

public interface UserService {

    User bindUser();

    User findUserById(Integer id);

}
