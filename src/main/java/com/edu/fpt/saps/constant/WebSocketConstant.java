package com.edu.fpt.saps.constant;

public class WebSocketConstant {

    public static final String MESSAGE_BROKER_PREFIX = "/mb-qr";
    public static final String APPLICATION_DESTINATION_PREFIX = "/ws-saps";
    public static final String TOPIC_ENDPOINTS[] = {"/qr-code-ws"};

    public static final String QR_CODE_SUBSCRIPTION = MESSAGE_BROKER_PREFIX + "/id";
    public static final String MESSAGE_MAPPING_GENERATE_QR_CODE = "/qr-code";

    public static final String QR_CODE_APP = APPLICATION_DESTINATION_PREFIX + MESSAGE_MAPPING_GENERATE_QR_CODE;

}
