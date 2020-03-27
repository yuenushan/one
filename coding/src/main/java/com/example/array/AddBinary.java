package com.example.array;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int jinwen = 0;
        while (aIndex >=0 || bIndex >= 0 || jinwen > 0) {
            int aVal = 0;
            if (aIndex >= 0) {
                aVal = a.charAt(aIndex) - '0';
                aIndex--;
            }
            int bVal = 0;
            if (bIndex >= 0) {
                bVal = b.charAt(bIndex) - '0';
                bIndex--;
            }
            int sum = aVal + bVal + jinwen;
            if (sum == 0) {
                result.append("0");
                jinwen = 0;
            } else if (sum == 1) {
                result.append("1");
                jinwen = 0;
            } else if (sum == 2) {
                result.append("0");
                jinwen = 1;
            } else {
                result.append("1");
                jinwen = 1;
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
