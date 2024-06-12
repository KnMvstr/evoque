package com.knmvstr.evoque.custom_response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventNotFoundException extends RuntimeException {
    private final String message;
}