package demo.knmvstr.evoque.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", unique = true, nullable = false, length = 50)
    private String reference;

    @Column(name = "amount", unique = true, nullable = false, length = 50)
    private String amount;

    @Column(name = "currency", unique = true, nullable = false, length = 50)
    private String currency;

    @Column(name = "status", unique = true, nullable = false, length = 50)
    private String status;
}
