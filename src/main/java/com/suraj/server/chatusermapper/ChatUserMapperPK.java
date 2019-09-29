package com.suraj.server.chatusermapper;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ChatUserMapperPK implements Serializable {
  private String chatID;
  private String userID;
}
