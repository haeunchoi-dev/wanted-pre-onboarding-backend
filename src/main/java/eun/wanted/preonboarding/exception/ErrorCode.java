package eun.wanted.preonboarding.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMPANY_NOT_FOUND("회사가 없습니다."),
    NOTICE_NOT_FOUND("채용공고가 없습니다.");
    private final String message;
}
