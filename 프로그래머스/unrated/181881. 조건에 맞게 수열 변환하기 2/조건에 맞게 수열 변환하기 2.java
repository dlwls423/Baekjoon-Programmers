import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] newArr = convertArr(arr);
        
        while(!Arrays.equals(arr, newArr)){
            answer++;
            arr = newArr.clone();
            newArr = convertArr(arr);
        }
        
        return answer;
    }
    
    public static int[] convertArr(int[] arr){
        int[] newArr = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=50 && arr[i]%2==0) newArr[i] = arr[i]/2;
            else if(arr[i]<50 && arr[i]%2==1) newArr[i] = arr[i]*2+1;
            else newArr[i] = arr[i];
        }

        return newArr;
    }
}