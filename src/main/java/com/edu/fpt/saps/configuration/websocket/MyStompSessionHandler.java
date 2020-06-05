package com.edu.fpt.saps.configuration.websocket;

import com.edu.fpt.saps.constant.WebSocketConstant;
import com.edu.fpt.saps.dto.UuidDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//        logger.info("New session established : " + session.getSessionId());
        session.subscribe(WebSocketConstant.QR_CODE_TOPIC, this);
//        logger.info("Subscribed to " + WebSocketConstant.QR_CODE_TOPIC);
        session.send(WebSocketConstant.QR_CODE_METHOD_WITH_PREFIX, "Generate new QR");
//        logger.info("Message sent to websocket server");
        session.disconnect();
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return UuidDTO.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        UuidDTO msg = (UuidDTO) payload;
//        logger.info("Received : " + msg.getUuid());
    }

}
