import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {
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

        mergeSort(arr, 0, arr.length-1, order);
    }

    private static void mergeSort(int[] arr, int start, int end, boolean order) {
        if (start == end) {
            return;
        }

        System.out.printf("[IN] start : %d, end : %d\n", start, end);

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, order);
        mergeSort(arr, mid + 1, end, order);
        if (order == ASC) {
            mergeAsc(arr, start, mid, end);
        } else {
            mergeDesc(arr, start, mid, end);
        }
        System.out.printf("[OUT] start : %d, end : %d\n", start, end);
        printArr(arr, start, end);
    }

    private static void mergeAsc(int[] arr, int start, int mid, int end) {
        // 1. 임시 배열 공간을 만든다.
        // 2-1. 왼쪽 배열 : start ~ mid
        // 2-2. 오른쪽 배열 : mid + 1 ~ end
        // 3. 한쪽 배열의 원소를 모두 볼 때까지 왼쪽 배열과 오른쪽 배열의 왼쪽 인덱스부터 비교해가며 작은 쪽을 순서대로 임시배열에 담는다.
        // 4. 왼쪽 배열에 아직 안 본 원소가 남아 있다면 모두 임시배열에 넣는다.
        // 5. 왼쪽 배열에 아직 안 본 원소가 남아 있다면 모두 임시배열에 넣는다.
        // 6. 임시배열을 원래 배열에 복사한다.

        // 1.
        int[] temp = new int[end - start + 1];
        int idx = 0;

        // 2-1.
        int left = start;
        // 2-2.
        int right = mid + 1;

        // 3.
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
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

    private static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static void printArr(int[] arr, int start, int end) {
        System.out.printf("start : %d, end : %d\n", start, end);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}