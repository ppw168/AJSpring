package com.salientCrgt.caivrs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.salientCrgt.hudStack.AjSpringApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AjSpringApplication.class)
@WebAppConfiguration
public class AjSpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}
