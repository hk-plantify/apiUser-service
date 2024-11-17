package com.plantify.apiuser.global.exception.errorcode;

import com.plantify.apiuser.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum SellerErrorCode implements ErrorCode {

    SELLER_ACCESS_DENIED(HttpStatus.FORBIDDEN, "판매자에 대한 접근 권한이 없습니다."),
    SELLER_NOT_FOUND(HttpStatus.NOT_FOUND, "판매자를 찾을 수 없습니다."),
    SELLER_ALREADY_EXISTS(HttpStatus.CONFLICT, "이미 존재하는 판매자입니다."),
    INVALID_SELLER_DATA(HttpStatus.UNPROCESSABLE_ENTITY, "유효하지 않은 판매자 데이터입니다."),
    SELLER_CREATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "판매자 생성에 실패했습니다."),
    SELLER_UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "판매자 업데이트에 실패했습니다."),
    SELLER_DELETE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "판매자 삭제에 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
