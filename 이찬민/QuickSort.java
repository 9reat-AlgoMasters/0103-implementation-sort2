public class QuickSort {

    // pivot을 가장 맨 왼쪽 값을 pivot으로 잡았음
    public void pivotNaturalSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = naturalSort(arr, low, high);

        // pivot의 위치는 확정이 된 상태이기 때문에 제외하고 서로 반 나누어 다시 정렬
        pivotNaturalSort(arr, low, pivot - 1);
        pivotNaturalSort(arr, pivot + 1, high);
    }

    public int naturalSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[low];

        while(left < right) {
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
                left++;
            }
            // pivot기준 왼쪽에선 피벗보다 큰값을 찾고
            // 오른쪽에선 피벗보다 작은 값을 찾아서 swap
            swap(arr, left, right);
        }
        // left와 right가 만나서 끝난경우 pivot과 swap해준다
        swap(arr, low, left);
        
        // pivot 위치 리턴
        return left;
    }

    // pivot을 가장 맨 왼쪽 값을 pivot으로 잡았음
    public void pivotReverseSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = reverseSort(arr, low, high);
        
        // pivot의 위치는 확정이 된 상태이기 때문에 제외하고 서로 반 나누어 다시 정렬
        pivotReverseSort(arr, low, pivot - 1);
        pivotReverseSort(arr, pivot + 1, high);
    }

    public int reverseSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[low];

        while(left < right) {
            while(left < right && arr[right] <= pivot) {
                right--;
            }
            while(left < right && arr[left] >= pivot) {
                left++;
            }
            // pivot기준 왼쪽에선 피벗보다 작은 값을 찾고
            // 오른쪽에선 피벗보다 큰값을 찾아서 swap
            swap(arr, left, right);
        }
        // left와 right가 만나서 끝난경우 pivot과 swap해준다
        swap(arr, low, left);

        // pivot 위치 리턴
        return left;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
