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
    private String order_id;
    private String order_date;
    private String customer_id;
    private String customer_name;
    private String customer_contact;
    private List<OrderDetailsDTO> fullObj;

}
