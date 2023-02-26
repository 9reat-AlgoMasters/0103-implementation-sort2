public class MergeSort {

    public MergeSort(int[] arr) {
        
    }

    public void naturalMergeSort(int[] arr, int start, int end) {
        if(start < end){
            int mid = (start + end)/2;
            naturalMergeSort(arr, start, mid);
            naturalMergeSort(arr,mid+1, end);
            ascMerge(arr, start, mid, end);
        }
    }

    public void ascMerge(int[] arr, int left, int mid, int right) {
        int leftIdx = left;
        
        int rightIdx = mid + 1;
        
        int idx = left;
        // 정렬된 데이터 임시 저장 배열
        int[] tempSortedArr = new int[right + 1];

        //오름차순
        while(leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                tempSortedArr[idx++] = arr[leftIdx++];
            }
            else {
                tempSortedArr[idx++] = arr[rightIdx++];
            }
        }

        // 왼쪽부분이 다 들어간 경우 오른쪽부분 전부 넣어주기
        if (leftIdx > mid) {
            for(int i = rightIdx; i <= right; i++) {
                tempSortedArr[idx++] = arr[i];
            }
        }

        // 오른쪽부분이 다 들어간 경우 왼쪽부분 전부 넣어주기
        if(leftIdx <= mid) {
            for(int i = leftIdx; i <= mid; i++) {
                tempSortedArr[idx++] = arr[i];
            }
        }

        // 다시 전부 옮겨줌
        for(int i = left; i <= right; i++) {
            arr[i] = tempSortedArr[i];
        }
    }
    
    public void reverseMergesort(int[] arr, int start, int end) {
        if(start < end){
            int mid = (start + end)/2;
            reverseMergesort(arr, start, mid);
            reverseMergesort(arr,mid+1, end);
            descMerge(arr, start, mid, end);
        }
    }

    public void descMerge(int[] arr, int left, int mid, int right) {
        int leftIdx = left;

        int rightIdx = mid + 1;

        int idx = left;
        // 정렬된 데이터 임시 저장
        int[] tempSortedArr = new int[right + 1];

        //내림차순
        while(leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx] >= arr[rightIdx]) {
                tempSortedArr[idx++] = arr[leftIdx++];
            }
            else {
                tempSortedArr[idx++] = arr[rightIdx++];
            }
        }

        // 왼쪽부분이 다 들어간 경우 오른쪽부분 전부 넣어주기
        if (leftIdx > mid) {
            for(int i = rightIdx; i <= right; i++) {
                tempSortedArr[idx++] = arr[i];
            }
        }
        else if(leftIdx <= mid) { // 오른쪽부분이 다 들어간 경우 왼쪽부분 전부 넣어주기
            for(int i = leftIdx; i <= mid; i++) {
                tempSortedArr[idx++] = arr[i];
            }
        }

        // 다시 전부 옮겨줌
        for(int i = left; i <= right; i++) {
            arr[i] = tempSortedArr[i];
        }
    }
}
