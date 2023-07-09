package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Author;

import lombok.Data;

@Data
public class AuthorUpdateDto {
    private Integer authorId;
    private String authorName;
}
