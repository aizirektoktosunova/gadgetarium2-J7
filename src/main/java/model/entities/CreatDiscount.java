package model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "creatDiscounts")
@Getter
@Setter
@NoArgsConstructor
public class CreatDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sizeDiscount;
    private String dateStart;
    private String dateEnd;
}
