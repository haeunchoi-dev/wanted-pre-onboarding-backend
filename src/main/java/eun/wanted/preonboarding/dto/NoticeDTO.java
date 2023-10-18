package eun.wanted.preonboarding.dto;

import eun.wanted.preonboarding.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDTO {
    private Long id;
    private String position;
    private int reward;
    private String tech;
    private String detail;
    private Long company_id;

    public NoticeDTO(final Notice entity) {
        this.id = entity.getId();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.tech = entity.getTech();
        this.detail = entity.getDetail();
        this.company_id = entity.getCompany().getId();
    }

    public static Notice toEntity(final NoticeDTO dto) {
        return Notice.builder()
            .id(dto.getId())
            .position(dto.getPosition())
            .reward(dto.getReward())
            .tech(dto.getTech())
            .detail(dto.getDetail())
            .build();
    }
}
