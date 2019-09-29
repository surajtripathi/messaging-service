package com.suraj.server.message;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDAOImpl implements MessageDAO {
  private final SessionFactory sessionFactory;

  @Autowired
  public MessageDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void save(Message message) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(message);
    session.getTransaction().commit();
    System.out.println(session.hashCode());
  }

  public List<Message> listMessage(String chatID, Long paginatedID, Integer pageSize) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    final Query query = session.createQuery("from Message where chatID = :chatID "
        + "and paginationID <= :paginationID "
        + "order by paginationID desc");
    query.setString("chatID", chatID);
    query.setLong("paginationID", paginatedID);
    query.setMaxResults(pageSize);
    session.getTransaction().commit();
    System.out.println(session.hashCode());
    return query.list();
  }
}
