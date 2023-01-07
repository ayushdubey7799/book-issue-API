package com.example.demoAPIs.Repository;

import com.example.demoAPIs.model.BooksEntity;
import com.example.demoAPIs.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<BooksEntity,Integer> {
}
