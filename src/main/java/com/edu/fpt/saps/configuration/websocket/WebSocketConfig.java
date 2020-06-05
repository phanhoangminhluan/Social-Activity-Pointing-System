package com.edu.fpt.saps.configuration.websocket;

import com.edu.fpt.saps.constant.WebSocketConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * Enable a simple message broker and configure one or more prefixes to filter destinations targeting the broker
         * (e.g. destinations prefixed with "/topic").
         * If you don't specify the relevant topic name, then client will fail to subscribe to given topic.
         */
        registry.enableSimpleBroker(WebSocketConstant.MESSAGE_BROKER_PREFIX);

        /**
         * Configure one or more prefixes to filter destinations targeting application annotated methods.
         * When messages are processed, the matching prefix is removed from the destination in order to form the lookup path.
         * This means annotations should not contain the destination prefix.
         */
        registry.setApplicationDestinationPrefixes(WebSocketConstant.APPLICATION_DESTINATION_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        for (int i = 0; i < WebSocketConstant.TOPIC_ENDPOINTS.length; i++) {
            registry.addEndpoint(WebSocketConstant.TOPIC_ENDPOINTS[i])
                    .setAllowedOrigins("*")
                    .withSockJS();
        }
    }
}
