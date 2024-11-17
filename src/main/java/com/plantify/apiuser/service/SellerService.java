package com.plantify.apiuser.service;

import com.plantify.apiuser.domain.dto.request.SellerRequest;
import com.plantify.apiuser.domain.dto.response.SellerResponse;

import java.util.List;

public interface SellerService {

    List<SellerResponse> getAllSellers();
    SellerResponse getSeller(Long sellerId);
    SellerResponse createSeller(SellerRequest request);
    SellerResponse updateSeller(Long sellerId, SellerRequest request);
    void deleteSeller(Long sellerId);
}
