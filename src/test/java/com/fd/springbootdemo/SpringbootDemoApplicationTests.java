package com.fd.springbootdemo;

import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGoEasy(){
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-54643d147f5a4ac289398680d36e5bdf");
        goEasy.publish("my_channel","Hello, GoEasy!");
    }
}
