package com.twop.urlservice.repository;

import com.twop.urlservice.model.UrlData;

import java.util.Map;

public interface UrlRepository {

    void save(UrlData url);

    Map<String, UrlData> findAll();

    UrlData findById(String smalurl);
}
