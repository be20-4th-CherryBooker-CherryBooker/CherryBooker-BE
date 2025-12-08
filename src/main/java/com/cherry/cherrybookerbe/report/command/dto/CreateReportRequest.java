package com.cherry.cherrybookerbe.report.command.dto;

import com.cherry.cherrybookerbe.community.command.domain.entity.CommunityThread;
import com.cherry.cherrybookerbe.user.command.domain.entity.User;

// 신고 등록 ; 신고 1건 생성
public class CreateReportRequest {
    private Long targetUserId; // 신고받은 유저 id fk
    private Long threadId; // 스레드 id fk
    private Long threadsReplyId; // 스레드 답글 id fk

    public CreateReportRequest() {}
    public Long getTargetUserId() {
        return targetUserId;
    }
    public Long getThreadId() {
        return threadId;
    }
    public Long getThreadsReplyId() {
        return threadsReplyId;
    }
}
