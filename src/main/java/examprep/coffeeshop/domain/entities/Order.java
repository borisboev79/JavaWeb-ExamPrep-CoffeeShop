package examprep.coffeeshop.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name="order_time", nullable = false)
    private LocalDateTime orderTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Category category;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private User employee;


}
