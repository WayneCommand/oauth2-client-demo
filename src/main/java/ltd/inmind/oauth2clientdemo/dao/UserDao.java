package ltd.inmind.oauth2clientdemo.dao;

import ltd.inmind.oauth2clientdemo.model.User;

public interface UserDao {

    int insert(User user);

    int update(User user);

    User selectById(Integer id);

}
