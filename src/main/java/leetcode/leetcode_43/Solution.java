package leetcode.leetcode_43;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String num1 = "999";
        String num2 = "999";

        System.out.println(sol.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        String longer = num1.length() >= num2.length() ? num1 : num2;
        String shorter = num1.length() >= num2.length() ? num2 : num1;

        int lengthSum = longer.length() + shorter.length();
        int[][] mediumResultArr = new int[shorter.length()][lengthSum];

        int carry = 0;
        for (int i = shorter.length() - 1 ; i >= 0 ; i--) {
            carry = 0;
            int a = shorter.charAt(i) - '0';
            int firstIdx = shorter.length() - 1 - i;

            for (int j = longer.length() - 1 ; j >= 0 ; j--) {
                int b = longer.charAt(j) - '0';

                int mul = a * b + carry;
                int secondIdx = lengthSum - longer.length() + j - firstIdx;
                mediumResultArr[firstIdx][secondIdx] = mul % 10;

                carry = mul / 10;
            }

            mediumResultArr[firstIdx][lengthSum - longer.length() - firstIdx - 1] = carry;
        }


        String result = "";

        carry = 0;
        for (int i = mediumResultArr[0].length - 1 ; i >= 0 ; i--) {
            int sum = 0;

            for (int j = 0; j < shorter.length() ; j++) {
                sum += mediumResultArr[j][i];
            }

            sum += carry;

            result = (sum % 10) + result;

            carry = sum / 10;
        }

        int zeroIdx = 0;

        while (zeroIdx < result.length() && result.charAt(zeroIdx) == '0') {
            zeroIdx++;
        }

        if (zeroIdx == result.length()) return "0";
        return result.substring(zeroIdx);
    }
}