package com.manuelcode.xideral.patronObserver;

import java.util.ArrayList;
import java.util.List;

class googleAction {
    private String name;
    private double price;
    private List<googleObserver> observers = new ArrayList<>();

    public googleAction(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void attach(googleObserver observer) {
        observers.add(observer);
    }

    public void detach(googleObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (googleObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}