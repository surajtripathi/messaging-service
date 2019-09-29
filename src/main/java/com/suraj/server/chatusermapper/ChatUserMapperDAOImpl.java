package com.suraj.server.chatusermapper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatUserMapperDAOImpl implements ChatUserMapperDAO {
  private final SessionFactory sessionFactory;

  @Autowired
  public ChatUserMapperDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  public boolean createChatUserMapper(ChatUserMapper chatUserMapper) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(chatUserMapper);
    session.getTransaction().commit();
    session.close();
    return true;
  }
}
