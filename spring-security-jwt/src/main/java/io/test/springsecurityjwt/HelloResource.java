package io.test.springsecurityjwt;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/")
    public String hello(Principal principal) {

        Map<String, Object> userDetailsMap = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication().getDetails();
        String name = (String) userDetailsMap.get("name");

        return "hello " + name + " welcome to the new world ";
    }

}
