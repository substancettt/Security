package com.wellshang.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wellshang.demo.SpringBootOauth2Application;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootOauth2Application.class)
@WebAppConfiguration
public class SpringBootOauth2ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
