package com.app.design_pattern.observer_pattern.listner;

public class MessageListener implements Listener {
    @Override
    public void update() {
        System.out.println("msg");
    }
}
