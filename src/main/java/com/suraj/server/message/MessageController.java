package com.suraj.server.message;

import com.suraj.server.response.ListMessageResponse;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
  private final MessageDAO messageDAO;

  @Autowired
  public MessageController(MessageDAO messageDAO) {
    this.messageDAO = messageDAO;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ListMessageResponse getMessages(
      @RequestParam("chatID") String chatID,
      @RequestParam(value = "nextPageID", defaultValue = "" + Long.MAX_VALUE) Long paginationID,
      @RequestParam(value = "pageSize", defaultValue = "" + 2) Integer pageSize) {
    if (paginationID == null) {
      paginationID = Long.MAX_VALUE;
    } else {
      paginationID = paginationID - 1;
    }
    return new ListMessageResponse(messageDAO.listMessage(chatID, paginationID, pageSize));
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {"application/JSON"})
  public String createMessage(@RequestBody Message message) {
    message.setId(UUID.randomUUID().toString());
    messageDAO.save(message);
    return message.getId();
  }
}
