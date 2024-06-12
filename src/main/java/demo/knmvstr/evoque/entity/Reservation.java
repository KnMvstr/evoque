package demo.knmvstr.evoque.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne@JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "reservations")
    private List<Event> events = new ArrayList<>();

    @CreatedDate
    @Column(name = "reservation_date",nullable = false)
    private DateFormat reservation_date;
}