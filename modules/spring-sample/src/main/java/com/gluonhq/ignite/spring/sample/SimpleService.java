package com.gluonhq.ignite.spring.sample;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String getText() {
        return "This text is INJECTED";
    }

}
