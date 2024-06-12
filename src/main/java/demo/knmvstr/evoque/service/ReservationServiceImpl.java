package demo.knmvstr.evoque.service;

import demo.knmvstr.evoque.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationServiceImpl {
    @Autowired
    private ReservationRepository reservationRepository;
}
