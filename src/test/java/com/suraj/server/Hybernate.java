package com.suraj.server;

import com.suraj.server.message.Message;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Hybernate {

  public Hybernate() {

  }

  public void setup() {
//    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//        .configure("hibernate.cfg.xml")
//        .build();
//    final Metadata metadata = new MetadataSources(registry).buildMetadata();
//    final SessionFactory sessionFactory = metadata.buildSessionFactory();
//    final Session session = sessionFactory.openSession();
//    Transaction transaction = session.beginTransaction();
//    session.save(Chat.builder().id(UUID.randomUUID().toString()).name("hiberrnate").type("group").build());
//    transaction.commit();
//    System.out.println("saved chat");
//    sessionFactory.close();
//    session.close();
  }

  public static void main(String[] args) {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
    final Metadata metadata = new MetadataSources(registry).buildMetadata();
    final SessionFactory sessionFactory = metadata.buildSessionFactory();
    final Session session = sessionFactory.openSession();
    //tempChanges(session);

//    saveMessages(session);
    final Query query = getMessageQuery(session, Long.MAX_VALUE);
    final List list = query.list();
    final Query query1 = getMessageQuery(session, ((Message)list.get(list.size() - 1)).getPaginationID() -  1);
    final List list1 = query1.list();
    sessionFactory.close();
    session.close();
  }

  private static Query getMessageQuery(Session session, long maxValue) {
    final Query query = session.createQuery("from Message where chatID = :chatID "
        + "and paginationID <= :paginationID "
        + "order by paginationID desc");
    query.setString("chatID", "d381d687-20d9-4d2d-9896-9b253750fcd2");
    query.setLong("paginationID", maxValue);
    query.setMaxResults(2);
    return query;
  }

  private static void saveMessages(Session session) {
    final Message m1 = Message
        .builder()
        .id(UUID.randomUUID().toString())
        .chatID("d381d687-20d9-4d2d-9896-9b253750fcd2")
        .senderID("1")
        .message("Hello sooji,")
        .type("TEXT")
        .build();
    final Message m2 = Message
        .builder()
        .id(UUID.randomUUID().toString())
        .chatID("d381d687-20d9-4d2d-9896-9b253750fcd2")
        .senderID("2")
        .message("Hello billi,")
        .type("TEXT")
        .build();
    session.beginTransaction();
    session.save(m1);
    session.save(m2);
    session.getTransaction().commit();
  }

  private static void tempChanges(Session session) {
    //    session.beginTransaction();
//    final Chat chat =
//        Chat.builder()
//            .id(UUID.randomUUID().toString())
//            .name("hiberrnate")
//            .type("group")
//            .build();
//    final ChatUserMapper chatUserMapperOne = ChatUserMapper
//        .builder()
////        .chatID(chat.getId())
//        .userID("1")
//        .chat(chat)
//        .build();
//    final ChatUserMapper chatUserMapperTwo = ChatUserMapper
//        .builder()
////        .chatID(chat.getId())
//        .userID("2")
//        .chat(chat)
//        .build();
////    chat.setUsers(Arrays.asList(chatUserMapperOne, chatUserMapperTwo));
//    session.save(chat);
//    session.save(chatUserMapperOne);
//    session.save(chatUserMapperTwo);
//    session.getTransaction().commit();
//    System.out.println("saved chat");
//    final Transaction transaction1 = session.beginTransaction();
//    final ChatUserMapper chatUserMapper = session
//        .byId(ChatUserMapper.class)
//        .load(new ChatUserMapperPK(chatUserMapperTwo.getChatID(), chatUserMapperTwo.getUserID()));
//    transaction1.commit();
    session.beginTransaction();
    //    final Query query = session.createQuery("from " + ChatUserMapper.class.getSimpleName() + "
    // where userID = :userID");
    //    query.setString("userID", "1");
    //    final List list = query.list();
    final Query query =
        session.createQuery(
            "select c from Chat c "
                + " LEFT JOIN c.users u where u.userID = :userID");
    query.setString("userID", "1");
    final List list = query.list();
    session.getTransaction().commit();
  }
}
