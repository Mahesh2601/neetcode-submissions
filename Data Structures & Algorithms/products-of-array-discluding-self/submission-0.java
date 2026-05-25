class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, 1);
        int preProd = 1;
        int sufProd = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= preProd;
            res[n-i-1] *= sufProd;
            preProd *= nums[i];
            sufProd *= nums[n-i-1];
        }
        return res;
    }
}  
