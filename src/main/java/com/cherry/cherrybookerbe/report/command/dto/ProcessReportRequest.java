package com.cherry.cherrybookerbe.report.command.dto;

import com.cherry.cherrybookerbe.report.domain.ReportStatus;

// 관리자 판단 dto. 관리자가valid, reject할지 선택
public class ProcessReportRequest {
    private Long targetUserId;
    private ReportStatus status;

    public ProcessReportRequest() {}

    public Long getTargetUserId() {
        return targetUserId;
    }
    public ReportStatus getStatus() {
        return status;
    }
}
