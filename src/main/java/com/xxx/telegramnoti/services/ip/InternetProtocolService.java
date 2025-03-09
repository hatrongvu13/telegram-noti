package com.xxx.telegramnoti.services.ip;

import com.xxx.telegramnoti.data.MessageToGroup;

public interface InternetProtocolService {
    void sendIpToGroup() throws Exception;
    void sendMessageToGroup(MessageToGroup messageToGroup);
}
