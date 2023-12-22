package com.peaksoft.gadgetarium2j7.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peaksoft.gadgetarium2j7.model.enums.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.peaksoft.gadgetarium2j7.model.enums.CaseShape;
import com.peaksoft.gadgetarium2j7.model.enums.Memory;
import com.peaksoft.gadgetarium2j7.model.enums.WirelessInterface;

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
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "products_and_orders", joinColumns = @JoinColumn(name = "products_id"), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Order> orders;
}
