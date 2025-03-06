package com.pavyk96.TestGradle.controller;

import com.pavyk96.TestGradle.model.User;
import com.pavyk96.TestGradle.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class TalkFieldInjection {
    @Autowired
    @Qualifier("talkToParentsServiceImpl")
    private TalkService talkService; // Внедрение через поле

    public String sayHello(User user) {
        return talkService.makeHello(user);
    }
}
