package com.suraj.server.chat;

import com.suraj.server.response.ChatResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
public class ChatController {
  private final ChatDAO chatDAO;

  @Autowired
  public ChatController(ChatDAO chatDAO) {
    this.chatDAO = chatDAO;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<ChatResponse> ListChat(@RequestParam("userID") String userID) {
    return chatDAO
        .listChat(userID)
        .stream()
        .map(ChatResponse::from)
        .collect(Collectors.toList());
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {"application/JSON"})
  public String createChat(@RequestBody() Chat chat) {
    chat.setId(UUID.randomUUID().toString());
    chatDAO
        .createChat(chat);
    return chat.getId();
  }
}
