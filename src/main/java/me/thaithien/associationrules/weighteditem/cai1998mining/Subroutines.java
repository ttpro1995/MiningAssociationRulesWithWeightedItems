package me.thaithien.associationrules.weighteditem.cai1998mining;

import me.thaithien.associationrules.weighteditem.cai1998mining.db.SimpleDb;

import java.util.*;

public class Subroutines {

    public static Integer search(SimpleDb db){
        return db.getMaxLength();
    }

    /**
     * calculate maximum possible weight for anny k itemset containing Y
     * @param itemsetY
     * @param k
     * @param weightmapW
     * @return
     */
    public static double calW(Set<String> itemsetY, int k, Map<String, Double> weightmapW, Set<String> allItem){
        Double result = new Double(0);
        for (String item: itemsetY){
            result += weightmapW.get(item);
        }

        Set<String> remainingItems = new HashSet<>(allItem);
        remainingItems.removeAll(itemsetY);

        List<Double> remainingWeight = new ArrayList<>();

        remainingItems.stream().forEach(item->{
            Double weight = weightmapW.get(item);
            remainingWeight.add(weight);
        });

        Collections.sort(remainingWeight, Collections.reverseOrder());

        int q = itemsetY.size();
        int k_q = k - q;
        assert k_q > 0;

        for (int i = 0; i < k_q; i ++){
            result += remainingWeight.get(i);
        }

        return result;
    }

    /**
     * calculate k support bound of Y
     * @param itemsetY
     * @param k
     * @param wminsup
     * @param nTransaction
     * @param weightmapW
     * @param allItem
     * @return
     */
    public static Double calB(Set<String> itemsetY, int k, double wminsup, int nTransaction, Map<String, Double> weightmapW, Set<String> allItem){
        double w = calW(itemsetY, k, weightmapW, allItem);
        double b = Math.ceil(wminsup * nTransaction / w);
        return b;
    }
}
