package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SimpleDbTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadTransactionFromFile() {
        System.out.println("test loadTransactionFromFile");
        SimpleDb db = new SimpleDb();
        db.loadTransactionFromFile("testdata/testtransactionlist.txt");
        List<Transaction> transD = db.getTransactionD();
        assertEquals(transD.get(3).get(2), "4");
    }

    @Test
    public void loadWeightFromFile() {
        System.out.println("test loadWeightFromFile");
        SimpleDb db = new SimpleDb();
        db.loadTransactionFromFile("testdata/testtransactionlist.txt");
        db.loadWeightFromFile("testdata/testweight.txt");
        assertEquals(db.getWeight("1"), new Double(0.1));
        assertEquals(db.getWeight("2"), new Double(0.3));
        assertEquals(db.getWeight("3"), new Double(0.4));
        assertEquals(db.getWeight("4"), new Double(0.8));
        assertEquals(db.getWeight("5"), new Double(0.9));
    }
}