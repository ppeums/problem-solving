class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toString(numbers[i], 2);
            binary = '0' + binary;
            if (binary.charAt(binary.length() - 1) == '0') {
                answer[i] = numbers[i] + 1;
            } else {
                for (int j = binary.length() - 1; j >= 0; j--) {
                    if (binary.charAt(j) == '0') {
                        binary = binary.substring(0, j) + "10" + binary.substring(j + 2, binary.length());
                        break;
                    }
                }
                answer[i] = Long.parseLong(binary, 2);
            }
        }
        return answer;
    }
}