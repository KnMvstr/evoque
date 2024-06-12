package demo.knmvstr.evoque.service;

import demo.knmvstr.evoque.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
}
