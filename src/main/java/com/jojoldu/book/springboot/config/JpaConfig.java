package com.jojoldu.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration//@WebMvcTest는 일반적인 @Configuration 는 스캔하지않음
@EnableJpaAuditing//Application.java에 있던것을 여기로 옮김
public class JpaConfig {
}
