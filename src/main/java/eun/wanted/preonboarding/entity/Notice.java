package eun.wanted.preonboarding.entity;

import eun.wanted.preonboarding.entity.common.DateField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Table(name = "notices")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Notice extends DateField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String position;
    @Setter
    private int reward;
    @Setter
    private String tech;
    @Setter
    @Lob
    private String detail;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Notice(String position, int reward, String tech, String detail, Company company) {
        this.position = position;
        this.reward = reward;
        this.tech = tech;
        this.detail = detail;
        this.company = company;
    }

    public static Notice of(String position, int reward, String tech, String detail, Company company) {
        return new Notice(position, reward, tech, detail, company);
    }
}
