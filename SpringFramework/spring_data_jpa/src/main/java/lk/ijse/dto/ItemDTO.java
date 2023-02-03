package lk.ijse.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ItemDTO {
    private String itemId;
    private String itemName;
    private int qty;
    private double unitPrice;
}
