package Basic;

// https://www.geeksforgeeks.org/reverse-words-given-string-java/

public class ReverseWordByWordOfString {


    public String reverseWords(String str) {
        String[] strArray = str.split(" ");
        String newStr = "";

        for (int i = strArray.length - 1; i >= 0; i--) {
            newStr += strArray[i] + " ";
        }
        return newStr.trim();

    }

    public static void main(String[] args) {


        String str = " the sky is blue";
        String reverseWords = new ReverseWordByWordOfString().reverseWords(str);
        System.out.println(reverseWords);

    }
}
