package lk.ijse.spring.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderDetailsDTO {
    private String order_id;//TODO working .... sending
    private String item_code;//TODO working ....
    private String item_name;//TODO working ....
    private double item_price;//TODO working ....
    private int item_qty;//TODO working ....
    private double tot;//TODO working ....

}
