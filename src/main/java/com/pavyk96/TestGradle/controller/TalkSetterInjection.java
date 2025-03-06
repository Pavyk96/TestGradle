package com.pavyk96.TestGradle.controller;

import com.pavyk96.TestGradle.model.User;
import com.pavyk96.TestGradle.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class TalkSetterInjection {
    @Qualifier("talkToFriendServiceImpl")
    private TalkService talkService;

    @Autowired
    public void setTalkService(TalkService talkService) {
        this.talkService = talkService;
    }

    public String sayGoodbye(User user) {
        return talkService.makeGoodBy(user);
    }
}

