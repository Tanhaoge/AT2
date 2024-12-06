package com.VisitorComparator;

import com.po.Visitor;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return v1.getAge().compareTo(v2.getAge());
    }
}