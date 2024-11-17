package com.plantify.apiuser.service;

public interface InternalService {

    void recordActivityLog(String targetType, Long targetId, String actionType, Long adminId);
}
