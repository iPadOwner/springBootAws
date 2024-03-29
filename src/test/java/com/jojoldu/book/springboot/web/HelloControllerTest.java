package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
            //Spring Security 적용을 위한 부분
            /*excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION,
                                        classes= SecurityConfig.class)
            })*/
            excludeFilters={
            @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
                    classes= SecurityConfig.class)
                        })
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
//        mvc.perform(get("/hello2"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(hello));
    }


    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String hello = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name",hello)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(hello)))
                .andExpect(jsonPath("$.amount", is(amount)));

//        mvc.perform(get("/hello/dto2")
//                        .param("name",hello)
//                        .param("amount",String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(hello)))
//                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
