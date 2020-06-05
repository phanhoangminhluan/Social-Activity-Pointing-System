package com.edu.fpt.saps.utility;

import com.edu.fpt.saps.constant.WebSocketConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
//@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StompClient {

    private static String URL = "ws://localhost:8080"+ WebSocketConstant.TOPIC_ENDPOINTS[0];

    private StompSession session = null;

    private WebSocketStompClient stompClient = null;

    public void connectToTopic() throws ExecutionException, InterruptedException {
        WebSocketClient simpleWebSocketClient = new StandardWebSocketClient();
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(simpleWebSocketClient));
        SockJsClient sockJsClient = new SockJsClient(transports);

        stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

//        StompSessionHandler sessionHandler = new MyStompSessionHandler();
//        session = stompClient.connect(URL, sessionHandler).get();


    }

    public void sendMsg() throws ExecutionException, InterruptedException {
        if(stompClient == null) {
            connectToTopic();
        }
        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        session = stompClient.connect(URL, sessionHandler).get();
    }

}
