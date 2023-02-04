package lk.ijse.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
/*
    @Column(nullable = false,length = 45)
*/
    private String id;
    @Column(nullable = false,length = 45)
    private String name;
    @Column(nullable = false,length = 45)
    private String address;
    @Column(nullable = false,length = 45)
    private String contact;
}
