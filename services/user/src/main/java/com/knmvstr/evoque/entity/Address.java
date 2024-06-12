package com.knmvstr.evoque.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data // Bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
@Builder
@Validated // Addresses need to be validated
public class Address {
    private String street;
    private String city;
    private String country;
    private String zipCode;
}
