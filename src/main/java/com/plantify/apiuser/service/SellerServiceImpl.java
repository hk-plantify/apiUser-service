package com.plantify.apiuser.service;

import com.plantify.apiuser.client.UserInfoProvider;
import com.plantify.apiuser.domain.dto.request.SellerRequest;
import com.plantify.apiuser.domain.dto.response.SellerResponse;
import com.plantify.apiuser.domain.entity.Seller;
import com.plantify.apiuser.global.exception.ApplicationException;
import com.plantify.apiuser.global.exception.errorcode.SellerErrorCode;
import com.plantify.apiuser.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final UserInfoProvider userInfoProvider;
    private final InternalService internalService;

    @Override
    public List<SellerResponse> getAllSellers() {
        return sellerRepository.findAll()
                .stream()
                .map(SellerResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public SellerResponse getSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));
        Long adminId = userInfoProvider.getUserInfo().userId();

        internalService.recordActivityLog("APIUSER", sellerId, "VIEW", adminId);

        return SellerResponse.from(seller);
    }

    @Override
    public SellerResponse createSeller(SellerRequest request) {
        Long adminId = userInfoProvider.getUserInfo().userId();
        Seller seller = request.toEntity();
        Seller savedSeller = sellerRepository.save(seller);

        internalService.recordActivityLog("APIUSER", seller.getSellerId(), "CREATE", adminId);

        return SellerResponse.from(savedSeller);
    }

    @Override
    public SellerResponse updateSeller(Long sellerId, SellerRequest request) {
        Long adminId = userInfoProvider.getUserInfo().userId();
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));

        Seller updatedSeller = seller.toBuilder()
                .name(request.name())
                .contactInfo(request.contactInfo())
                .businessInfo(request.businessInfo())
                .status(request.status())
                .redirectUrl(request.redirectUrl())
                .build();

        Seller savedSeller = sellerRepository.save(updatedSeller);

        internalService.recordActivityLog("APIUSER", sellerId, "UPDATE", adminId);

        return SellerResponse.from(savedSeller);
    }

    @Override
    public void deleteSeller(Long sellerId) {
        Long adminId = userInfoProvider.getUserInfo().userId();
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ApplicationException(SellerErrorCode.SELLER_NOT_FOUND));

        sellerRepository.delete(seller);

        internalService.recordActivityLog("APIUSER", sellerId, "DELETE", adminId);

    }
}
