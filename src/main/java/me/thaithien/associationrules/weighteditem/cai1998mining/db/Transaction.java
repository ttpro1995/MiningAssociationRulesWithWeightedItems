package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Transaction {
    private final List<String> transationList;

    public Transaction(List<String> transactionList) {
        this.transationList = ImmutableList.copyOf(transactionList);
    }

    public String get(int i){
        return transationList.get(i);
    }

    public List<String> getTransactionList(){
        return ImmutableList.copyOf(transationList);
    }
}

