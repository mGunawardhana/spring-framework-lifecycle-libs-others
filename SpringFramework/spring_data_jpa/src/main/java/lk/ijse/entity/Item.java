package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Item {
    @Id
    private String itemId;
    private String itemName;
    private int qty;
    private double unitPrice;
}
