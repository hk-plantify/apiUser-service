package com.plantify.apiuser.service;

import com.plantify.apiuser.domain.dto.request.SellerRequest;
import com.plantify.apiuser.domain.dto.response.SellerResponse;
import com.plantify.apiuser.domain.entity.Seller;
import com.plantify.apiuser.global.exception.ApplicationException;
import com.plantify.apiuser.global.exception.errorcode.SellerErrorCode;
import com.plantify.apiuser.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public List<SellerResponse> getAllSellers() {
        return sellerRepository.findAll()
                .stream()
                .map(SellerResponse::from)
                .toList();
    }

    @Override
    public SellerResponse getSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));

        return SellerResponse.from(seller);
    }

    @Override
    public SellerResponse createSeller(SellerRequest request) {
        Seller seller = request.toEntity();
        Seller savedSeller = sellerRepository.save(seller);
        return SellerResponse.from(savedSeller);
    }

    @Override
    public SellerResponse updateSeller(SellerRequest request) {
        Seller seller = sellerRepository.findById(request.sellerId())
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));

        Seller updatedSeller = request.updatedSeller(seller);
        Seller savedSeller = sellerRepository.save(updatedSeller);
        return SellerResponse.from(savedSeller);
    }

    @Override
    public void deleteSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));
        sellerRepository.delete(seller);
    }

    @Override
    public SellerResponse getSellerByName(String name) {
        Seller seller = sellerRepository.findByName(name)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));
        return SellerResponse.from(seller);
    }
}
