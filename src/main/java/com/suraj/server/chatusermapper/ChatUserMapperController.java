package com.suraj.server.chatusermapper;

import com.suraj.server.chat.Chat;
import com.suraj.server.chat.ChatDAO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatusermappers")
public class ChatUserMapperController {
  private final ChatUserMapperDAO chatUserMapperDAO;

  @Autowired
  public ChatUserMapperController(
      ChatUserMapperDAO chatUserMapperDAO) {
    this.chatUserMapperDAO = chatUserMapperDAO;
  }


  @RequestMapping(method = RequestMethod.POST, consumes = {"application/JSON"}, produces = {"application/JSON"})
  public Map<String, String> createChat(@RequestBody() ChatUserMapper chatUserMapper) {
    chatUserMapperDAO.createChatUserMapper(chatUserMapper);
    return new HashMap<>();
  }
}
