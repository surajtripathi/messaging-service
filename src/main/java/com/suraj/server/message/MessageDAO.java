package com.suraj.server.message;

import java.util.List;

public interface MessageDAO {
  void save(Message message);
  List<Message> listMessage(String chatID, Long paginatedID, Integer pageSize);

}
