package demo.knmvstr.evoque.DTO;

import demo.knmvstr.evoque.entity.Room;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDTO {
    @NotBlank(message = "Your event need a title")
    private String title;

    @NotBlank(message = "Describe your the event ")
    private String description;

    @NotBlank(message = "Specify the room")
    private Room room;

    @NotBlank(message = "Illustrate the event")
    private String image;

    @NotBlank(message = "Your event need a title")
    private LocalDateTime startTime;

    @NotBlank(message = "Your event need a title")
    private LocalDateTime endTime;

    @NotBlank(message = "Your event need a title")
    private BigDecimal price;
}
