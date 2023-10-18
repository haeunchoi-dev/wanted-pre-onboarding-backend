package eun.wanted.preonboarding.dto;

import eun.wanted.preonboarding.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticesDto {
    private Long id;
    private String position;
    private int reward;
    private String tech;
    private String company;
    private String region;
    private String contry;

    public NoticesDto(final Notice entity) {
        this.id = entity.getId();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.tech = entity.getTech();
        this.company = entity.getCompany().getName();
        this.region = entity.getCompany().getRegion().getName();
        this.contry = entity.getCompany().getRegion().getContry().getName();
    }
}
