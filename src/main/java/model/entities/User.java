package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enums.Gender;
import model.enums.Role;
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
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_orders", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Order orders;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "users")
    private List<PaymentPayCard> paymentPayCard;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id")
    private HistoryOfOrder history;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "createNewsLetter_id")
    private CreateNewsLetter createNewsLetter;
}
