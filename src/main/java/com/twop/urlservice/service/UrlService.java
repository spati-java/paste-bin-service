package com.twop.urlservice.service;

import com.twop.urlservice.Receiver;
import com.twop.urlservice.model.UrlData;
import com.twop.urlservice.repository.UrlRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UrlService {

    private  final UrlRepository urlRepository;

    private final Receiver receiver;

    public void sendData( UrlData urlData){
        urlRepository.save(urlData);
    }

    public Map<String,UrlData> findAll() {
        return urlRepository.findAll();
    }

    public String findBySmallUrl(String url) {
        return urlRepository.findById(url).getUrl();
    }
}
