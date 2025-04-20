package com.pavyk96.TestGradle.hw3.controller;

import com.pavyk96.TestGradle.hw3.dto.TemplateRequest;
import com.pavyk96.TestGradle.hw3.dto.TemplateResponse;
import com.pavyk96.TestGradle.hw3.exception.BadGatewayException;
import com.pavyk96.TestGradle.hw3.mapper.TemplateMapper;
import com.pavyk96.TestGradle.hw3.model.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class Controllers {

    private final TemplateMapper mapper;

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @ResponseBody
    @PostMapping("/json")
    public TemplateResponse makeResponse(@RequestBody TemplateRequest request) {
        Template template = mapper.toEntity(request);
        TemplateResponse response = mapper.toResponse(template);
        return response;
    }

    @GetMapping("/error")
    public void makeError() {
        throw new BadGatewayException("ну заплачь");
    }
}
