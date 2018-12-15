package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SimpleDb {
    private List<Transaction> transactionD;
    private List<Long> itemsI;

    public SimpleDb() {
        this.transactionD = new ArrayList();
        this.itemsI = new ArrayList();
    }

    /**
     * load from file
     * one transaction per line
     * @param path file path
     */
    public static void loadTransactionFromFile(String path){
        try {
            Stream<String> ss =  Files.lines(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
