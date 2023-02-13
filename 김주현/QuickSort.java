import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {
    static final boolean ASC = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("숫자 개수 : ");
        int N = Integer.parseInt(br.readLine());
        System.out.print("숫자 입력(띄어쓰기로 구분)\n-> ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print("정렬 방법 (1:오름차순, 2:내림차순) : ");
        boolean order = br.readLine().equals("1");

        sort(arr, order);
        System.out.println("\n< 정렬결과 >");
        printArr(arr);
    }

    public static void sort(int[] arr, boolean order) {
        System.out.println("< 시작 수열 >");
        printArr(arr);
        System.out.println();

        quickSort(arr, 0, arr.length-1, order);
    }

    private static void quickSort(int[] arr, int start, int end, boolean order) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int pivotIdx;
        if (order == ASC) {
            pivotIdx = partitionAsc(arr, start, end);
        } else {
            pivotIdx = partitionDesc(arr, start, end);
        }
        quickSort(arr, start, pivotIdx-1, order);
        quickSort(arr, pivotIdx+1, end, order);


        System.out.printf("[OUT] start : %d, end : %d\n", start, end);
        printArr(arr, start, end);
    }

    private static int partitionAsc(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pointer = start + 1;
        int pivotIdx = start;


        while (pointer <= end) {
            if (arr[pointer] < pivot) {
                swap(arr, ++pivotIdx, pointer);
            }
            pointer++;
        }

        swap(arr, start, pivotIdx);
        return pivotIdx;
    }
    
    private static int partitionDesc(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pointer = start + 1;
        int pivotIdx = start;
        
        
        while (pointer <= end) {
            if (arr[pointer] > pivot) {
                swap(arr, ++pivotIdx, pointer);
            }
            pointer++;
        }
        
        swap(arr, start, pivotIdx);
        return pivotIdx;
    }

    private static void mergeDesc(int[] arr, int start, int mid, int end) {
        // 1.
        int[] temp = new int[end - start + 1];
        int idx = 0;

        // 2-1.
        int left = start;
        // 2-2.
        int right = mid + 1;

        // 3.
        while (left <= mid && right <= end) {
            if (arr[left] >= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        // 4.
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        // 5.
        while (right <= end) {
            temp[idx++] = arr[right++];
        }

        // 6.
        System.arraycopy(temp, 0, arr, start, end - start + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static void printArr(int[] arr, int start, int end) {
        System.out.printf("start : %d, end : %d\n", start, end);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}