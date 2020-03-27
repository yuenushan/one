package com.example.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetRow {

    /**
     *
     * @param rowIndex
     * @return
     */
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<>(rowIndex + 1);
//        for (int i = 0; i < rowIndex + 1; i++) {
//            row.add(1);
//        }
//        for (int i = 0; i <= rowIndex; i++) {
//            for (int j = 0; j < Math.ceil((i + 1) / 2.0); j++) {
//                int val;
//                if (j == 0) {
//                    val = 1;
//                } else {
//                    val = row.get(j) + row.get(j - 1);
//                }
//                row.set(j, val);
//                row.set(i - j, val);
//            }
//        }
//        return row;
//    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                row.add(1);
            } else {
                int val = lastRow.get(i - 1) + lastRow.get(i);
                row.add(val);
            }
        }
        return row;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(new GetRow().getRow(i));
        }
    }
}
