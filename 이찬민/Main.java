import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("원하는 정렬을 선택하세요>>" );
        StringBuilder sb = new StringBuilder();
        sb.append("1. 합병정렬\n");
        sb.append("2. 퀵정렬\n");

        sb.append("3. 종료\n");

        System.out.println(sb.toString());

        int select = Integer.parseInt(br.readLine());
        while (!(select < 4 && select > 0)) {
            System.out.println("정확한 숫자를 입력해주세요!!");
            System.out.println(sb.toString());
            select = Integer.parseInt(br.readLine());
        }

        if (select == 3) {
            System.exit(0);
        }

        sb.setLength(0);

        System.out.println("숫자들을 입력해주세요 (띄워쓰기 사용)>> ");

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();


        switch (select) {
            case 1:
                MergeSort mergeSort1 = new MergeSort(nums);
                System.out.println("합병정렬 오름차순");
                mergeSort1.naturalMergeSort(nums, 0, nums.length -1);

                for(int i =0 ; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();

                MergeSort selectionSort2 = new MergeSort(nums);
                System.out.println("합병정렬 내림차순");
                selectionSort2.reverseMergesort(nums, 0, nums.length -1);

                for(int i =0 ; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();

                break;
            case 2:
                QuickSort quickSort1 = new QuickSort();
                System.out.println("퀵정렬 오름차순");
                quickSort1.pivotNaturalSort(nums, 0, nums.length -1);

                for(int i =0 ; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();

                System.out.println("----------------------------------------------------------------------------");
                QuickSort quickSort2 = new QuickSort();
                System.out.println("퀵정렬 내림차순");
                quickSort2.pivotReverseSort(nums, 0, nums.length -1);

                for(int i =0 ; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();

                break;


        }
    }
}
