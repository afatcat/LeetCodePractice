package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()<4 || s.length()>12){
            return result;
        }
        helper(result, new String[4], 1, 0, s);
        return result;
    }

    private void helper(List<String> result, String[] store, int place, int digit, String s){
        for(int i=1; i<=3; i++){
            if(s.length()-digit-i > (4-place)*3 || s.length()-digit-i < 4-place){
                continue;
            }else{
                String str = s.substring(digit, digit+i);
                if(str.charAt(0)=='0' && str.length()>1){
                    return;
                }
                int number = Integer.valueOf(str);
                if(number <=255 && number >=0){
                    store[place-1] = str;
                    if(place == 4){
                        result.add(arrToAddress(store));
                    }else{
                        helper(result, store, place+1, digit+i, s);
                    }
                }else{
                    return;
                }
            }
        }
    }

    private String arrToAddress(String[] store){
        if(store == null || store.length==0){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(store[0]);
        for(int i =1; i<store.length; i++){
            sb.append(".");
            sb.append(store[i]);
        }
        return sb.toString();
    }
}
