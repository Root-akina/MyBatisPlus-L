package com.itheima;

import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@SpringBootTest
public class testFeign {


    public void doFeign(){
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest build = HttpRequest.newBuilder().GET().build();
        build.headers();
    }
}
