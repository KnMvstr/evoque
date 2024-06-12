package demo.knmvstr.evoque.DTO;

import demo.knmvstr.evoque.entity.Event;
import demo.knmvstr.evoque.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationDTO {

    private User user;

    private Event event;

    @NotBlank(message = "Specify the date of the reservation")
    private DateFormat reservation_date;
}
