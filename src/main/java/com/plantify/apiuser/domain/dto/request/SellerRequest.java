package com.plantify.apiuser.domain.dto.request;

import com.plantify.apiuser.domain.entity.Seller;
import com.plantify.apiuser.domain.entity.Status;

public record SellerRequest(
        Long sellerId,
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

    public Seller updatedSeller(Seller seller) {
        return seller.toBuilder()
                .name(this.name())
                .contactInfo(this.contactInfo())
                .businessInfo(this.businessInfo())
                .status(this.status())
                .redirectUrl(this.redirectUrl())
                .build();
    }
}
