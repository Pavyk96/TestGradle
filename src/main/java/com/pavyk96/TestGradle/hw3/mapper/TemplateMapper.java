package com.pavyk96.TestGradle.hw3.mapper;

import com.pavyk96.TestGradle.hw3.dto.TemplateRequest;
import com.pavyk96.TestGradle.hw3.dto.TemplateResponse;
import com.pavyk96.TestGradle.hw3.model.Template;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TemplateMapper {

    TemplateResponse toResponse(Template template);

    @Mapping(target = "info.id", constant = "123")
    Template toEntity(TemplateRequest request);
}
