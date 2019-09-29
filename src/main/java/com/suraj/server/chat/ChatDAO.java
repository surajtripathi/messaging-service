package com.suraj.server.chat;

import java.util.List;

public interface ChatDAO {
  List<Chat> listChat(String userID);
  void deleteChat(Chat chat);
  void updateChat(Chat chat);
  void createChat(Chat chat);
}
