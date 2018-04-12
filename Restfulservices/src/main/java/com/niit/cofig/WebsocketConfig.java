package com.niit.cofig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  // enable broker based stomp messaging
@EnableScheduling
@ComponentScan(basePackages="com.niit.*")
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("REGISTER STOMP ENDPOINTS...");
		registry.addEndpoint("/portfolio").withSockJS();
	}

	
	public void configureMessageBroker(MessageBrokerRegistry  configurer) {
		System.out.println("CONFIGURE MESSAGE BROKER REGISTRY");
		configurer.enableSimpleBroker("/queue/", "/topic/");
		configurer.setApplicationDestinationPrefixes("/app");
	}


	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}


	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

}