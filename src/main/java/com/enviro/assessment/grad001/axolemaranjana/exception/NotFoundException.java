package com.enviro.assessment.grad001.axolemaranjana.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
@Getter
@Setter
public class NotFoundException  {
    private String message;
    private String details;
}
