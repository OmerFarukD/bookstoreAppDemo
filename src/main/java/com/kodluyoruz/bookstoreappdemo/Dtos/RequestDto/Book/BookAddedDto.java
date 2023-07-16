package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book;
import com.kodluyoruz.bookstoreappdemo.AOP.Annotations.DescriptionMustBeUnique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class BookAddedDto {


    @NotNull(message = "Title Null olamaz")
    @NotBlank(message = "Title Boş Olamaz")
    @Length(min = 1,max = 20, message = "title  min 2 max 20 karakterden oluşmalıdır.")
    private String title;

     @NotBlank
     @NotNull
     @DescriptionMustBeUnique
    private String description;

    private String authorName;
    private  String category;
    private double price;
    private int unitInStock;

}
