package com.example.demoAPIs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNo;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    @JsonIgnore
    private List<BooksEntity> issuedBooksList;

}
