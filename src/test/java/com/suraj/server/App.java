package com.suraj.server;

import com.suraj.server.chat.Chat;
import com.suraj.server.chat.ChatDAO;
import com.suraj.server.message.Message;
import com.suraj.server.message.MessageDAO;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringBootDemoApplication.class);
        ChatDAO chatDAO = context.getBean(ChatDAO.class);

        for (Chat chat: chatDAO.listChat("1")) {
            System.out.println(chat.toString());
        }

        MessageDAO messageDAO = context.getBean(MessageDAO.class);

        final List<Message> page1 = messageDAO
            .listMessage(
                "d381d687-20d9-4d2d-9896-9b253750fcd2",
                5L,
                2);
        final List<Message> page2 = messageDAO
            .listMessage(
                "d381d687-20d9-4d2d-9896-9b253750fcd2",
                page1.get(page1.size() - 1).getPaginationID() - 1,
                2);
        for(Message message : page1) {
            System.out.println(message.toString());
        }
        for(Message message : page2) {
            System.out.println(message.toString());
        }
    }
}
