package com.plantify.apiuser.client;

import com.plantify.apiuser.config.FeignClientConfig;
import com.plantify.apiuser.domain.dto.request.ActivityLogRequest;
import com.plantify.apiuser.global.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "admin-service", url = "${admin.service.url}",  configuration = FeignClientConfig.class)
public interface ActivityLogServiceClient {

    @PostMapping("/v1/admin/activity-logs")
    ApiResponse<Void> recordActivityLog(@RequestBody ActivityLogRequest requset);
}
