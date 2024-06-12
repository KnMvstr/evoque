package com.knmvstr.evoque.custom_response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BusinessException extends RuntimeException{
    private final String message;
}
