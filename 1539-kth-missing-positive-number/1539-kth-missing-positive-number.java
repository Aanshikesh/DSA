// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         int missing=0;
//         int current=1;
//         int i=0;
//         while(true){
//             if(i<arr.length && arr[i]==current){
//                 i++;
//             }else{
//                 missing++;
//                 if(missing==k){
//                     return current;
//                 }
//             }
//             current++;
//         }
//     }
// }
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] - mid - 1 >= k){
                end = mid - 1;
            }else{
                start = mid +1;
            }
        }
        return start+k;
    }
}
