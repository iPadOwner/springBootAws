package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
모든 Entity의 상위 클래스가 되어 Entity들의
cretedDate, modifiedDate를 자동으로 관리
(ex : Posts Entity 클래스등이 상속함)
 */
@Getter
@MappedSuperclass//JPA Entity들이 BaseTimeEntity를 상속할 경우 필드들(createdDate,modifiedDate)도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)//BaseTimeEntity 클래스가 Auditing 기능 포함하도록 함
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;//Entity생성 시 시간 자동저장

    @LastModifiedDate
    private LocalDateTime modifiedDate;//조회한 Entity의 값을 변경 시 시간이 자동 저장
}
