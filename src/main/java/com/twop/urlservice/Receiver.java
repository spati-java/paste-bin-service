package com.twop.urlservice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {

    private AtomicInteger counter = new AtomicInteger();

    public void recieveMessage(String message){
            log.info(message);
            counter.incrementAndGet();
    }

    public  int getCount(){
        return counter.get();
    }
}
