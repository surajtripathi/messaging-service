package com.suraj.server.response;

import com.suraj.server.message.Message;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ListMessageResponse {
  private final List<Message> messages;
  private final Long nextPageID;

  public ListMessageResponse(List<Message> messages) {
    this.messages = messages;
    this.nextPageID = messages.size() - 1 >= 0 ? messages.get(messages.size() - 1).getPaginationID() : -1;
  }
}
