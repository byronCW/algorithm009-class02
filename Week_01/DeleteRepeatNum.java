class DeleteRepeatNum {
    public int removeDuplicates(int[] nums) {
        int nextPos = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] != nums[i]) {
               nums[nextPos++] = nums[i+1];
            }
        }
        return nextPos;
    }
}