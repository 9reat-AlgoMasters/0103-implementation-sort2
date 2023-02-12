import java.util.Scanner;

public class QuickSort {
    static int[] arr;
    static int size;
    static int mode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정렬할 숫자의 개수를 입력하세요>>");
        size = sc.nextInt();

        arr = new int[size];
        System.out.println("정렬할 숫자들을 입력하세요>>");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("1: 오름차순 2: 내림차순 정렬 방식을 고르세요>>");
        mode = sc.nextInt();

        quickSort(0, size-1);

    }
    public static void quickSort(int left, int right){
        if(left >= right){
            //범위 체크
            return;
        }
        int pivot;
        if(mode == 1) {
            //오름차순
            //left번 부터 right번 까지 정렬 후 피벗 위치를 반환 받음
            pivot = partitionAsc(left, right);
        }else{
            //내림차순
            pivot = partitionDesc(left, right);
        }
        //해당 피벗값은 자리를 찾은 상태
        //피벗 기준 왼쪽 배열과 오른쪽 배열로 나누어 퀵 정렬 진행
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }
    public static int partitionAsc(int left, int right){
        //오름차순을 위한 정렬메소드
        int pivot = arr[left];
        //i는 앞에서부터 pivot보다 작은 원소인지 확인할 변수
        int i = left + 1;
        //j는 뒤에서부터 pivot보다 큰 원소인지 확인할 변수
        int j = right;

        while(i <= j){
            //i가 j보다 뒤로 가면 모든 원소를 탐색했다는 의미, 반복문 탈출
            while(arr[i] <= pivot && i < right){
                //pivot보다 큰 원소를 찾았거나 모두 탐색했으면 탈출
                i++;
            }
            while(arr[j] >= pivot && j > left){
                //pivot보다 작은 원소 찾았거나 모두 탐색했으면 탈출
                j--;
            }

            if(i < j) {
                //해당 i, j는 적절한 위치에 있지 않으므로 스왑
                swap(i, j);
            }else{
                break;
            }
            i++;
            j--;
        }
        //i가 j보다 뒤로 간 시점에서 배열 탐색 완료, 서로의 경계를 넘었음을 의미
        //i자리엔 피벗보다 큰 원소가, j자리엔 피벗보다 작은 원소 위치
        //피벗과 j 스왑하면 오름차순 정렬 가능
        if(left!=j) {
            swap(left, j);
        }
        //피벗 값이 위치하게되는 자리를 리턴
        return j;
    }
    public static int partitionDesc(int left, int right){
        //내림차순을 위한 정렬메소드
        int pivot = arr[left];
        //i는 앞에서부터 pivot보다 큰 원소인지 확인할 변수
        int i = left + 1;
        //j는 뒤에서부터 pivot보다 작은 원소인지 확인할 변수
        int j = right;

        while(i <= j){
            //i가 j보다 뒤로 가면 모든 원소를 탐색했다는 의미, 반복문 탈출
            while(arr[i] >= pivot && i < right){
                //pivot보다 작은 원소를 찾았거나 모두 탐색했으면 탈출
                i++;
            }
            while(arr[j] <= pivot && j > left){
                //pivot보다 큰 원소 찾았거나 모두 탐색했으면 탈출
                j--;
            }

            if(i < j) {
                //해당 i, j는 적절한 위치에 있지 않으므로 스왑
                swap(i, j);
            }else{
                break;
            }
            i++;
            j--;
        }
        if(left < j) {
            swap(left, j);
        }
        return j;
    }
    public static void swap(int idx1, int idx2){
        System.out.println(arr[idx1]+" <---> " + arr[idx2]);
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        for (int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
