package com.knmvstr.evoque.client.user_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "user-service",
        url ="${application.config.user-url}"
)
public interface UserClient {

    @GetMapping("/{id}")
    Optional<UserResponse> findUserById(@PathVariable("id") String id);
}
