import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("배열의 크기를 입력하세요 : ex) 10");
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        System.out.println("숫자를 입력하세요 : ex) 1 2 3 4 5");
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        QuickSort(0, N - 1);

        // 정렬 후 배열 출력
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();


    }

    static void QuickSort(int start, int end) {
        if (start >= end) return;

        int l = start;
        int h = end;
        int pivot = arr[end];

        while (l < h) {
            while (arr[l] <= pivot) {
                if(l == h) break;
                l++;
            }
            while (arr[h] >= pivot) {
                if (l == h) break;
                h--;
            }

            int tmp = arr[l];
            arr[l] = arr[h];
            arr[h] = tmp;
        }

        int tmp = arr[h];
        arr[h] = pivot;
        arr[end] = tmp;

        QuickSort(start, h - 1);
        QuickSort(h +1, end);
    }
}
