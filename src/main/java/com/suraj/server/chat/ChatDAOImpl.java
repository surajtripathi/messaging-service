package com.suraj.server.chat;

import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ChatDAOImpl implements ChatDAO {

  public static final String GET_BY_ID = "select * from chat where id = ?";
  SessionFactory sessionFactory;

  @Autowired
  public ChatDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

//  public Chat getChatByID(String id) {
////    return jdbcTemplate.queryForObject(GET_BY_ID, new Object[] {id}, new ChatMapper());
//  }

  public List<Chat> listChat(String userID) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    final Query query =
        session.createQuery(
            "select c from Chat c "
                + " LEFT JOIN c.users u where u.userID = :userID");
    query.setString("userID", userID);
    final List list = query.list();
    session.getTransaction().commit();
    return list;
  }

  public void deleteChat(Chat chat) {
//    return jdbcTemplate.update("delete from chat where id = ?", chat.getId()) > 0;
  }

  public void updateChat(Chat chat) {
//    return jdbcTemplate.update(
//        "update chat set name = ? where id = ?",
//        chat.getName(),
//        chat.getId()) > 0;
  }

  public void createChat(Chat chat) {
    final Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(chat);
    session.getTransaction().commit();
  }
}
