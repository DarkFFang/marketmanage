package com.fang.marketmanage.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UserUtil {
    @Value("${random.int[10000000,99999999]}")
    private String id;
}
