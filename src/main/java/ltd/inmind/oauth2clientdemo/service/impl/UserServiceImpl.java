package ltd.inmind.oauth2clientdemo.service.impl;

import ltd.inmind.oauth2clientdemo.mapper.UserDao;
import ltd.inmind.oauth2clientdemo.model.User;
import ltd.inmind.oauth2clientdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User createUser(String nickname) {

        User user = new User();
        user.setNickname(nickname);

        userDao.insert(user);

        return user;
    }

    @Override
    public int updateUser(User user) {

        return userDao.update(user);
    }
}
