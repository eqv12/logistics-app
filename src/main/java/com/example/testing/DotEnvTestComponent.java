package com.example.testing; // Or any of your component packages

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DotEnvTestComponent {

    @Value("${MY_TEST_VARIABLE:#{null}}") // Default to null if not found
    private String myTestVariable;

    @PostConstruct
    public void init() {
        if (myTestVariable != null) {
            System.out.println("SUCCESSFULLY LOADED FROM .env: MY_TEST_VARIABLE = " + myTestVariable);
        } else {
            System.err.println("FAILED TO LOAD FROM .env: MY_TEST_VARIABLE is null");
        }
    }
}