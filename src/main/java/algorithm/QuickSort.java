package algorithm;

/**
 * 基于分治
 * 在待排序表 L[1...n] 中任取一个元素 pivot 作为基准，
 * 通过一趟排序将待排序表划分为独立的两部分 L[1...k-1] 和 L[k+1...n],
 * 使得 L[1...k-1] 中所以的元素小于 pivot, L[k+1...n] 中所以元素大于或等于 pivot,
 * 则 pivot 放在了其最终的位置 L(k) 上, 这个过程称作一趟快排。
 * 递归直至每部分内只有一个元素或空为止
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 12, 16, 16, 88, 5, 10};
        quickSort(arr, 0, arr.length-1);
        //quickSort2(a);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {  // 递归跳出的条件
            // Partition() 就是划分操作，将表 A[low...high] 划分为满足上述条件的两个子表
            int pivotpos = partition(arr, low, high); // 划分
            quickSort(arr, low, pivotpos-1); // 依次对两个子表进行递归排序
            quickSort(arr, pivotpos+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     // 将当前表中的第一个元素设为枢轴值，对表进行划分
        while (low < high) {      // 循环跳出条件
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high]; // 将比枢轴值小的元素移动到左端
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low]; // 将比枢轴值大的元素移动到右端
        }
        arr[low] = pivot;         // 枢轴元素存放到最终位置
        return low;               // 返回存放枢轴的最终位置
    }
}
