package com.hzml.basic;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/user/{id}",encoders = MessageEncoder.class,decoders = MessageDecoder.class)
public class UserEndpoint {

    @OnOpen
    public void onOpen(Session session,@PathParam("id") Long id) {
        System.out.println("websocket open:" + id);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("websocket close");
    }

    @OnError
    public void onError(Session session,Throwable e) {
        e.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, Message message) {
        System.out.println("receive new message:" + message.toString());
    }
}
