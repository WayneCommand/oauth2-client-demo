package ltd.inmind.oauth2clientdemo.service.impl;

import ltd.inmind.oauth2clientdemo.mapper.AuthRecordMapper;
import ltd.inmind.oauth2clientdemo.model.AuthRecord;
import ltd.inmind.oauth2clientdemo.model.User;
import ltd.inmind.oauth2clientdemo.service.AuthRecordService;
import ltd.inmind.oauth2clientdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthRecordServiceImpl implements AuthRecordService {

    @Autowired
    private AuthRecordMapper authRecordMapper;

    @Autowired
    private UserService userService;


    @Override
    public AuthRecord findRecordByServerNameAndId(String serverName, String id) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("auth_server_name", serverName);
        queryMap.put("auth_user_id", id);

        List<AuthRecord> authRecords = authRecordMapper.selectByMap(queryMap);

        if (authRecords.isEmpty())
            return null;

        return authRecords.get(0);
    }

    @Override
    public int createAuthRecord(AuthRecord authRecord, String nickname) {

        User user = userService.createUser(nickname);

        authRecord.setUserId(user.getId());

        return authRecordMapper.insert(authRecord);
    }

    @Override
    public int updateAccessToken(AuthRecord authRecord) {

        return authRecordMapper.updateById(authRecord);
    }
}
