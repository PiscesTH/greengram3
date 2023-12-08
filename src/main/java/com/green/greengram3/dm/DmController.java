package com.green.greengram3.dm;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        dto.setRowCount(Const.DM_MSG_COUNT_PER_PAGE);
        dto.setStartIdx((dto.getPage() - 1) * Const.DM_MSG_COUNT_PER_PAGE);
        return service.getMsgAll(dto);
    }
    @Operation(summary = "dm 리스트 불러오기")
    @GetMapping
    public List<DmSelVo> getDmAll(DmSelDto dto) {
        return service.getDmAll(dto);
    }
    @Operation(summary = "dm 메세지 작성")
    @PostMapping("/msg")
    public ResVo postDmMsg(@RequestBody DmInsMsgDto dto){
        return service.postDmMsg(dto);
    }
}
