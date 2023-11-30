package com.green.greengram3.feed.model;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name = "피드 API", description = "피드 관련 처리")
public class FeedController {
    private final FeedService service;

    @Operation(summary = "피드 등록")
    @PostMapping
    public ResVo postFeed(@RequestBody FeedInsDto dto) {
        return service.postFeed(dto);
    }

    @Operation(summary = "전체 피드 조회")
    @GetMapping
    public List<FeedSelVo> getAllFeed(int page) {
        return service.getAllFeed(new FeedSelDto(page));
    }
}
