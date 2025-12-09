package com.cherry.cherrybookerbe.community.command.controller;

import com.cherry.cherrybookerbe.common.dto.ApiResponse;
import com.cherry.cherrybookerbe.community.command.dto.request.CreateCommunityReplyRequest;
import com.cherry.cherrybookerbe.community.command.dto.request.CreateCommunityThreadRequest;
import com.cherry.cherrybookerbe.community.command.dto.request.UpdateCommunityReplyRequest;
import com.cherry.cherrybookerbe.community.command.dto.request.UpdateCommunityThreadRequest;
import com.cherry.cherrybookerbe.community.command.dto.response.CommunityReplyCommandResponse;
import com.cherry.cherrybookerbe.community.command.dto.response.CommunityThreadCommandResponse;
import com.cherry.cherrybookerbe.community.command.service.CommunityThreadCommandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/community/threads")
public class CommunityThreadCommandController {

    private final CommunityThreadCommandService communityThreadCommandService;

    public CommunityThreadCommandController(CommunityThreadCommandService communityThreadCommandService) {
        this.communityThreadCommandService = communityThreadCommandService;
    }

    // 커뮤니티의 최초 스레드를 생성하는 메소드
    @PostMapping
    public ResponseEntity<ApiResponse<CommunityThreadCommandResponse>> createThread(
            @Valid @RequestBody CreateCommunityThreadRequest request
    ) {
        CommunityThreadCommandResponse response = communityThreadCommandService.createThread(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    // 기존 커뮤니티 스레드를 수정하는 메소드
    @PutMapping("/{threadId}")
    public ResponseEntity<ApiResponse<CommunityThreadCommandResponse>> updateThread(
            @PathVariable Integer threadId,
            @Valid @RequestBody UpdateCommunityThreadRequest request
    ) {
        CommunityThreadCommandResponse response = communityThreadCommandService.updateThread(threadId, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 기존 커뮤니티 스레드를 삭제하는 메소드
    @DeleteMapping("/{threadId}")
    public ResponseEntity<ApiResponse<Void>> deleteThread(@PathVariable Integer threadId) {
        communityThreadCommandService.deleteThread(threadId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    // 특정 스레드에 릴레이(답글)를 생성하는 메소드
    @PostMapping("/{threadId}/replies")
    public ResponseEntity<ApiResponse<CommunityReplyCommandResponse>> createReply(
            @PathVariable Integer threadId,
            @Valid @RequestBody CreateCommunityReplyRequest request
    ) {
        CommunityReplyCommandResponse response = communityThreadCommandService.createReply(threadId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    // 기존 릴레이(답글)를 수정하는 메소드
    @PutMapping("/replies/{replyId}")
    public ResponseEntity<ApiResponse<CommunityReplyCommandResponse>> updateReply(
            @PathVariable Integer replyId,
            @Valid @RequestBody UpdateCommunityReplyRequest request
    ) {
        CommunityReplyCommandResponse response = communityThreadCommandService.updateReply(replyId, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 기존 릴레이(답글)를 삭제하는 메소드
    @DeleteMapping("/replies/{replyId}")
    public ResponseEntity<ApiResponse<Void>> deleteReply(@PathVariable Integer replyId) {
        communityThreadCommandService.deleteReply(replyId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
