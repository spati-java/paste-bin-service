package com.twop.urlservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RedisHash("UrlData")
@AllArgsConstructor
@NoArgsConstructor
public class UrlData implements Serializable {
    private String url;
    private String shortUrl;
    private String content;
    private LocalDate createdAt;
    private LocalDate expiredDate;
    private String userId;
}
