package lk.ijse.entity;

import lk.ijse.dto.OrderDetailsDTO;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Orders {

    @Id
    private String order_id;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id",referencedColumnName = "id",nullable = false)
    private Customer customer_id;
    private LocalDate order_date;
    private String customer_name;
    private String customer_contact;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> fullObj;
}
