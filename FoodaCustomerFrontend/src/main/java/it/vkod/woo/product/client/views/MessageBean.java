package it.vkod.woo.product.client.views;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MessageBean {

    public String getMessage() {
        return "Button was clicked at " + LocalTime.now();
    }
}
