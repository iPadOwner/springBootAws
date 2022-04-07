package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostsSaveRequestDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        String title = "testTitle";
        String content = "testContent";
        String author = "testAuthor";

        PostsSaveRequestDto dto = new PostsSaveRequestDto(title, content, author);

        assertThat(dto.getTitle()).isEqualTo(title);
        assertThat(dto.getContent()).isEqualTo(content);
        assertThat(dto.getAuthor()).isEqualTo(author);
    }
}
