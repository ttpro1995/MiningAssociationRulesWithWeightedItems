package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class SimpleDb {
    private List<Transaction> transactionD;
    private Set<String> itemsI;
    private Map<String, Double> weightsW;
    private Map<String, Integer> supportCounts;

    public SimpleDb() {
        this.transactionD = new ArrayList();
        this.itemsI = new HashSet<>();
        this.weightsW = new HashMap<>();
        this.supportCounts = new HashMap<>();
    }

    /**
     * load from file
     * one transaction per line
     * @param path file path
     */
    public void loadTransactionFromFile(String path){
        try {
            Stream<String> ss =  Files.lines(Paths.get(path));
            ss.map(DbTool::createTransaction)
              .forEach(transaction -> {
                  this.transactionD.add(transaction);
                  supportCountTrans(transaction);
              });

            transactionD.stream().parallel()
                    .flatMap(transaction -> transaction.getTransactionList().stream())
                    .forEach(item -> this.itemsI.add(item));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load weight from file
     * @param path
     */
    public void loadWeightFromFile(String path){
        try {
            Stream<String> ss =  Files.lines(Paths.get(path));
            ss.forEach(line -> {
                String[] itemStrs = line.split(" ");
                String item = itemStrs[0];
                Double weight = Double.valueOf(itemStrs[1]);
                this.weightsW.put(item, weight);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactionD(){
        return transactionD;
    }

    public Double getWeight(String item){
        try{
            return this.weightsW.get(item);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0.0;
    }

    public Integer getSupportCount(String item){
        try{
            return this.supportCounts.get(item);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * support count for item in transaction
     * @param trans
     */
    private void supportCountTrans(Transaction trans){
        Set<String> transItem = new HashSet(trans.getTransactionList());
        transItem.stream().forEach(item -> {
            if (this.supportCounts.containsKey(item)){
                this.supportCounts.put(item, this.supportCounts.get(item) + 1);
            } else {
                this.supportCounts.put(item, 1);
            }
        });
    }

}
