package code;

public class JZ53_1 {
    public int GetNumberOfK(int [] array , int k) {
        int first = getFirstK(array, k, 0, array.length -1);
        int last = getLastK(array, k, 0, array.length - 1);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private static int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            // arr[mid] 为第一个 k
            if ((mid > start && arr[mid - 1] != k) || mid == start) {
                return mid;
            } else {
                // arr[mid] 不为第一个 k
                end = mid - 1;
            }
        } else if(arr[mid] > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(arr, k, start, end);
    }

    private static int getLastK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            // arr[mid] 为最后一个 k
            if ((mid < end && arr[mid + 1] != k) || mid == end) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(arr, k, start, end);
    }

}
