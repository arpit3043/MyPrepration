package DataStructuresAlgorithm.Recursion.Strings;

public class IntegerToWord {
    public static void main(String[] args) {
        int n = 1234;
        String res = intToWord(n);
        System.out.println(res);
    }

    private static String intToWord(int num) {
        if(num == 0) {
            return "Zero";
        }
        String[] bigString = new String[]{"Thousand","Million","Billion"};
        String result =  numberToWordsHelper(num%1000);
        num = num/1000;
        if(num > 0 && num%1000>0){
            result = numberToWordsHelper(num%1000) + "Thousand " + result;
        }
        num = num/1000;
        if(num > 0 && num%1000>0){
            result = numberToWordsHelper(num%1000) + "Million " + result;
        }
        num = num/1000;
        if(num > 0){
            result = numberToWordsHelper(num%1000) + "Billion " + result;
        }
        return result.trim();
    }

    private static String numberToWordsHelper(int num){
        String[] digitString = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        String[] tenString = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        
        if(num > 99){
            result += digitString[num/100] + " Hundred ";
        }
        
        num = num % 100;
        
        if(num < 20 && num > 9) {
            result += teenString[num%10]+" ";
        } else {
            if(num > 19){
                result += tenString[num/10]+" ";
            }
            num = num % 10;
            if(num > 0) {
                result += digitString[num]+" ";
            }
        }
        return result;
    }
}