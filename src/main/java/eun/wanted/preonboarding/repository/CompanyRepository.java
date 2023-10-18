package eun.wanted.preonboarding.repository;

import eun.wanted.preonboarding.entity.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Override
    Optional<Company> findById(Long companyId);
}