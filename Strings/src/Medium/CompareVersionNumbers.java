package Medium;

// https://www.geeksforgeeks.org/compare-two-version-numbers/
// https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumbers {
    // Firstly we need to split each and every value for both the strings
    // Than we need to find the max
    // And then compare these two numbers using compare method
    // If compare is not equal to Zero return that one

    public int compareVersion(String version1, String version2) {
        Long v1, v2;
        // To split each number by . so we are removing the dots
        String[] levels1 = version1.split("\\."); //  [1, 0]
        String[] levels2 = version2.split("\\."); // [1, 0, 0]


        long length1 = levels1.length;
        long length2 = levels2.length;
        long length = Math.max(length1, length2);

        for (int i = 0; i < length; i++) {
            if (i < length1) {
                Long i1 = Long.parseLong(levels1[i]);
                v1 = i1;
            } else {
                v1 = 0L;
            }
            if (i < length2) {
                Long i2 = Long.parseLong(levels2[i]);
                v2 = i2;
            } else {
                v2 = 0L;
            }
            int compare = Long.compare(v1, v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String v1 = "1.0";
        String v2 = "1.0.0";
        int i = new CompareVersionNumbers().compareVersion(v1, v2);

        System.out.println(i);

    }
}
