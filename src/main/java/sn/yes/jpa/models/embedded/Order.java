package sn.yes.jpa.models.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Entity
@Table(name = "_order")
public class Order {
    @EmbeddedId
    private OrderId id;
    @Embedded
    private Address address;

    private String orderInfo;

    private  String anotherField;
}
