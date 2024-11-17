package com.plantify.apiuser.domain.dto.response;

import com.plantify.apiuser.domain.entity.Seller;
import com.plantify.apiuser.domain.entity.Status;

import java.time.LocalDateTime;

public record SellerResponse(
        Long sellerId,
        String name,
        String contactInfo,
        String businessInfo,
        Status status,
        String redirectUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static SellerResponse from(Seller seller) {
        return new SellerResponse(
                seller.getSellerId(),
                seller.getName(),
                seller.getContactInfo(),
                seller.getBusinessInfo(),
                seller.getStatus(),
                seller.getRedirectUrl(),
                seller.getCreatedAt(),
                seller.getUpdatedAt()
        );
    }
}
