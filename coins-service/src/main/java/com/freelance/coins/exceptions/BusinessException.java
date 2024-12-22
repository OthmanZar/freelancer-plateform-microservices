package com.freelance.coins.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


public class BusinessException extends Throwable  {

    public BusinessException(String string) {
        super(string);
    }
}
