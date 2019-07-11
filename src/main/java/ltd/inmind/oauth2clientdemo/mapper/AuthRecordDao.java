package ltd.inmind.oauth2clientdemo.mapper;

import ltd.inmind.oauth2clientdemo.model.AuthRecord;

public interface AuthRecordDao {

    int insert(AuthRecord authRecord);

    int updateAccessToken(AuthRecord authRecord);

    AuthRecord selectByServerAndId(String serverName, String id);

}
