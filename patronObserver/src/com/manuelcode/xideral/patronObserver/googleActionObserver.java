package com.manuelcode.xideral.patronObserver;

class googleActionObserver implements googleObserver {
    private double lastPrice;

    public googleActionObserver(googleAction stock) {
        lastPrice = stock.getPrice();
        stock.attach(this);
    }

    public void update(googleAction stock) {
        double currentPrice = stock.getPrice();
        if (currentPrice > lastPrice) {
            System.out.println(stock.getName() + " La acción de Google ha subido de precio. Precio Anterior: " + lastPrice + ", Precio Actual: " + currentPrice);
        } else if (currentPrice < lastPrice) {
            System.out.println(stock.getName() + " La acción de Google ha bajado de precio. Precio Anterior: " + lastPrice + ", Precio Actual: " + currentPrice);
        } else {
            System.out.println(stock.getName() + " La acción de Google ha mantenido su precio de: " + lastPrice + ", Precio actual: " + currentPrice);
        }
        lastPrice = currentPrice;
    }
}
