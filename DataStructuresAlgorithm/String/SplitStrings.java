package String;
public class SplitStrings {
    public static void main(String[] args) throws Exception {
        String str="codingninjas";
        System.out.println(splitStringAtVowels(str));
    }
    private static Boolean splitStringAtVowels(String str) {
        String vowel="AEIOUaeiou";
        int split=str.length()/2;
        String first=str.substring(0,split);
        String second=str.substring(split);
        int a=0;
        int b=0;
        for(int i=0; i<split; i++) {
            for(int j=0; j<vowel.length(); j++){
                if(first.charAt(i)==vowel.charAt(j)){
                    a++;
                }
                if(second.charAt(i)==vowel.charAt(j)){
                    b++;
                }
            }
        }
        return a==b?true:false;
    }
}