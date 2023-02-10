package com.manuelcode.xideral.patronObserver;

public class googleRunObserver {
	
    public static void main(String[] args) {
    	
        googleAction google = new googleAction("Google", 1000.0);
        
        googleActionObserver observer1 = new googleActionObserver(google);
        
        google.setPrice(1100.0);
        google.setPrice(900.0);
        google.setPrice(900.0);
        google.setPrice(850);
        
        
    }
}

