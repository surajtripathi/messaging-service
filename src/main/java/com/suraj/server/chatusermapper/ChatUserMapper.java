package com.suraj.server.chatusermapper;

import com.suraj.server.chat.Chat;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_user_mapper")
//@IdClass(ChatUserMapperPK.class)
public class ChatUserMapper {
//  @Id
//  @Column(name = "chat_id", insertable=false, updatable=false)
//  private String chatID;
  @Id
  @Column(name = "user_id")
  private String userID;

  @ManyToOne
  @JoinColumn(name = "chat_id", referencedColumnName = "id")
  private Chat chat;
}

