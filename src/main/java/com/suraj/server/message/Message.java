package com.suraj.server.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "chat_id")
  private String chatID;
  @Column(name = "sender_id")
  private String senderID;
  @Column(name = "message")
  private String message;
  @Column(name = "type")
  private String type;
  @Column(name = "pagination_id")
  @Generated(GenerationTime.INSERT)
  private Long paginationID;
}
