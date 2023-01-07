package com.example.demoAPIs.model;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String bookId;

    @Column(nullable = false)
    private String name;

    @Column(nullable=false)
    private String authorName;

    @ManyToOne
    @JoinColumn
    private UserEntity user;
}
