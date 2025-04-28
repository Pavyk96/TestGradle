package com.pavyk96.TestGradle.service.impl;

import com.pavyk96.TestGradle.model.User;
import com.pavyk96.TestGradle.service.TalkService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class TalkToParentsServiceImpl implements TalkService {

    @PostConstruct
    public void init() {
        System.out.println("Создан бин: TalkToParentsServiceImpl");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Уничтожен бин: TalkToParentsServiceImpl");
    }


    @Override
    public String makeHello(User user) {
        return "Приветствую тебя, " + user.getName() + " " + user.getSurname();
    }

    @Override
    public String makeGoodBy(User user) {
        return "Приветствую тебя, " + user.getName() + " " + user.getSurname();
    }
}
