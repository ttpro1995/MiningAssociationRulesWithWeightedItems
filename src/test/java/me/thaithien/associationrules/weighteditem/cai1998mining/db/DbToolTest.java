package me.thaithien.associationrules.weighteditem.cai1998mining.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DbToolTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createTransaction() {
        String inputStr = "1 2 4 5";
        Transaction t = DbTool.createTransaction(inputStr);
        assertEquals(t.get(0), "1");
        assertEquals(t.get(1), "2");
        assertEquals(t.get(2), "4");
        assertEquals(t.get(3), "5");
    }
}