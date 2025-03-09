package com.xxx.telegramnoti.services.task;

import com.xxx.telegramnoti.services.ip.InternetProtocolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final InternetProtocolService internetProtocolService;
    @Scheduled(cron = "0 0 * * * *")
    @Override
    public void sendIp() throws Exception {
        log.info("start send ip");
        internetProtocolService.sendIpToGroup();
        log.info("end send ip");
    }
}
