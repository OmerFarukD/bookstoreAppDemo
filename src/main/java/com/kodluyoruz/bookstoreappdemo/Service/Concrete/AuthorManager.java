package com.kodluyoruz.bookstoreappdemo.Service.Concrete;

import com.kodluyoruz.bookstoreappdemo.Core.Results.*;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Author.AuthorAddDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Author.AuthorUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Author.AuthorResponseDto;
import com.kodluyoruz.bookstoreappdemo.Entity.Author;
import com.kodluyoruz.bookstoreappdemo.Repository.AuthorRepository;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorManager implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;
    @Override
    public Result add(AuthorAddDto request) {

        Author author = this.modelMapper.map(request,Author.class);
        author.setAuthorId(null);
        this.authorRepository.save(author);
        return new SuccessResult("Yazar eklendi.");
    }

    @Override
    public DataResult<List<AuthorResponseDto>> getAll() {
        List<Author> authors = this.authorRepository.findAll();
        // 1. yöntem
 /*       List<AuthorResponseDto> dtoList= new ArrayList<>();

        for (Author author : authors) {
            AuthorResponseDto response = this.modelMapper.map(author,AuthorResponseDto.class);
            dtoList.add(response);
        }
        return new SuccessDataResult<>(dtoList);*/
        List<AuthorResponseDto> responseDtoList =authors.stream().map(x->this.modelMapper.map(x,AuthorResponseDto.class))
                .toList();
        return new SuccessDataResult<>(responseDtoList);
    }

    @Override
    public Result update(AuthorUpdateDto authorUpdateDto) {
        Optional<Author> author = this.authorRepository.findById(authorUpdateDto.getAuthorId());
        if (author.isEmpty()){
            return new ErrorResult("Yazar Bulunamadı");
        }
        this.authorRepository.save(author.get());
        return new SuccessResult("Yazar Eklendi");
    }

    @Override
    public Result delete(int id) {
        Optional<Author> author = this.authorRepository.findById(id);
        if (author.isEmpty()){
            return new ErrorResult("Yazar Bulunamadı");
        }
        this.authorRepository.delete(author.get());
        return new SuccessResult("Yazar Silindi.");

    }

    @Override
    public DataResult<AuthorResponseDto> getById(int id) {
        Optional<Author> author = this.authorRepository.findById(id);
        if (author.isEmpty()){
            return new ErrorDataResult<>("Yazar Bulunamadı");
        }
        AuthorResponseDto dto = this.modelMapper.map(author.get(),AuthorResponseDto.class);
        return new SuccessDataResult<>(dto);

    }

    @Override
    public DataResult<AuthorResponseDto> getByAuthorName(String name) {

        // Set<Author>
        // Dictionary<string,Author>
        //Author
        List<Author> authors = this.authorRepository.findAll();
        // Stream<Author>
        //Stream<AuthorResponseDto>
        //AuthorResponseDto
        AuthorResponseDto authorResponseDto=authors.stream().map(z->this.modelMapper.map(z,AuthorResponseDto.class))
                .filter(x-> x.getAuthorName().equals(name))
                .findFirst().get();
        return new SuccessDataResult<>(authorResponseDto,"Yazar adına göre getirildi.");
    }
}
