package com.service;

import com.po.Ride;
import com.po.Visitor;

public interface RideInterface {
    public void addVisitorToQueue(Visitor visitor);
    public void removeVisitorToQueue(Visitor visitor);
    public void printQueue();
    public void runOneCycle(Ride ride);
    public void addVisitorToHistory(Visitor visitor);
    public boolean checkVisitorFromHistory(Visitor visitor);
    public int numberOfVisitors();
    public void printRideHistory();
}
