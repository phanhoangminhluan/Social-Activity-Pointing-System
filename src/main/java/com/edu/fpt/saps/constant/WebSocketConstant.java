package com.edu.fpt.saps.constant;

public class WebSocketConstant {

    public static final String APP_PREFIX = "/websocket-method";
    public static final String TOPIC_ENDPOINTS[] = {"/websocket-endpoint/qr-code"};

    public static final String MESSAGE_BROKER_PREFIX = "/websocket-topic";
    public static final String QR_CODE_TOPIC = MESSAGE_BROKER_PREFIX + "/qr-code";

    public static final String QR_CODE_METHOD = "/qr-code";
    public static final String QR_CODE_METHOD_WITH_PREFIX = APP_PREFIX + QR_CODE_METHOD;

}
