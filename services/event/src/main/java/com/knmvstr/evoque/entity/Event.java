package com.knmvstr.evoque.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "title"
)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false, length = 50)
    private String title;

    @Column(name = "description", unique = true, nullable = false, length = 50)
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "room_id", nullable = false)
//    private Room room;

    @Column(name = "image", length = 50)
    private String image;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "availableQtty", nullable = false)
    private Integer availableQtty;

//    @ManyToMany
//    @JoinTable(
//            name = "event_reservation",
//            joinColumns=@JoinColumn(name = "event_id"),
//            inverseJoinColumns = @JoinColumn(name = "reservation_id")
//    )
//    private List<Reservation> reservationList = new ArrayList<>();
}