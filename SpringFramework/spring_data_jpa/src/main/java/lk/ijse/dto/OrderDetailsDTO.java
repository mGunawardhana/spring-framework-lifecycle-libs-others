package lk.ijse.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderDetailsDTO {
    private String order_id;
    private String item_code;
    private String item_name;
    private double unit_price;
    private int item_qty;
    private double item_total;

}
