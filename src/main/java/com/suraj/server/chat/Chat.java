package com.suraj.server.chat;

import com.suraj.server.chatusermapper.ChatUserMapper;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

@Builder
@AllArgsConstructor
@Getter
@Setter
//@ToString
@NoArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {
  @Id
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "type")
  private String type;

  @OneToMany(mappedBy = "chat")
  @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
  private List<ChatUserMapper> users;
}
