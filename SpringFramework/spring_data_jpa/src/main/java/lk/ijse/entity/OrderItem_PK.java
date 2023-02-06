package lk.ijse.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItem_PK implements Serializable {
    private String order_id;
    private String item_code;
}
