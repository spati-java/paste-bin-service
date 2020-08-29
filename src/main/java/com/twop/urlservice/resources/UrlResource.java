package com.twop.urlservice.resources;

import com.twop.urlservice.model.UrlData;
import com.twop.urlservice.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
@RequiredArgsConstructor
public class UrlResource {

    private final UrlService urlService;

    @PostMapping()
    public String saveContent(@PathVariable("userId") @RequestBody UrlData urlData) {
        return "Saved";
    }

    @GetMapping("/{smallUrl}")
    public String findBySmallUrl(@PathVariable("smallUrl") String url) {
        return urlService.findBySmallUrl(url);
    }
}
