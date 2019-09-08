package CompanyTags;

public class alphabetToNumber {


    // https://www.geeksforgeeks.org/find-excel-column-number-column-title/
    int titleToNumber(String s) {
        // This process is similar to binary-to-decimal conversion
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            char ch = s.charAt(i);
            int diff = ch - 'A';
            result += diff + 1;
        }
        return result;
    }


    String titleToNumber(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            int remainder = num % 26;
            //If remainder is 0, then a 'Z' must be there in output
            if (remainder == 0) {
                stringBuilder.append('Z');
                num = num / 26;
                num = num - 1;
            } else {
                char c = (char) ((remainder - 1) + 'A');
                stringBuilder.append(c);
                num = num / 26;
            }
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        String str = "AB";
        int i = new alphabetToNumber().titleToNumber(str);
        System.out.println(i);


        String s = new alphabetToNumber().titleToNumber(i);
        System.out.println(s);

    }
}
