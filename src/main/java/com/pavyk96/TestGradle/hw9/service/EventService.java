package com.pavyk96.TestGradle.hw9.service;

import com.pavyk96.TestGradle.hw9.dto.EventRequest;

public interface EventService {
    void publishRegularEvent(EventRequest dto);
    void publishAsyncEvent(EventRequest dto);
    void publishTransactionalEvent(EventRequest dto);
}
