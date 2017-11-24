package net.shutingg.leetCode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        //find pivot
        int pivot = findPivot(nums, nums.length/2, 0, nums.length-1);
        System.out.println("pivot: "+pivot);

        //find target
        if(pivot == 0){
            return binarySearch(nums, target, nums.length/2, 0, nums.length-1);
        }
        int found = binarySearch(nums, target, (pivot-1)/2, 0, pivot-1);
        if(found >= 0){
            return found;
        }
        return binarySearch(nums, target, (pivot + nums.length)/2, pivot, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int current, int left, int right){
        if(left > current || right < current){
            return -1;
        }

        if(current == left || current == right){
            if(nums[left] == target){
                return left;
            }
            if(nums[right] == target){
                return right;
            }
            return -1;
        }

        if(nums[current] == target){
            return current;
        }

        if(nums[current] > target){
            return binarySearch(nums, target, (current+left)/2, left, current);
        }
        return binarySearch(nums, target, (current+right)/2, current, right);
    }

    private int findPivot(int[] nums, int current, int left, int right){
        if(current == left){
            if(nums[left] < nums[right]){
                return left;
            }else{
                return right;
            }
        }else if(nums[current]<nums[left]){
            return findPivot(nums, (current+left)/2, left, current);
        }else if(nums[current]>nums[left]){
            return findPivot(nums, (current+right)/2, current, right);
        }else{
            //error
            System.out.println("error current:"+current+", left: "+left+", right: "+right);
            return -1;
        }
    }
}
