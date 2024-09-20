package com.myretail.myretail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private  String apiPath;

    private HttpStatus errorCode;

    private  String errorMessage;
}
