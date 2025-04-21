package com.pavyk96.TestGradle.hw10.service.impl;

import com.pavyk96.TestGradle.hw10.aspect.ApiRequestAspect;
import com.pavyk96.TestGradle.hw10.dto.MessageResponse;
import com.pavyk96.TestGradle.hw10.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final ApiRequestAspect apiRequestAspect;

    public MessageResponse getMessage() {
        return new MessageResponse("Привет мой друг!!!!)");
    }

    @Override
    public void reset() {
        apiRequestAspect.resetCounter();
    }
}
