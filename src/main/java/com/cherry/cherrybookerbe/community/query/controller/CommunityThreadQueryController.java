package com.cherry.cherrybookerbe.community.query.controller;

import com.cherry.cherrybookerbe.common.dto.ApiResponse;
import com.cherry.cherrybookerbe.community.query.dto.CommunityThreadDetailResponse;
import com.cherry.cherrybookerbe.community.query.dto.CommunityThreadSummaryResponse;
import com.cherry.cherrybookerbe.community.query.service.CommunityThreadQueryService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/community/threads")
public class CommunityThreadQueryController {

    private final CommunityThreadQueryService communityThreadQueryService;

    public CommunityThreadQueryController(CommunityThreadQueryService communityThreadQueryService) {
        this.communityThreadQueryService = communityThreadQueryService;
    }

    // 커뮤니티 스레드 목록을 조회하는 메소드
    @GetMapping
    public ResponseEntity<ApiResponse<List<CommunityThreadSummaryResponse>>> getThreadList() {
        List<CommunityThreadSummaryResponse> responses = communityThreadQueryService.getThreadList();
        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    // 특정 커뮤니티 스레드의 상세 정보를 조회하는 메소드
    @GetMapping("/{threadId}")
    public ResponseEntity<ApiResponse<CommunityThreadDetailResponse>> getThreadDetail(
            @PathVariable Integer threadId
    ) {
        CommunityThreadDetailResponse response = communityThreadQueryService.getThreadDetail(threadId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
