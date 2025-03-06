package com.pavyk96.TestGradle.service.impl;

import com.pavyk96.TestGradle.model.User;
import com.pavyk96.TestGradle.service.TalkService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TalkToFriendServiceImpl implements TalkService {

    @PostConstruct
    public void init() {
        System.out.println("Создан бин: TalkToFriendServiceImpl");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Уничтожен бин: TalkToFriendServiceImpl");
    }

    @Override
    public String makeHello(User user) {
        return "Здарово броо, " + user.getName();
    }

    @Override
    public String makeGoodBy(User user) {
        return "Покеда броо, " + user.getName();
    }
}
