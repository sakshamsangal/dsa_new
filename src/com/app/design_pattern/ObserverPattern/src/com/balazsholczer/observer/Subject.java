package com.app.design_pattern.ObserverPattern.src.com.balazsholczer.observer;

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyAllObservers();
}
