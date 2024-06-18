package com.niq.product_service.utils;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@Component("queryUtil")
public class QueryCondition {

    public boolean checkNull(String field) {
        return field == null;
    }
}
