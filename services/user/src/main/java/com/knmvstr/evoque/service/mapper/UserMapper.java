package com.knmvstr.evoque.service.mapper;

import com.knmvstr.evoque.controller.UserRequest;
import com.knmvstr.evoque.controller.UserResponse;
import com.knmvstr.evoque.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRequest request) {
        if(request == null)
            return null; //
        return User.builder()
                .id(request.id())
                .first_name(request.first_name())
                .last_name(request.last_name())
                .username(request.username())
                .password(request.password())
                .role(request.role())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .build();
    }
    public UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress()
        );
    }
}
