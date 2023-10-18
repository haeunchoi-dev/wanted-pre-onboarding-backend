package eun.wanted.preonboarding.service;

import eun.wanted.preonboarding.dto.NoticeDTO;
import eun.wanted.preonboarding.entity.Notice;

public interface NoticeService {

    Notice create(NoticeDTO noticeDTO);
    Notice update(Long noticeId,NoticeDTO noticeDTO);
}
