package eun.wanted.preonboarding.dto;

import eun.wanted.preonboarding.entity.Notice;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDetailDTO {
    private Long id;
    private String position;
    private int reward;
    private String tech;
    private String detail;
    private String company;
    private String region;
    private String contry;
    private List<Long> noticeIds;

    public NoticeDetailDTO(final Notice entity) {
        this.id = entity.getId();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.tech = entity.getTech();
        this.detail = entity.getDetail();
        this.company = entity.getCompany().getName();
        this.region = entity.getCompany().getRegion().getName();
        this.contry = entity.getCompany().getRegion().getContry().getName();
        this.noticeIds = entity.getCompany().getNotices().stream().map(Notice::getId).collect(
            Collectors.toList());
    }
}
