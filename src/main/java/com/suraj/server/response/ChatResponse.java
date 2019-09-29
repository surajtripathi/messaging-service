package com.suraj.server.response;

import com.suraj.server.chat.Chat;
import com.suraj.server.chatusermapper.ChatUserMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class ChatResponse {
  private final String id;
  private final String name;
  private final String type;
  private final List<String> userID;

  public static ChatResponse from(Chat chat) {
    return ChatResponse.builder()
        .id(chat.getId())
        .name(chat.getName())
        .type(chat.getType())
        .userID(
            chat.getUsers().stream().map(ChatUserMapper::getUserID).collect(Collectors.toList()))
        .build();
  }
}
