package AdvancedDSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapSack {
    public static void main(String[] args) {
        // 16,3,3,6,7,8,17,13,7
    }

    public int solve(int[] values, int[] weights, int capacity) {
        int n = values.length;
        ArrayList<ValueByWeight> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ValueByWeight(weights[i], values[i]));
        }

        Collections.sort(arr, new Comparator<ValueByWeight>() {
            @Override
            public int compare(ValueByWeight o1, ValueByWeight o2) {
                if (o1.perUnitValue > o2.perUnitValue)
                    return 1;
                else if (o1.perUnitValue < o2.perUnitValue)
                    return -1;
                return 0;
            }
        });

        Collections.reverse(arr);
        double ans = 0;
        for (ValueByWeight valueByWeight : arr) {
            if (valueByWeight.weight <= capacity) {
                ans += valueByWeight.value;
                capacity -= valueByWeight.weight;
            } else {
                ans += capacity * valueByWeight.perUnitValue;
            }
        }
        return (int) ans * 100;
    }
}

class ValueByWeight {
    public double perUnitValue;
    public int weight;
    public int value;

    public ValueByWeight(int weight, int value) {
        this.weight = weight;
        this.value = value;
        perUnitValue = ((1.0 * this.value) / this.weight);
    }
}
