package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Transaction {
    private final List<String> transationList;

    public Transaction(List<String> transationList) {
        this.transationList = ImmutableList.copyOf(transationList);
    }

    public String get(int i){
        return transationList.get(i);
    }

    public List<String> getTransationList(){
        return ImmutableList.copyOf(transationList);
    }
}

