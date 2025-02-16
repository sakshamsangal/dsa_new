package com.app.design_pattern.observer_pattern.subject;

import com.app.design_pattern.observer_pattern.listner.Listener;

public interface Subject {
    void addListener(Listener listener);
    void notifyAllListener();
}
