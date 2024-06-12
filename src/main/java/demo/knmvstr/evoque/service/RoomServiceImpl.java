package demo.knmvstr.evoque.service;

import demo.knmvstr.evoque.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomServiceImpl {
    @Autowired
    private RoomRepository roomRepository;
}
