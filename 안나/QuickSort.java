import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {

	static ArrayList<Integer> array = new ArrayList<>();
	static int[]arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***Quick Sort***\n");
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
		
		if(k==1) {
			SortAsc(0,arr.length-1);
		}else{
			SortDesc(0,arr.length-1);
		}
		

		System.out.print(" 정렬 후 => ");
		System.out.println(Arrays.toString(arr));
	}
	static void SortAsc(int low, int high) {
		
		int start = low;
		int end = high;
		if(high-low < 1) {
			return ;
		}
		int pivot = (low+high)/2 ;
		
		
		System.out.println("start : "+start+", pivot :  "+ pivot+", end : "+end);

		System.out.println(Arrays.toString(arr));
		while(true) {
			
			while(arr[low]<arr[pivot]) {
				low++;
			}
			while(arr[pivot]<arr[high]) {
				high--;
			}
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			if(pivot == high) {
				pivot = low;
				break;
			}else if (pivot == low) {
				pivot = high;
				break;
			}
		
		}
		SortAsc(start,pivot-1);
		SortAsc(pivot+1,end);
	}
	static void SortDesc(int high, int low) {
		int start = high;
		int end = low;
		if(low-high < 1) {
			return ;
		}
		int pivot = (low+high)/2 ;
		
		
		System.out.println(start+" "+ pivot+" "+end);

		System.out.println(Arrays.toString(arr));
		while(true) {
			
			while(arr[low]<arr[pivot]) {
				low--;
			}
			while(arr[pivot]<arr[high]) {
				high++;
			}
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			if(pivot == high) {
				pivot = low;
				break;
			}else if (pivot == low) {
				pivot = high;
				break;
			}
		
		}
		SortDesc(start,pivot-1);
		SortDesc(pivot+1,end);
	}
}
