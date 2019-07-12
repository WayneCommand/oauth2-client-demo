package ltd.inmind.oauth2clientdemo.service.impl;

import ltd.inmind.oauth2clientdemo.mapper.UserMapper;
import ltd.inmind.oauth2clientdemo.model.User;
import ltd.inmind.oauth2clientdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User createUser(String nickname) {

        User user = new User();
        user.setNickname(nickname);

        userMapper.insert(user);

        return user;
    }

    @Override
    public int updateUser(User user) {

        return userMapper.updateById(user);
    }
}
