import java.util.Scanner;

public class MergeSort {
    static int[] arr, temp;
    static int size;
    static int mode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정렬할 숫자의 개수를 입력하세요>>");
        size = sc.nextInt();

        arr = new int[size];
        //합병 시 임시 저장 공간
        temp = new int[size];
        System.out.println("정렬할 숫자들을 입력하세요>>");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("1: 오름차순 2: 내림차순 정렬 방식을 고르세요>>");
        mode = sc.nextInt();

        mergeSort(0, size-1);

    }
    public static void mergeSort(int left, int right){
        if(left >= right){
            //범위 체크
            return;
        }
        int mid = (left + right) / 2;
        //배열 반으로 분할
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        //합병 되기 전 두 배열 출력
        System.out.print("[ ");
        for (int i = left; i < mid + 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("] + [ ");
        for (int i = mid + 1; i < right + 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("]\n==> [ ");

        if(mode == 1) {
            mergeAsc(left, mid, right);
        }else{
            mergeDesc(left, mid, right);
        }

        //합병 후
        for (int i = left; i < right + 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
    public static void mergeAsc(int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right){
            //합병할 두 배열 값들을 비교, 작은 쪽의 값을 임시배열에 넣고 인덱스 증가
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        //한 쪽 배열 끝났을 시 남은 배열 원소 처리
        if(i<=mid){
            while(i <= mid){
                temp[k++] = arr[i++];
            }
        }else{
            while(j <= right){
                temp[k++] = arr[j++];
            }
        }

        //임시 배열 값을 원래 배열로 복사
        System.arraycopy(temp, left, arr, left, right + 1 - left);
    }
    public static void mergeDesc(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                temp[k++] = arr[i++];
            }
        } else {
            while (j <= right) {
                temp[k++] = arr[j++];
            }
        }

        System.arraycopy(temp, left, arr, left, right + 1 - left);
    }
}
