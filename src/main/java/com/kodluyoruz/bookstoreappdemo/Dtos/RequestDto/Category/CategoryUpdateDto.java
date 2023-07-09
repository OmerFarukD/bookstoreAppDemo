package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Category;

import lombok.Data;

@Data
public class CategoryUpdateDto {
    private Integer categoryId;
    private String categoryName;
}
