import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MergeSort {
	static ArrayList<Integer> array = new ArrayList<>();
	static int[] arr;
	static int[] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***Merge Sort***\n");
		System.out.printf("정렬할 숫자를 띄어쓰기하여 입력하세요 >> ");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		 
		arr = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			arr[i] = array.get(i);
		}
		
		System.out.print("오름차순은 1번, 내림차순은 2번을 입력하세요 >> ");
		int k = Integer.parseInt(br.readLine());

		System.out.print("기존 => ");
		System.out.println(Arrays.toString(arr));
		

		temp = new int[arr.length];
		
		Sort(0, arr.length-1, k);
		
		

		System.out.print(" 정렬 후 => ");
		System.out.println(Arrays.toString(arr));
	
	}


	static void Sort(int start, int end, int k) {
		//0 7
		//0-3 4-7
		//0-1 2-3 4-5 6-7
		//0-0 1-1 2-2 3-3 4-4 5-5 6-6 7-7
		if(start==end) {
			return;
		}
		
		int mid = (start+end)/2;
		
		
		Sort(start, mid, k);
		Sort(mid+1, end, k);
		
		if(k==1) {
			MergeAsc(start, mid, end);
		}else {
			MergeDesc(start, mid, end);
		}

		System.out.println(Arrays.toString(arr));
			
		
	}

	static void MergeDesc(int start, int mid, int end) {
		int leftStart = start; //왼쪽 배열의 첫번째 인덱스
		int rightStart = mid+1;  //오른쪽 배열의 첫번째 인덱스
		int idx = start; //정렬된 배열을 차례대로 담을 인덱스
		
		
		//왼 , 오 배열 중 하나가 모두 털어낸 경우
		while(leftStart<=mid && rightStart <= end) {
			//왼쪽 배열 요소가 오른쪽 배열요소보다 크면 작은 오른쪽 배열 요소를 임시배열에 담는다.
			if(arr[leftStart] <= arr[rightStart]) {
				temp[idx] = arr[rightStart];
				rightStart++;
				idx++;
			}else {
				//왼쪽 배열 요소가 오른쪽 배열요소 보다 작으면 왼쪽 배열 요소를 임시배열에 담는다.
				temp[idx] = arr[leftStart];
				leftStart++;
				idx++;
			}
		}
		
		
		//왼쪽 배열을 다 털어낸 경우 남은 오른쪽 배열 요소를 차례대로 담는다.
		if(leftStart > mid) {
			while(rightStart <= end) {
				temp[idx++]=arr[rightStart++];
			}
		//오른쪽 배열 요소를 다 털어낸 경우 남은 왼쪽 배열 요소를 차례대로 담는다.
		}else if(rightStart > end) {
			while(leftStart <= mid) {
				temp[idx++]=arr[leftStart++];
			}
		}
		
		//모두 정렬된 임시 배열을 본 배열에 복사하여 옮긴다.
		for (int i = start; i <= end; i++) {
			arr[i]=temp[i]; 
		}
	}

	static void MergeAsc( int start, int mid, int end) {
		//0  3   7
		//4, 5 , 7
		//6 6 7
		int leftStart = start; //왼쪽 배열의 첫번째 인덱스
		int rightStart = mid+1;  //오른쪽 배열의 첫번째 인덱스
		int idx = start; //정렬된 배열을 차례대로 담을 인덱스
		
		
		//왼 , 오 배열 중 하나가 모두 털어낸 경우
		while(leftStart<=mid && rightStart <= end) {
			//왼쪽 배열 요소가 오른쪽 배열요소보다 크면 작은 오른쪽 배열 요소를 임시배열에 담는다.
			if(arr[leftStart] >= arr[rightStart]) {
				temp[idx] = arr[rightStart];
				rightStart++;
				idx++;
			}else {
				//왼쪽 배열 요소가 오른쪽 배열요소 보다 작으면 왼쪽 배열 요소를 임시배열에 담는다.
				temp[idx] = arr[leftStart];
				leftStart++;
				idx++;
			}
		}
		
		
		//왼쪽 배열을 다 털어낸 경우 남은 오른쪽 배열 요소를 차례대로 담는다.
		if(leftStart > mid) {
			while(rightStart <= end) {
				temp[idx++]=arr[rightStart++];
			}
		//오른쪽 배열 요소를 다 털어낸 경우 남은 왼쪽 배열 요소를 차례대로 담는다.
		}else if(rightStart > end) {
			while(leftStart <= mid) {
				temp[idx++]=arr[leftStart++];
			}
		}
		
		//모두 정렬된 임시 배열을 본 배열에 복사하여 옮긴다.
		for (int i = start; i <= end; i++) {
			arr[i]=temp[i]; 
		}
	}

}
