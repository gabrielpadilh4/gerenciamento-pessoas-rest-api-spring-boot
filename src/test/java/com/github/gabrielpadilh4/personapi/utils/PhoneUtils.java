package com.github.gabrielpadilh4.personapi.utils;

import com.github.gabrielpadilh4.personapi.dto.request.PhoneDTO;
import com.github.gabrielpadilh4.personapi.entity.Phone;
import com.github.gabrielpadilh4.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1999675-8601";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
