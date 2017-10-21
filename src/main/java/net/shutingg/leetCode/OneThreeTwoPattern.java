package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguan on 10/19/17.
 */
public class OneThreeTwoPattern {
    private List<Range> list;

    class Range{
        private int bottom;
        private int top;

        public Range(int bottom, int top) {
            this.bottom = bottom;
            this.top = top;
        }

        boolean isInRange(int input){
            return input>bottom && input<top;
        }

        void updateTop(int input){
            top=input;
        }
    }

    public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3){
            return false;
        }
        list = new ArrayList<>();
        int last=nums[0];
        int bottom=nums[0];
        for(int i=1;i<nums.length;i++){
            if(isInRanges(nums[i])){
                return true;
            }else if(nums[i]<last){
                last=nums[i];
                bottom=nums[i];
            }else if(nums[i]>last){
                if(bottom==last){
                    list.add(new Range(last, nums[i]));
                    last=nums[i];
                }else{
                    modifyLastRange(nums[i]);
                    last=nums[i];
                }
            }
        }
        return false;
    }

    private void modifyLastRange(int input){
        if(list==null || list.size()<1){
            return;
        }
        Range lastRange = list.get(list.size()-1);
        lastRange.updateTop(input);
    }

    private boolean isInRanges(int input){
        if(list==null){
            return false;
        }
        for(Range r:list){
            if(r.isInRange(input)){
                return true;
            }
        }
        return false;
    }
}
