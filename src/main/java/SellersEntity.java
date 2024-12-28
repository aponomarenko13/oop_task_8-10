import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "seller")
@Accessors(chain = true)
public class SellersEntity {

    @Id
    @Column(nullable = false, unique = true, name = "seller_id")
    private UUID sellersId;

    @Column(nullable = false, name = "seller_name")
    private String sellersName;

    @Column(nullable = false, name = "specialization")
    private String specialization;

    @Column(nullable = true, name = "description")
    private String description;
}
