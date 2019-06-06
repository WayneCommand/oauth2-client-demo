package ltd.inmind.oauth2clientdemo;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2ClientDemoApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testFeign(){
        BaiduSearch search = Feign.builder()
                .client(new OkHttpClient())
                .target(BaiduSearch.class, "https://www.baidu.com");

        String github = search.search("github","50","50","json");
        System.out.println(github);

    }
}
