package model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "history_of_orders")
@Getter
@Setter
@NoArgsConstructor
public class HistoryOfOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate orderTime;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "history")
    private List<Product> products;


}
