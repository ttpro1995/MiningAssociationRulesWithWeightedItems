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
}