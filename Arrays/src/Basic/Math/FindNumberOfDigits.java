package Basic.Math;

public class FindNumberOfDigits {

    private int countNumbers(long num) {
        int Digitcount = 0;
        while (num != 0) {
            Digitcount = Digitcount + 1;
            num = num / 10;
        }
        return Digitcount;
    }

    private double usingLog(long num) {
        double v = Math.log10(num);
        double floor = Math.floor(v + 1);
        return floor;
    }


    public static void main(String[] args) {
        long num = 12345678901L;
        int i = new FindNumberOfDigits().countNumbers(num);
        double v = new FindNumberOfDigits().usingLog(num);

        System.out.println(i);
        System.out.println(v);
    }


}
