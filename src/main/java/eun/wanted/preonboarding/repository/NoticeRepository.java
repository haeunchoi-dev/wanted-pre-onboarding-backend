package eun.wanted.preonboarding.repository;

import eun.wanted.preonboarding.entity.Notice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  NoticeRepository extends JpaRepository<Notice, Long> {
    @Override
    Optional<Notice> findById(Long noticeId);
    @Override
    List<Notice> findAll();
}
