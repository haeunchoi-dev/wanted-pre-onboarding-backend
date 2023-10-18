package eun.wanted.preonboarding.controller;

import eun.wanted.preonboarding.dto.NoticeDTO;
import eun.wanted.preonboarding.dto.ResponseDTO;
import eun.wanted.preonboarding.entity.Notice;
import eun.wanted.preonboarding.service.NoticeService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Object> createNotice(@RequestBody NoticeDTO noticeDTO) {
        Notice notice = noticeService.create(noticeDTO);
        NoticeDTO dto = new NoticeDTO(notice);
        ResponseDTO<NoticeDTO> response = ResponseDTO.<NoticeDTO>builder().data(dto).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> updateNotice(@RequestBody NoticeDTO noticeDTO,
        @PathVariable(name = "id") Long noticeId) {

        Notice updateNotice = noticeService.update(noticeId, noticeDTO);

        NoticeDTO dto = new NoticeDTO(updateNotice);
        ResponseDTO<NoticeDTO> response = ResponseDTO.<NoticeDTO>builder().data(dto).build();
        return ResponseEntity.ok(response);
    }

}
