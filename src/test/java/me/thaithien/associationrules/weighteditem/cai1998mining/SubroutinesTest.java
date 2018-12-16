package me.thaithien.associationrules.weighteditem.cai1998mining;

import me.thaithien.associationrules.weighteditem.cai1998mining.db.SimpleDb;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SubroutinesTest {

    @Test
    public void calW() {
        SimpleDb db = new SimpleDb();
        db.loadTransactionFromFile("testdata/testtransactionlist.txt");
        db.loadWeightFromFile("testdata/testweight.txt");
        Set<String> itemSet = new HashSet<>();
        int k = 3;
        itemSet.add("2");
        itemSet.add("4");
        Double w = Subroutines.calW(itemSet, k, db.getWeightMap(), db.getItemsI());
        assertEquals(w, new Double(0.3 + 0.8 + 0.9));
    }
}