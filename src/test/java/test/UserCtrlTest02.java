package test;

import com.core.BootStrapApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

/**
 * Copyright
 * FileName: UserCtrlTest02
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/11 14:49
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrapApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserCtrlTest02 {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void addUser() throws IOException {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("id",111l);
        map.add("username","sir");
        map.add("address","BJ");
        map.add("age",22);
        map.add("password","123");
        ResponseEntity<String> resp = testRestTemplate.postForEntity("/addUser", map, String.class);
        String body = resp.getBody();
        System.out.println(body);
    }

    @Test
    public void delUser(){

        ResponseEntity<String> resp = testRestTemplate.getForEntity("/deleteUser?id={1}", String.class, 1000L);
        String result = resp.getBody();
        System.err.println(result);


    }

}

