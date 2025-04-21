package com.pavyk96.TestGradle.hw10.service;

import com.pavyk96.TestGradle.hw10.dto.MessageResponse;

public interface MessageService {
    MessageResponse getMessage();
    void reset();
}
