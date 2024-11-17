package com.plantify.apiuser.domain.dto.request;

import com.plantify.apiuser.domain.entity.Seller;
import com.plantify.apiuser.domain.entity.Status;

public record SellerRequest(
        String name,
        String contactInfo,
        String businessInfo,
        Status status,
        String redirectUrl
) {

    public Seller toEntity() {
        return Seller.builder()
                .name(name)
                .contactInfo(contactInfo)
                .businessInfo(businessInfo)
                .status(Status.ACTIVE)
                .redirectUrl(redirectUrl)
                .build();
    }
}
