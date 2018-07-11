package test;

import com.core.BootStrapApp;
import com.core.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Copyright
 * FileName: UserControllerTest
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/11 14:28
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BootStrapApp.class)
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void saveUser() throws Exception {

        User user = new User(111L,"girl","111",18,"CD");
        ObjectMapper mapper = new ObjectMapper();


        mockMvc.perform(post("/addUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(user)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", Is.is(0)))
        ;
    }

    @Test
    public void getUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/getUser?id=100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.code", Is.is(0)))
                .andExpect(jsonPath("$.data.username", Is.is("sir")))
                .andExpect(jsonPath("$.data.age", Is.is(99)))
        ;
    }




}
