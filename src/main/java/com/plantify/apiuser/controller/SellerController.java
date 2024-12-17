package com.plantify.apiuser.controller;

import com.plantify.apiuser.domain.dto.request.SellerRequest;
import com.plantify.apiuser.domain.dto.response.SellerResponse;
import com.plantify.apiuser.global.response.ApiResponse;
import com.plantify.apiuser.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api-users")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    public ApiResponse<List<SellerResponse>> getAllSellers() {
        List<SellerResponse> allSellers = sellerService.getAllSellers();
        return ApiResponse.ok(allSellers);
    }

    @GetMapping("/{sellerId}")
    public ApiResponse<SellerResponse> getSeller(@PathVariable Long sellerId) {
        SellerResponse response = sellerService.getSeller(sellerId);
        return ApiResponse.ok(response);
    }

    @PostMapping
    public ApiResponse<SellerResponse> createSeller(@RequestBody SellerRequest request) {
        SellerResponse response = sellerService.createSeller(request);
        return ApiResponse.ok(response);
    }

    @PutMapping
    public ApiResponse<SellerResponse> updateSeller(@RequestBody SellerRequest request) {
        SellerResponse response = sellerService.updateSeller(request);
        return ApiResponse.ok(response);
    }

    @DeleteMapping("/{sellerId}")
    public ApiResponse<SellerResponse> deleteSeller(@PathVariable Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return ApiResponse.ok();
    }

    @GetMapping("/{name}")
    public ApiResponse<SellerResponse> getSellerByName(@PathVariable String name) {
        SellerResponse response = sellerService.getSellerByName(name);
        return ApiResponse.ok(response);
    }
}
