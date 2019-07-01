package ltd.inmind.oauth2clientdemo.service;

import ltd.inmind.oauth2clientdemo.model.User;

public interface UserService {

    User findUserById(Integer id);

    User createUser(String nickname);

    int updateUser(User user);

}
