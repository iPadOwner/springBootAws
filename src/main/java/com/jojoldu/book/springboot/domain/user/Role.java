package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    //Spring security에서는 항상 권한코드가 ROLE_ 로 시작해야한다
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;
}
