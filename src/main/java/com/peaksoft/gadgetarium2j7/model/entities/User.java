package com.peaksoft.gadgetarium2j7.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.peaksoft.gadgetarium2j7.model.enums.Gender;
import com.peaksoft.gadgetarium2j7.model.enums.Role;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String address;
    private int age;
    private LocalDate createDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_orders", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Order orders;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "users")
    private List<PayCard> paymentPayCard;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "newsLetter_id")
    private NewsLetter newsLetter;

}
