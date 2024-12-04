package com.service.impl;

import com.po.Ride;
import com.po.Visitor;
import com.service.RideInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.List;

public class RideInterfaceImpl implements RideInterface {
    private static Deque<Visitor> visitorDeque = new LinkedList<>();
    private static Deque<Visitor> historyDeque = new LinkedList<>();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        try {
            visitorDeque.addFirst(visitor);
            System.out.println("addVisitorToQueue Success");
        }catch (Exception e){
            System.out.println("addVisitorToQueue error");
        }
    }

    @Override
    public void removeVisitorToQueue(Visitor visitor) {
        try {
            Visitor one = visitorDeque.removeFirst();
            System.out.println("removeVisitorToQueue message: "+one.toString());
            System.out.println("removeVisitorToQueue Success");
        }catch (Exception e){
            System.out.println("removeVisitorToQueue error");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("printQueue:");
        visitorDeque.forEach(item-> System.out.println(item.toString()));
    }

    @Override
    public void runOneCycle(Ride ride) {
        for (int i = 0; i < ride.getMaxRider(); i++) {
            Visitor visitor = visitorDeque.removeFirst();
            historyDeque.addFirst(visitor);
            int numOfCycles = ride.getNumOfCycles();
            ride.setNumOfCycles(numOfCycles++);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        try {
            historyDeque.addFirst(visitor);
            System.out.println("addVisitorToHistory Success");
        }catch (Exception e){
            System.out.println("addVisitorToHistory error");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        for (Visitor item : historyDeque) {
            if (item==visitor) return true;
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return historyDeque.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("printRideHistory:");
        historyDeque.forEach(item-> System.out.println(item.toString()));
    }

    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor visitor : historyDeque) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getSex() + "," + visitor.getPrice() + "," + simpleDateFormat.format(visitor.getTime()));
                writer.newLine();
            }
            System.out.println("Ride history exported successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error exporting ride history");
        }
    }


    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split(",");
                Visitor visitor = new Visitor(split[0], split[1], split[2], split[3], simpleDateFormat.parse(split[4]));
                addVisitorToHistory(visitor);
            }
            System.out.println("Ride history imported successfully from " + filePath);
        } catch (IOException | ParseException e) {
            System.err.println("Error importing ride history: " + e.getMessage());
        }
    }
}
