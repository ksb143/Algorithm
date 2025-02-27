/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            // 만약 mid가 bad 버전이라면 (더 오래된 버전으로)
            if (isBadVersion(mid)) {
                right = mid - 1;
            // 만약 mid가 bad 버전이 아니라면 (더 최신 버전으로)
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}