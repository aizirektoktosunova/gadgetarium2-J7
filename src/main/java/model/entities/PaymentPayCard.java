package model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "payment_pay_cards")
@Getter
@Setter
@NoArgsConstructor
public class PaymentPayCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private int numberCard;
    private String mm;
    private String yy;
    private String cvc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User users;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "paymentPayCard")
    private List<Order> orders;

}
