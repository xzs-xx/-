package com.ssm.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/{userpath}")
public class Speak {
	private static CopyOnWriteArraySet<Speak> webSocketSet = new CopyOnWriteArraySet<Speak>();
    private static Map<String,Session> userWsSession = new HashMap<String,Session>();
    private String userpath;
    @OnOpen
    public void onOpen(@PathParam("userpath") String userpath,Session session){
        this.userpath = userpath;
        userWsSession.put(this.userpath, session);
        webSocketSet.add(this);
    }
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        userWsSession.remove(this.userpath);
    }
    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println(message);
        String[] arymessage = message.split("\\|");
        System.out.println();
        if(userWsSession.get(arymessage[0])!=null)
        	((Session)userWsSession.get(arymessage[0])).getBasicRemote().sendText(arymessage[1]);
    }
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
    }
}