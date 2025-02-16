package com.app.design_pattern.observer_pattern.subject;

import com.app.design_pattern.observer_pattern.listner.Listener;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Subject {


    List<Listener> listeners = new ArrayList<>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyAllListener() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void addMovie() {
        notifyAllListener();
    }
     


}

