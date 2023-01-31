package lk.ijse.spring.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderDetailsDTO {
    private String order_id;
    private String item_code;//TODO working ....
    private String item_name;//TODO working ....
    private double unit_price;
    private int item_qty;
    private double item_total;//TODO working ....

}
