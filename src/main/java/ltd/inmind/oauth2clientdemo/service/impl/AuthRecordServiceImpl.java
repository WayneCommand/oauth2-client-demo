package ltd.inmind.oauth2clientdemo.service.impl;

import ltd.inmind.oauth2clientdemo.dao.AuthRecordDao;
import ltd.inmind.oauth2clientdemo.model.AuthRecord;
import ltd.inmind.oauth2clientdemo.model.User;
import ltd.inmind.oauth2clientdemo.service.AuthRecordService;
import ltd.inmind.oauth2clientdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthRecordServiceImpl implements AuthRecordService {

    private AuthRecordDao authRecordDao;

    private UserService userService;


    @Override
    public AuthRecord findRecordByServerNameAndId(String serverName, String id) {

        return authRecordDao.selectByServerAndId(serverName, id);
    }

    @Override
    public int createAuthRecord(AuthRecord authRecord, String nickname) {

        User user = userService.createUser(nickname);

        authRecord.setUserId(user.getId());

        return authRecordDao.insert(authRecord);
    }

    @Override
    public int updateAccessToken(AuthRecord authRecord) {

        return authRecordDao.updateAccessToken(authRecord);
    }
}
