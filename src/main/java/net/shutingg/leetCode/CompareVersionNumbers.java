package net.shutingg.leetCode;

/**
 * Created by sguan on 11/1/17.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int length;
        if(arr1.length > arr2.length){
            length = arr1.length;
        }else{
            length = arr2.length;
        }
        for(int i = 0; i < length; i++){
            int v1 = 0;
            int v2 = 0;
            if(i<arr1.length){
                v1=Integer.valueOf(arr1[i]);
            }
            if(i<arr2.length){
                v2=Integer.valueOf(arr2[i]);
            }
            if(v1 < v2){
                return -1;
            }else if(v2 < v1){
                return 1;
            }
        }
        return 0;
    }
}
