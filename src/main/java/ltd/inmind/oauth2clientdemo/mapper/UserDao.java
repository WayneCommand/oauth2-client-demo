package ltd.inmind.oauth2clientdemo.mapper;

import ltd.inmind.oauth2clientdemo.model.User;

public interface UserDao {

    int insert(User user);

    int update(User user);

    User selectById(Integer id);

}
