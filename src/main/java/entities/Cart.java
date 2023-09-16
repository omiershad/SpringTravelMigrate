package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
// do we need this?
@ToString
public enum Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="Package_Price")
    private BigDecimal package_price;

    @Column(name="Party_Size")
    private int party_size;

    @Column(name="status")
    private StatusType status;

    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="customer_ID", nullable = false)
    private Customer customer;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>(); // do we need this?

}
