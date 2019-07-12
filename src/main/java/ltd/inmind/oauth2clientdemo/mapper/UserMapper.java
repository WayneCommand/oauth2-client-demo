package ltd.inmind.oauth2clientdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.inmind.oauth2clientdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
