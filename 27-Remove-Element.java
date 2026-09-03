class Solution {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;

        int i = 0;

        while (i < n) {

            if (nums[i] == val) {

                // Shift elements one position to the left
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }

                // Effective size decreases
                n--;

            } else {
                i++;
            }
        }

        return n;
    }
}