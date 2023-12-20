package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enums.CaseShape;
import model.enums.Memory;
import model.enums.SubCategory;
import model.enums.WirelessInterface;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int weight;
    private String color;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "brands_id")
    private Brand brands;
    private String screenSize;
    @Enumerated(EnumType.STRING)
    private Memory memory;
    private int simCard;
    private String processor;
    private String guarantee;
    private double discount;
    private LocalDate creatDate;
    private String rating;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;
    @Enumerated(EnumType.STRING)
    private CaseShape caseShape;
    private boolean waterproof;
    @Enumerated(EnumType.STRING)
    private WirelessInterface w_i;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "products_and_orders",
    joinColumns =@JoinColumn(name = "products_id"),
    inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Order>orders;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "history_id")
    private HistoryOfOrder history;
}
