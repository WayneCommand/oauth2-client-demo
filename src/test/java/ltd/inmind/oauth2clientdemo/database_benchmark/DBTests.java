package ltd.inmind.oauth2clientdemo.database_benchmark;

import ltd.inmind.oauth2clientdemo.database_benchmark.model.User;
import ltd.inmind.oauth2clientdemo.database_benchmark.mapper.UserMapper;
import org.apache.tomcat.util.buf.HexUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.yml")
@MapperScan("ltd.inmind.oauth2clientdemo.database_benchmark.mapper")
public class DBTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private Environment environment;

    @Test
    public void contextLoads(){
        System.out.println(environment.getProperty("spring.profiles.active"));
    }

    @Test
    public void insert() {
        User user = new User();
        long start = System.currentTimeMillis();

        for (int i = 1; i < 5001; i++) {
            user.setId((long)i);
            user.setNickname(HexUtils.toHexString((i + "").getBytes()));

            userMapper.insert(user);
        }

        long end = System.currentTimeMillis();

        System.err.println("time = " + (end - start));

    }

    @Test
    public void select_sequential() {

        List<Integer> ids = new ArrayList<>();
        for (int i = 100; i < 1100; i++) {
            ids.add(i);
        }

        long start = System.currentTimeMillis();

        List<User> users = userMapper.selectBatchIds(ids);

        long end = System.currentTimeMillis();

        System.err.println("time = " + (end - start));
        if (users.size() != 1000) throw new RuntimeException("sum err");
    }

    @Test
    public void select_random(){
        int sum = 200;
        Set<Integer> ids = new TreeSet<>();
        Random random = new Random();
        while (true){
            if (ids.size() == sum) break;
            ids.add(random.nextInt(5000));
        }

        long start = System.currentTimeMillis();

        List<User> users = userMapper.selectBatchIds(ids);

        long end = System.currentTimeMillis();

        System.err.println("time = " + (end - start));
        if (users.size() != sum) throw new RuntimeException("sum err");

    }




}
