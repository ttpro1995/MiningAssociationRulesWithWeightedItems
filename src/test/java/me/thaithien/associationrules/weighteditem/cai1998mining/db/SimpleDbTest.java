package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    public void supportCountTrans(){
        System.out.println("test supportCountTrans");
        SimpleDb db = new SimpleDb();
        db.loadTransactionFromFile("testdata/testtransactionlist.txt");
        db.loadWeightFromFile("testdata/testweight.txt");
        assertEquals(db.getSupportCount("1"), new Integer(4));
        assertEquals(db.getSupportCount("2"), new Integer(5));
        assertEquals(db.getSupportCount("3"), new Integer(2));
        assertEquals(db.getSupportCount("4"), new Integer(6));
        assertEquals(db.getSupportCount("5"), new Integer(7));
    }

    @Test
    public void testForCopyingSet(){
        Set<String> setA = new HashSet<>();
        setA.add("a");
        setA.add("b");
        Set<String> setB = new HashSet<>(setA);
        setB.add("c");
        setB.remove("a");
        System.out.println("set A");
        for (String item: setA){
            System.out.println(item);
        }
        System.out.println("set B");
        for (String item: setB){
            System.out.println(item);
        }
    }
}