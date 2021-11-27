package com.tsystems.sbb.service;

import com.tsystems.sbb.entity.BoardDTO;
import com.tsystems.sbb.entity.Greeting;
import com.tsystems.sbb.entity.ScheduleDTO;
import com.tsystems.sbb.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyListener {
    private final SimpMessagingTemplate simpMessagingTemplate;
    public static List<BoardDTO> boards;

    @RabbitListener(queues = "schedules")
    public void listenUser(List<BoardDTO> boards) {
        MyListener.boards = boards;
    }

    @RabbitListener(queues = "notification")
    public void listenNotification(String notification) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting(notification));
    }
}