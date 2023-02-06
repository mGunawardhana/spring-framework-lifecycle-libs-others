package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetails {
    @Id
    private String order_id;
    @Id
    private String item_code;
    private String item_name;
    private double unit_price;
/*    private int item_qty;
    private double item_total;*/

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_code",referencedColumnName = "itemId",insertable = false,updatable = false)
    private Item items;
}

