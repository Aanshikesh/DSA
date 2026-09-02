class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int j = n - 1; j > idx; j--) {
            if (nums[j] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[j];
                nums[j] = temp;
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    }

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}