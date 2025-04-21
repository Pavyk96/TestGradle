package com.pavyk96.TestGradle.hw9.service.impl;

import com.pavyk96.TestGradle.hw9.dto.EventRequest;
import com.pavyk96.TestGradle.hw9.dto.Message;
import com.pavyk96.TestGradle.hw9.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publishRegularEvent(EventRequest dto) {
        log.info("Default event: {}", dto.message());
        publisher.publishEvent(new Message.SimpleEvent(dto.message()));
    }

    @Override
    public void publishAsyncEvent(EventRequest dto) {
        log.info("async event: {}", dto.message());
        publisher.publishEvent(new Message.AsyncEvent(dto.message()));
    }

    @Override
    public void publishTransactionalEvent(EventRequest request) {
        log.info("Публикуем два транзакционных события...");

        if (request.shouldProcess()) {
            publisher.publishEvent(new Message.TxEvent(request.message(), true));
            log.info("Первое транзакционное событие обработано.");
        } else {
            log.info("Первое транзакционное событие пропущено (shouldProcess=false).");
        }

        if (!request.shouldProcess()) {
            publisher.publishEvent(new Message.TxEvent(request.message(), false));
            log.info("Второе транзакционное событие обработано.");
        } else {
            log.info("Второе транзакционное событие пропущено (shouldProcess=true).");
        }
    }


}

