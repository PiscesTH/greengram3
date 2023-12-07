package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmSelMsgDto;
import com.green.greengram3.dm.model.DmSelMsgVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
public class DmController {
    private final DmService service;

    @Operation(summary = "dm 불러오기")
    @GetMapping("/msg")
    public List<DmSelMsgVo> getMsgAll(DmSelMsgDto dto) {
        log.info("dto : {}", dto);
        return service.getMsgAll(dto);
    }
}
