public static void main(String[]args){
//**************************************EASY PROBLEMS ON ARRAYS************************************************ */
// Largest Element in an Array-Q1
class Solution {
    public int largest(int arr[], int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

// Second Largest Element in an Array-Q2
class Solution {
    int print2largest(int arr[], int n) {
        // code here
        int greatest = -1;
        int second_greatest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > greatest) {
                second_greatest = greatest;
                greatest = arr[i];
            } else if (arr[i] > second_greatest && arr[i] != greatest) {
                second_greatest = arr[i];
            }
        }
        return second_greatest;
    }
}

// Check if the array is sorted-Q3
class Solution {
    public boolean check(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){if(arr[i]>arr[(i+1)%n]){return false}}
        return true;
    }
}

// Remove duplicates from Sorted array-Q4
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int copy[] = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], 1);
                copy[ind++] = copy[i];
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = copy[i];
        }
        return ind;
    }
}

// Left Rotate an array by one place-Q5
class Solution {
    void leftRotate(long arr[], int k, int n) {

        long temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }
}

// Left rotate an array by D places-Q6
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        f(nums, 0, n - k - 1);
        f(nums, n - k, n - 1);
        f(nums, 0, n - 1);
    }

    public void f(int a[], int s, int e) {
        int low = s, high = e;
        while (low <= high) {
            int g = a[low];
            a[low] = a[high];
            a[high] = g;
            low++;
            high--;
        }
    }
}

// Move Zeros to end-Q7
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public void swap(int a[], int p, int n) {
        int temp = a[p];
        a[p] = a[n];
        a[n] = temp;
    }
}

// Linear Search-Q8
class Solution {
    static int searchInSorted(int arr[], int N, int K) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == K) {
                return 1;
            }
        }
        return -1;
    }
}

// Find the Union-Q9
class Solution {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (i < n && j < m) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
            }
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i++]);
            } else if (arr2[j] < arr1[i]) {
                ans.add(arr2[j++]);
            } else {
                ans.add(arr2[j++]);
                i++;
            }
        }
        while (i < n) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            ans.add(arr1[i++]);
        }
        // Storing the remaining elements of second array (if there are any).
        while (j < m) {
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
            }
            ans.add(arr2[j++]);
        }
        return ans;
    }
}

// Find missing number in an array-Q10
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int reqd = n * (n + 1) / 2;
        return reqd - sum;
    }
}

// Maximum Consecutive Ones-Q11
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0, n = nums.length, ans = 0;
        while (end < n) {
            if (nums[end] == 1) {
                end++;
            } else {
                start = end;
                start++;
                end++;
            }
            ans = Math.max(end - start, ans);
        }
        return ans;
    }
}

// Find the number that appears once-Q12
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

// Longest subarray with sum K-Q13
class Solution {
    public static int lenOfLongSubarr(int nums[], int N, int K) {
        int n = nums.length, sum = 0, maxlen = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - K)) {
                maxlen = Math.max(i - hm.get(sum - K), maxlen);
            }
            if (hm.get(sum) == null) {
                hm.put(sum, i);
            }
        }
        return maxlen;
    }

}

// Subarray with given sum equals K-Q14
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                cnt += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}

// Search an element in a 2D matrix
class Solution {
    public int floor(int[][] matrix, int target) {
        int ans = -1;
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public boolean binarysearch(int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int R = floor(matrix, target);
        if (R == -1) {
            return false;
        }
        return binarysearch(matrix, target, R);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = (rows * cols) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}

// Find the row with maximum number of 1s
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max_row_index = -1, max = -1;
        int index;
        for (int i = 0; i < n; i++) {
            index = first(arr[i], 0, m - 1);
            if (index != -1 && m - index > max) {
                max = m - index;
                max_row_index = i;
            }
        }
        return max_row_index;
    }

    int first(int arr[], int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) {
                return mid;
            } else if (arr[mid] == 0) {
                return first(arr, (mid + 1), high);
            } else {
                return first(arr, low, (mid - 1));
            }
        }
        return -1;
    }
}

// **********************************************MEDIUM PROBLEMS OF
// ARRAYS************************************************ */
// 2-Sum Problem-Q1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
            }
            m.put(nums[i], i);
        }
        return res;
    }
}

// Sort an array consisting of 0's 1's and 2's-Q2
class Solution {
    public void sortColors(int[] nums) {
        int mid = 0, low = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;

            }
        }
    }
}

// Majority Element (>n/2 times)-Q3
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        for (int n : nums) {
            if (count == 0) {
                ele = n;
                count = 1;
            } else if (n == ele) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}

// Kadane's Algorithm, maximum subarray sum-Q4
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

// Print subarray with maximum subarray-Q5
class Solution {
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}

// Stock Buy and Sell-Q6
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

// Rearrange the array in alternating even and odd-Q7
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int posi = 0, negi = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negi] = nums[i];
                negi += 2;
            } else {
                ans[posi] = nums[i];
                posi += 2;
            }
        }
        return ans;
    }
}

// Next Permutation-Q8
class Solution {
    public void nextPermutation(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = A.length - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }
}

