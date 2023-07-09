package com.kodluyoruz.bookstoreappdemo.Service.Contrats;

import com.kodluyoruz.bookstoreappdemo.Core.Results.DataResult;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Author.AuthorAddDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Author.AuthorUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Author.AuthorResponseDto;

public interface AuthorService extends BaseService<AuthorAddDto, AuthorUpdateDto, AuthorResponseDto>{

    DataResult<AuthorResponseDto> getByAuthorName(String name);
}
