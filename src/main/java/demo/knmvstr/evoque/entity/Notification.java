package demo.knmvstr.evoque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.text.DateFormat;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender", unique = true, nullable = false, length = 50)
    private String sender;

    @Column(name = "receipt", unique = true, nullable = false, length = 50)
    private String receipt;

    @Column(name = "content", unique = true, nullable = false, length = 50)
    private String content;

    @Column(name = "date", unique = true, nullable = false)
    private DateFormat date;
}
