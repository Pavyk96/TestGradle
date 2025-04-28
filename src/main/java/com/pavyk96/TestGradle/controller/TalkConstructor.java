package com.pavyk96.TestGradle.controller;

import com.pavyk96.TestGradle.model.User;
import com.pavyk96.TestGradle.service.TalkService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TalkConstructor {
    @NonNull
    @Qualifier("talkToFriendServiceImpl")
    private TalkService service;

    public String newTalk(User user) {
        return service.makeHello(user);
    }

    public String closeTalk(User user) {
        return service.makeGoodBy(user);
    }
}
