package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    //31ms, beats 34.05%
    public String predictPartyVictory(String senate) {
        if(senate==null || senate.length()==0){
            return null;
        }
        int rCount = 0;
        int dCount = 0;
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i)=='R'){
                queue.add('R');
                rCount++;
            }else if(senate.charAt(i)=='D'){
                queue.add('D');
                dCount++;
            }else{
                //illegal string
                return null;
            }
        }

        if(rCount==0){
            return "Dire";
        }else if(dCount==0){
            return "Radiant";
        }

        int rToBlock = 0;
        int dToBlock = 0;

        while(!queue.isEmpty() && rCount!=0 && dCount!=0){
            Character c = queue.poll();
            if (c == 'R') {
                if (rToBlock <= 0) {
                    dToBlock++;
                    queue.add('R');
                } else {
                    rToBlock--;
                    rCount--;
                }
            }else{
                if(dToBlock<=0){
                    rToBlock++;
                    queue.add('D');
                }else{
                    dToBlock--;
                    dCount--;
                }
            }
        }

        if(queue.peek()=='R'){
            return "Radiant";
        }else{
            return "Dire";
        }
    }
}
