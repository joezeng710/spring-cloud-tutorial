package com.joe.simpleconsumermovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie")
    public User findById(@RequestParam("id") Long id) {
        String url = userServiceUrl + "user?id="+ id;
        return restTemplate.getForObject(url, User.class);
    }

}

