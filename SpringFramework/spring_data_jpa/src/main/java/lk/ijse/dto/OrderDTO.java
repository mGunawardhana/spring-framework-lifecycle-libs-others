package lk.ijse.dto;

import lk.ijse.dto.OrderDetailsDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderDTO {
    private String order_id;//TODO working .... sending
    private String order_date;//TODO working .... sending
    private String customer_id;//TODO working .... sending
    private String customer_name;//TODO working .... sending
    private String customer_contact;//TODO working .... sending
    private List<OrderDetailsDTO> fullObj;



    public OrderDTO(String order_id, String order_date, String customer_id, String customer_name, String customer_contact) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_contact = customer_contact;
    }

}
