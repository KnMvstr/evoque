package com.knmvstr.evoque.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false, length = 50)
    private String title;

    @Column(name = "description", unique = true, nullable = false, length = 50)
    private String description;

@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
// CascadeType.Remove = When I remove a category I want to remove all the product in this category
    private List<Event> events = new ArrayList<>();
}
