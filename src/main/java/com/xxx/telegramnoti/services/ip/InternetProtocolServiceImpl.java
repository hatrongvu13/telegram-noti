package com.xxx.telegramnoti.services.ip;

import com.xxx.telegramnoti.bot.JaxtonyBot;
import com.xxx.telegramnoti.data.MessageToGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class InternetProtocolServiceImpl implements InternetProtocolService {
    private final JaxtonyBot jaxtonyBot;
    @Value("${telegram.bot.chatId}")
    private Long chatId;

    @Override
    public void sendIpToGroup() throws Exception {
        SendMessage sendMessage = SendMessage.builder().chatId(chatId).text(getIp()).build();
        jaxtonyBot.sendMessage(sendMessage);
    }

    @Override
    public void sendMessageToGroup(MessageToGroup messageToGroup) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(messageToGroup.getGroupId())
                .text(messageToGroup.getMessage())
                .build();
        jaxtonyBot.sendMessage(sendMessage);
    }

    public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
