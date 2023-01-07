package com.example.demoAPIs;

import com.example.demoAPIs.Dto.BookDto;
import com.example.demoAPIs.Dto.UserDto;
import com.example.demoAPIs.Repository.BookRepository;
import com.example.demoAPIs.Repository.UserRepository;
import com.example.demoAPIs.model.BooksEntity;
import com.example.demoAPIs.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    public void addUser(UserDto userDto){
        String userId = UUID.randomUUID().toString();
        UserEntity user = UserEntity.builder()
                .userId(userId)
                .name(userDto.getName())
                .email(userDto.getEmail())
                .phoneNo(userDto.getPhoneNo())
                .build();

        userRepository.save(user);
    }

    public void issueBookToUser(BookDto bookDto){
        String bookId = UUID.randomUUID().toString();
        BooksEntity book = BooksEntity.builder()
                .bookId(bookId)
                .authorName(bookDto.getAuthorName())
                .name(bookDto.getName())
                .user(bookDto.getUser())
                .build();

        bookRepository.save(book);
    }

    public List<BookDto> getBooksByUserId(String userId){
        List<BooksEntity> booksEntityList = bookRepository.findAll();
        List<BookDto> requiredBooks = new ArrayList<>();
        for(BooksEntity book:booksEntityList) {
            if (book.getUser().getUserId().equals(userId)) {
                BookDto bookDto = convertEntityToDto(book);
                requiredBooks.add(bookDto);
            }
        }

        return requiredBooks;
    }

    public BookDto convertEntityToDto(BooksEntity book){
        return BookDto.builder()
                .user(book.getUser())
                .authorName(book.getAuthorName())
                .name(book.getName())
                .build();
    }
}
