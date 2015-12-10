package com.salientCrgt.caivrs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.salientCrgt.hudStack.AjSpringApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AjSpringApplication.class)
@WebAppConfiguration
public class AjSpringApplicationTests {

    @Test
    public void contextLoads() {}

}
