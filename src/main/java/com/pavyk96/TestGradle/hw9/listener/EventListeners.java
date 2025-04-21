package com.pavyk96.TestGradle.hw9.listener;

import com.pavyk96.TestGradle.hw9.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.event.TransactionPhase;

@Slf4j
@Component
public class EventListeners {

    @EventListener
    public void handleRegularEvent(Message.SimpleEvent event) {
        log.info("Обычное событие: {}", event.message());
    }

    @Async
    @EventListener
    public void handleAsyncEvent(Message.AsyncEvent event) {
        log.info("Асинхронное событие: {}", event.message());
    }

    @TransactionalEventListener
    public void handleTransactionalEvent(Message.TxEvent event) {
        if (!event.shouldProcess()) {
            log.info("[Transactional Listener] Событие проигнорировано: {}", event.message());
            return;
        }
        log.info("[Transactional Listener] Обработка события: {}", event.message());
    }
}
