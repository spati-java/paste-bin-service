package com.twop.urlservice.repository;

import com.twop.urlservice.model.UrlData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;


@RequiredArgsConstructor
@Repository
public class UrlRepositoryImpl implements UrlRepository {

    private final HashOperations<String, String, UrlData> hashOperations;

    @Override
    public void save(UrlData url) {
        hashOperations.put("URLS", url.getShortUrl(), url);
    }

    @Override
    public Map<String, UrlData> findAll() {
        return hashOperations.entries("URLS");
    }

    public UrlData findById(String smallUrl) {
        return hashOperations.get("URLS", smallUrl);
    }

}
