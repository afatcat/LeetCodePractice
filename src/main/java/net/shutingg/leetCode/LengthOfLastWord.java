package net.shutingg.leetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        String[] strings = s.split(" ");
        if(strings.length>=1){
            return strings[strings.length-1].length();
        }
        return 0;
    }
}
