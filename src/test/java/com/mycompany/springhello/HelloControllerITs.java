/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springhello;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URL;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author 212486104
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerITs {
    @LocalServerPort
    private int port;
    
    private URL base;
    
    @Autowired
    private TestRestTemplate template;
    
    @Before
    public void setUp() throws Exception{
        this.base = new URL ("http://localhost:" + port + "/");
    }
    
    @Test
    public void getHello() throws Exception{
        ResponseEntity<String> response =template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(),equalTo("Greetings from Spring Boot!"));
    }
    
}
