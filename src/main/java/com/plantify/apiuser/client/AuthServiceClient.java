package com.plantify.apiuser.client;

import com.plantify.apiuser.domain.dto.response.AuthUserResponse;
import com.plantify.apiuser.global.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthServiceClient {

    @PostMapping("/v1/auth/validate-token")
    ApiResponse<AuthUserResponse> getUserInfo(@RequestHeader("Authorization") String authorizationHeader);
}