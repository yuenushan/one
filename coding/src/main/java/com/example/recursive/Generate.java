package com.example.recursive;

import java.util.LinkedList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<>();
        return generate(numRows, rows);
    }

    private List<List<Integer>> generate(int numRows, List<List<Integer>> rows) {
        List<Integer> row = new LinkedList<>();
        List<Integer> lastRow = null;
        if (numRows == 0) {
            return rows;
        }
        if (numRows > 1) {
            generate(numRows - 1, rows);
            lastRow = rows.get(numRows - 2);
        }
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                row.add(1);
            } else {
                row.add(lastRow.get(i - 1) + lastRow.get(i));
            }
        }
        rows.add(row);
        return rows;
    }

    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }
}
