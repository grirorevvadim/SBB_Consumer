package com.tsystems.sbb.service;

import com.tsystems.sbb.entity.BoardDTO;
import com.tsystems.sbb.entity.Greeting;
import com.tsystems.sbb.entity.ScheduleDTO;
import com.tsystems.sbb.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyListener {
    public static List<BoardDTO> boards;
//    public void listenUser(String string) {
//        System.out.println("Message from the queue: " + string);
//    }

    @RabbitListener(queues = "schedules")
    public void listenUser(List<BoardDTO> boards) {
        MyListener.boards = boards;
    }

    @RabbitListener(queues = "notification")
    @SendTo("/topic/greetings")
    public Greeting listenNotification(String notification) {
        return new Greeting();
    }
}