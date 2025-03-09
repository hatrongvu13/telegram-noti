package com.xxx.telegramnoti.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageToGroup {
    @NotNull
    private String message;
    private long groupId;
}
