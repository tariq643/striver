package dsa.striver.array.faqMedium;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIII {

    private List<Integer> generateRows (int row) {

        List<Integer> generatedRow = new ArrayList<>();
        generatedRow.add(1);
        for (int i = 1; i < row; i++) {
            generatedRow.add(generatedRow.get(i - 1) * (row - i) / i);
        }
        return generatedRow;
    }

    public List<List<Integer>> pascalTriangleIII(int n) {

        List<List<Integer>> result = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            result.add(this.generateRows(row));
        }
        return result;
    }
}
