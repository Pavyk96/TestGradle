package com.pavyk96.TestGradle.hw3.controller;

import com.pavyk96.TestGradle.hw3.exception.BadGatewayException;
import com.pavyk96.TestGradle.hw3.exception.Exception502;
import com.pavyk96.TestGradle.hw3.model.Info;
import com.pavyk96.TestGradle.hw3.model.Template;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class Controllers {

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/json")
    public Template makeResponse(@RequestBody Template template) {
        Info info = Info.builder()
                .id(123)
                .date(template.getInfo().getDate())
                .build();

        return Template.builder()
                .price(template.getPrice())
                .info(info)
                .build();
    }

    @GetMapping("/error")
    public void makeError() {
        throw new BadGatewayException("ну заплачь");
    }
}