// Leaders in an Array problem-Q9
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        int greatest = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= greatest) {
                leaders.add(0, arr[i]);
                greatest = arr[i];
            }
        }
        return leaders;
    }
}

// Longest Consecutive Sequence in an array-Q10
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}

// Set Matrix Zeros-Q11
// Rotate Matrix by 90 degrees-Q12
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        print(matrix);
        reverse(matrix);
    }

    public void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void transpose(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public void reverse(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            reverserow(mat[i]);
        }
    }

    public void reverserow(int mat[]) {
        int n = mat.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = mat[i];
            mat[i] = mat[n - 1 - i];
            mat[n - 1 - i] = temp;
        }
    }
}

// Print the matrix in spiral manner-Q13
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}

// Count Subarray with given sum-Q14
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                cnt += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}

// *************************************HARD PROBLEMS OF
// ARRAYS********************************************************** */
// Pascal's Triangle-Q1
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            res.add(row);
        }
        return res;
    }
}

// Majority Element (n/3 times)-Q2
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> mon = new ArrayList<>();
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                c1++;
            }
            if (nums[i] == num2) {
                c2++;
            }
        }
        if (c1 > len / 3) {
            mon.add(num1);
        }
        if (c2 > len / 3) {
            mon.add(num2);
        }
        return mon;
    }
}

// 3-Sum Problem-Q3
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1, high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}

// 4-Sum Problem-Q4
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long target2 = (long) target - (long) nums[i] - (long) nums[j];
                int lo = j + 1, hi = n - 1;
                while (lo < hi) {
                    int twoSum = nums[lo] + nums[hi];
                    if (twoSum < target2) {
                        lo++;
                    } else if (twoSum > target2) {
                        hi--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j],
                                nums[lo], nums[hi]);
                        ans.add(quad);

                        while (lo < hi && nums[lo] == quad.get(2)) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == quad.get(3)) {
                            hi--;
                        }
                    }
                }
                while (j + 1 < n && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }
}

// Largest Subarray with 0 Sum-Q5
class GfG {
    int maxLen(int nums[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0, sum = 0;
        hm.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hm.containsKey(sum) == true) {
                max = Math.max(i - hm.get(sum), max);
            }
            if (hm.get(sum) == null) {
                hm.put(sum, i);
            }
        }
        return max;
    }
}

// Count number of subarrays with given sum-Q6
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                cnt += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}

// Merge Overlapping Subintervals-Q7
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }

        }
        res.add(new int[] { start, end });
        return res.toArray(new int[0][]);
    }
}

// Merge two sorted arrays without external space-Q8
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, nums2, m, n);
        int k = 0;
        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[k++];
        }
    }

    public void merge(int[] arr1, int[] arr2, int n, int m) {
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}

// Find the repeating and missing number-Q9
class Solution {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xorele = 0;
        int xorini = 0;
        for (int i = 0; i < n; i++) {
            xorele = xorele ^ arr[i];
            xorini = xorini ^ (i + 1);
        }
        int res = xorele ^ xorini;
        int getbit = f(res);
        int zeroclub = 0, oneclub = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1 << getbit)) != 0) {
                oneclub = oneclub ^ arr[i];
            } else {
                zeroclub = zeroclub ^ arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (((1 << getbit) & (i)) != 0) {
                oneclub = oneclub ^ i;
            } else {
                zeroclub = zeroclub ^ i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (oneclub == arr[i]) {
                cnt++;
            }
        }
        if (cnt == 2) {
            return new int[] { oneclub, zeroclub };

        } else
            return new int[] { zeroclub, oneclub };
    }

    public int f(int a) {
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) != 0) {
                return i;
            }
        }
        return -1;
    }
}

// Count Inversions-Q10
class Solution {
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long n) {
        long temp[] = new long[(int) n];
        return _mergeSort(arr, temp, 0, n - 1);
    }

    static long _mergeSort(long arr[], long temp[], long left, long right) {
        long mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    static long merge(long arr[], long temp[], long left, long mid, long right) {
        long i, j, k;
        long inv_count = 0;
        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                temp[(int) k++] = arr[(int) j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1) {
            temp[(int) k++] = arr[(int) i++];
        }
        while (j <= right) {
            temp[(int) k++] = arr[(int) j++];
        }
        for (i = left; i <= right; i++) {
            arr[(int) i] = temp[(int) i];
        }
        return inv_count;
    }
}

// Reverse Pairs-Q11
class Solution {
    public int reversePairs(int[] nums) {
        return f(nums);
    }

    int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return cnt;
    }

    int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }

    int f(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

}

// Maximum Product Subarray-Q12
class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int dpMin = nums[0];
        int dpMax = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            final int num = nums[i];
            final int prevMin = dpMin;
            final int prevMax = dpMax;
            if (num < 0) {
                dpMin = Math.min(prevMax * num, num);
                dpMax = Math.max(prevMin * num, num);
            } else {
                dpMin = Math.min(prevMin * num, num);
                dpMax = Math.max(prevMax * num, num);
            }
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}}
