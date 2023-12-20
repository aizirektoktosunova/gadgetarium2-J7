package com.peaksoft.gadgetarium2j7.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.peaksoft.gadgetarium2j7.model.enums.Status;

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
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "history")
    private List<Product> products;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "history")
    private User user;
}
