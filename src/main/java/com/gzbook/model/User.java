package com.gzbook.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    @NotEmpty
    private String name;

    private String avatar;

    private String description;

    public User() {
    }
}
