package leetcode.zigzag_conversion;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        Character[][] arr = new Character[numRows][s.length()];

        int cursor = 0;
        for (int i = 0; i < s.length() ; i++) {
            int remained = numRows == 1 ? 0 : i % (numRows - 1);

            if (remained == 0) {
                for (int j = 0 ; j < numRows ; j++) {
                    arr[j][i] = s.charAt(cursor++);
                    if (cursor == s.length()) break;
                }
            }
            else {
                arr[numRows - 1 - remained][i] = s.charAt(cursor++);
            }
            if (cursor == s.length()) break;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0 ; i < numRows ; i++) {
            for (int j = 0 ; j < s.length() ; j++) {
                Character target = arr[i][j];
                if (target != null) resultBuilder.append(target);
            }
        }

        return resultBuilder.toString();
    }
}
