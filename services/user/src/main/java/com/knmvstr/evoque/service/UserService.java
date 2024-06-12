package com.knmvstr.evoque.service;

import com.knmvstr.evoque.controller.UserRequest;
import com.knmvstr.evoque.controller.UserResponse;
import com.knmvstr.evoque.custom_response.UserNotFoundException;
import com.knmvstr.evoque.entity.User;
import com.knmvstr.evoque.repository.UserRepository;
import com.knmvstr.evoque.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public Long createUser (UserRequest request){
        var user = userRepository.save(mapper.toUser(request));
        return user.getId();
    }

    public void updateUser(UserRequest request) {
        var user = userRepository.findById(request.id())
                        .orElseThrow(() -> new UserNotFoundException(
                                format("User with id %s not found", request.id())
                                //Optimized adding static import of the class method
                        ));
        //I merge user if the user already exist in DB
        mergeUser(user, request);
        userRepository.save(user);
    }
// This the merge method. if the data exist I don't change it
    private void mergeUser(User user, UserRequest request) {
        if (StringUtils.isNotBlank(request.first_name())){
            user.setFirst_name(request.first_name());
        }
        if (StringUtils.isNotBlank(request.last_name())){
            user.setLast_name(request.last_name());
        }
        if (StringUtils.isNotBlank(request.email())){
            user.setEmail(request.email());
        }
        if (StringUtils.isNotBlank(request.phone())){
            user.setPhone(request.phone());
        }
        if (StringUtils.isNotBlank(request.password())){
            user.setPassword(request.password());
        }
        if (StringUtils.isNotBlank(request.username())){
            user.setUsername(request.username());
        }
        // Handling Role
        if (request.role() != null) {
            user.setRole(request.role());
        }
        // Handling Address
        if (request.address() != null) {
            if (StringUtils.isNotBlank(request.address().getStreet())) {
                user.getAddress().setStreet(request.address().getStreet());
            }
            if (StringUtils.isNotBlank(request.address().getCity())) {
                user.getAddress().setCity(request.address().getCity());
            }
            if (StringUtils.isNotBlank(request.address().getCountry())) {
                user.getAddress().setCountry(request.address().getCountry());
            }
            if (StringUtils.isNotBlank(request.address().getZipCode())) {
                user.getAddress().setZipCode(request.address().getZipCode());
            }
        }
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll()
        .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    public Boolean existById(Long id) {
        return userRepository.findById(id).isPresent();
    }

    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(mapper::fromUser)
                .orElseThrow(()-> new UserNotFoundException(format("User with id %s not found", id)));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}