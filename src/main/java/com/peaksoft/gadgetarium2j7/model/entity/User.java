package com.peaksoft.gadgetarium2j7.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private Long id;
        private String firstName;
        private String lastName;
        private String telNumber;
        private String email;
        private String password;
        private String address;
        private LocalDate createDate;


        @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
        @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<Role> roles;
}
