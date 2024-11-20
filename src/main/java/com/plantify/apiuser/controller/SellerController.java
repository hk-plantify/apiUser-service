package com.plantify.apiuser.controller;

import com.plantify.apiuser.domain.dto.request.SellerRequest;
import com.plantify.apiuser.domain.dto.response.SellerResponse;
import com.plantify.apiuser.global.response.ApiResponse;
import com.plantify.apiuser.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api-users")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SellerResponse>>> getAllSellers() {
        List<SellerResponse> allSellers = sellerService.getAllSellers();
        return ResponseEntity.ok(ApiResponse.ok(allSellers));
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<ApiResponse<SellerResponse>> getSeller(
            @PathVariable Long sellerId) {
        SellerResponse response = sellerService.getSeller(sellerId);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<SellerResponse>> createSeller(
            @RequestBody SellerRequest request) {
        SellerResponse response = sellerService.createSeller(request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @PutMapping("/{sellerId}")
    public ResponseEntity<ApiResponse<SellerResponse>> updateSeller(
            @PathVariable Long sellerId, @RequestBody SellerRequest request) {
        SellerResponse response = sellerService.updateSeller(sellerId, request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @DeleteMapping("/{sellerId}")
    public ResponseEntity<ApiResponse<SellerResponse>> deleteSeller(@PathVariable Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
