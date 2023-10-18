package eun.wanted.preonboarding.service.impl;

import eun.wanted.preonboarding.dto.NoticeDTO;
import eun.wanted.preonboarding.entity.Company;
import eun.wanted.preonboarding.entity.Notice;
import eun.wanted.preonboarding.exception.ErrorCode;
import eun.wanted.preonboarding.exception.GlobalException;
import eun.wanted.preonboarding.repository.CompanyRepository;
import eun.wanted.preonboarding.repository.NoticeRepository;
import eun.wanted.preonboarding.service.NoticeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final CompanyRepository companyRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository,
        CompanyRepository companyRepository) {
        this.noticeRepository = noticeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice find(Long noticeId) {
        Optional<Notice> findByNoticeId = noticeRepository.findById(noticeId);

        Notice notice = findByNoticeId.orElseThrow(
            () -> new GlobalException(ErrorCode.NOTICE_NOT_FOUND));

        return notice;
    }

    @Override
    public Notice create(NoticeDTO noticeDTO) {
        Optional<Company> findByCompanyId = companyRepository.findById(noticeDTO.getCompany_id());

        Company company = findByCompanyId.orElseThrow(
            () -> new GlobalException(ErrorCode.COMPANY_NOT_FOUND));

        Notice notice = NoticeDTO.toEntity(noticeDTO);
        notice.setCompany(company);

        return noticeRepository.save(notice);
    }

    @Override
    public Notice update(Long noticeId, NoticeDTO noticeDTO) {
        Notice notice = find(noticeId);

        notice.setPosition(noticeDTO.getPosition());
        notice.setReward(noticeDTO.getReward());
        notice.setTech(noticeDTO.getTech());
        notice.setDetail(noticeDTO.getDetail());

        return noticeRepository.save(notice);
    }

    @Override
    public void delete(Long noticeId) {
        Notice notice = find(noticeId);

        noticeRepository.delete(notice);
    }
}
