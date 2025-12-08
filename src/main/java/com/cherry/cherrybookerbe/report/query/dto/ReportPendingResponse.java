package com.cherry.cherrybookerbe.report.query.dto;

import java.time.LocalDateTime;

// 신고 처리 목록 조회 dto
public class ReportPendingResponse {
    private Long targetUserId; // 유저 id fk
    private Long threadId; // 스레드 id fk
    private Long threadReplyId; // 스레드 답글 id fk
    private LocalDateTime createdAt;
    private int reportCount; // 신고 횟수
    private String targetNickname;
    private String content;

    // 기본 생성자
    public ReportPendingResponse() {
    }

    public ReportPendingResponse(
            Long targetUserId,
            Long threadId,
            Long threadReplyId,
            LocalDateTime createdAt,
            int reportCount,
            String targetNickname,
            String content
    ) {
        this.targetUserId = targetUserId;
        this.threadId = threadId;
        this.threadReplyId = threadReplyId;
        this.createdAt = createdAt;
        this.reportCount = reportCount;
        this.targetNickname = targetNickname;
        this.content = content;
    }
    public Long getTargetUserId() {
        return targetUserId;
    }

    public Long getThreadId() {
        return threadId;
    }

    public Long getThreadReplyId() {
        return threadReplyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getReportCount() {
        return reportCount;
    }

    public String getTargetNickname() {
        return targetNickname;
    }

    public String getContent() {
        return content;
    }

}
