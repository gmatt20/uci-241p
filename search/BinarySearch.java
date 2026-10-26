// Assistance: LeetCode Editorial
// Used for reviewing binary search logic, debugging matrix
// indexing, and understanding flattened 2D matrix search.
// https://leetcode.com/problems/search-a-2d-matrix/editorial/

public class BinarySearch {
  public int[] binarySearch(int[] nums, int num) {
    int[] indices = { -1, -1 };

    if (nums.length == 0) {
      return indices;
    }

    indices[0] = helper(nums, num, true);
    indices[1] = helper(nums, num, false);

    return indices;
  }

  public boolean matrixSearch(int[][] matrix, int target) {
    int low = 0;
    int n = matrix[0].length;
    int high = matrix.length * n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int midElement = matrix[mid / n][mid % n];
      if (target == midElement)
        return true;
      else {
        if (target > midElement) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return false;
  }

  private int helper(int[] nums, int num, boolean first) {
    int low = 0;
    int high = nums.length - 1;
    int index = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == num) {
        index = mid;
        if (first) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] < num) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return index;
  }
}
