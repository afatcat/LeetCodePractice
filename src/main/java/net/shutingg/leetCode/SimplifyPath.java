package net.shutingg.leetCode;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "~";
        }
        LinkedList<String> list = new LinkedList<>();
        boolean success = processPath(path.toCharArray(), list, 0, "", 0);
        if(success){
            if(list.size()==0){
                return "/";
            }
            StringBuffer sb = new StringBuffer();
            for(String s:list){
                sb.append("/");
                sb.append(s);
            }
            return sb.toString();
        }else{
            return "~";
        }
    }

    private boolean processPath(char[] chars, LinkedList list, int loc, String current, int dotCount){
        if(loc >= chars.length){
            if(!current.equals("")){
                list.add(current);
            }else if(dotCount == 2){
                if(!list.isEmpty()){
                    list.removeLast();
                }
            }else if(dotCount >2){
                for(int i=0; i<dotCount; i++){
                    current += ".";
                }
                list.add(current);
            }
            return true;
        }else if(chars[loc] == '/'){
            if(current.equals("") && dotCount ==0){
                return processPath(chars, list, loc+1, "", 0);
            }else if(dotCount == 0){
                list.add(current);
                return processPath(chars, list, loc+1, "", 0);
            }else if(dotCount == 1){
                return processPath(chars, list, loc+1, "", 0);
            }else if(dotCount == 2){
                if(!list.isEmpty()){
                    list.removeLast();
                }
                return processPath(chars, list, loc+1, "", 0);
            }else{
                for(int i=0; i<dotCount; i++){
                    current += ".";
                }
                list.add(current);
                return processPath(chars, list, loc+1, "", 0);
            }
        }else if(chars[loc] == '.'){
//            System.out.println("dot counting on "+loc+", current: "+current+", dotCount"+dotCount);
            if(current.equals("")){
                return processPath(chars, list, loc+1, current, dotCount+1);
            }else{
                return processPath(chars, list, loc+1, current+".", dotCount);
            }
        }else{
            if(dotCount>0){
                for(int i=0; i<dotCount; i++){
                    current += ".";
                }
                return processPath(chars, list, loc+1, current+chars[loc], 0);
            }else{
                return processPath(chars, list, loc+1, current+chars[loc], 0);
            }
        }
    }
}
