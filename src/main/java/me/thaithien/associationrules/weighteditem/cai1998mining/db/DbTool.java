package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import java.util.ArrayList;
import java.util.List;

public class DbTool {

    /**
     * create transaction from one line of input string
     * @param inputStr list of item. Example: 1 3 5 3 1
     * @return
     */
    public static Transaction createTransaction(String inputStr){
        String[] itemStrs = inputStr.split(" ");
        List<String> transactionItem = new ArrayList<>();
        for (String token : itemStrs){
            transactionItem.add(token.trim());
        }
        return new Transaction(transactionItem);
    }
}
