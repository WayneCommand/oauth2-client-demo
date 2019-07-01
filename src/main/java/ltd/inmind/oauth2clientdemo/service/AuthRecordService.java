package ltd.inmind.oauth2clientdemo.service;

import ltd.inmind.oauth2clientdemo.model.AuthRecord;

public interface AuthRecordService {

    AuthRecord findRecordByServerNameAndId(String serverName, String id);

    int createAuthRecord(AuthRecord authRecord, String nickname);

    int updateAccessToken(AuthRecord authRecord);

}
