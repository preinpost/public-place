package basic;

import java.util.Arrays;

public class PermutationV2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        permutation(arr, 0, 5, 3);

    }

    static void permutation(int arr[], int current, int n, int r){
        if(current==r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=current; i<n; i++){
            swap(arr,current,i);
            permutation(arr,current+1,n,r);
            swap(arr,current,i);
        }
    }

    static void swap(int arr[], int current, int i){
        int temp=arr[current];
        arr[current]=arr[i];
        arr[i]=temp;
    }

}
