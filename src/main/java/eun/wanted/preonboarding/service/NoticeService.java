package eun.wanted.preonboarding.service;

import eun.wanted.preonboarding.dto.NoticeDTO;
import eun.wanted.preonboarding.entity.Notice;
import java.util.List;

public interface NoticeService {

    List<Notice> findAll();

    Notice find(Long noticeId);

    Notice create(NoticeDTO noticeDTO);

    Notice update(Long noticeId, NoticeDTO noticeDTO);

    void delete(Long noticeId);

}
