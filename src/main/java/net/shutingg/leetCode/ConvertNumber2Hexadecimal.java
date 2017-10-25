package net.shutingg.leetCode;

/**
 * Created by sguan on 10/25/17.
 */
public class ConvertNumber2Hexadecimal {
    //7ms, beats 69.98%
    public String toHex3(int num) {
        if(num==0){
            return "0";
        }
        char[] chars = new char[8];
        char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        for(int i=7; i>=0; i--){
            int bit = num & 15;
            chars[i]=digits[bit];
            num = num >> 4;
        }
        int start = 0;
        for(int i=0;i<8;i++){
            if(chars[i]=='0'){
                start++;
            }else{
                break;
            }
        }
        return String.valueOf(chars, start, chars.length-start);
    }

    //7ms, beats 69.98%
    public String toHex2(int num) {
        if(num==0){
            return "0";
        }
        char[] chars = new char[8];
        for(int i=7; i>=0; i--){
            int bit = num & 15;
            if(bit<10){
                chars[i]=(char)('0'+bit);
            }else{
                chars[i]=(char)('a'+bit-10);
            }
            num = num >> 4;
        }
        int start = 0;
        for(int i=0;i<8;i++){
            if(chars[i]=='0'){
                start++;
            }else{
                break;
            }
        }
        return String.valueOf(chars, start, chars.length-start);
    }


    //12ms, beast only 4.36%
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        int workingNum = num;
        StringBuffer sb = new StringBuffer();
        if(workingNum<0) {
            workingNum = -(workingNum + 1);
        }
        while(workingNum>0){
            int remain = workingNum % 16;

            if(num<0) {
                if(remain<=5) {
                    char r = (char)('f'-remain);
                    sb.append(r);
                }else {
                    sb.append(15-remain);
                }
            }else {
                if(remain<10) {
                    sb.append(remain);
                }else {
                    char r = (char) ('a' + remain - 10);
                    sb.append(r);
                }
            }

            workingNum = workingNum / 16;
        }
        if(num<0) {
            while(sb.length()<8) {
                sb.append('f');
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
