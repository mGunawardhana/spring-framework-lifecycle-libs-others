package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Item {

    @Id
/*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
    private String itemId;
    @Column(nullable = false,length = 45)
    private String itemName;
    @Column(nullable = false,length = 45)
    private int qty;
    @Column(nullable = false,length = 45)
    private double unitPrice;
}
