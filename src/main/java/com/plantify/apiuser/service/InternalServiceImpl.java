package com.plantify.apiuser.service;

import com.plantify.apiuser.client.ActivityLogServiceClient;
import com.plantify.apiuser.domain.dto.request.ActivityLogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternalServiceImpl implements InternalService {

    private final ActivityLogServiceClient activityLogServiceClient;

    @Override
    public void recordActivityLog(String targetType, Long targetId, String actionType, Long adminId) {
        ActivityLogRequest request = new ActivityLogRequest(
                targetType,
                targetId,
                actionType,
                adminId,
                false,
                null
        );
        activityLogServiceClient.recordActivityLog(request);
    }
}

