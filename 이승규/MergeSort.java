import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MergeSort {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("배열의 크기를 입력하세요 : ex) 10");
        int N = Integer.parseInt(br.readLine());


        System.out.println("숫자를 입력하세요 : ex) 1 2 3 4 5");
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(str[i]);
            list.add(num);
        }

        List<Integer> sorted_list = MergeSort(list);
        for (int i : sorted_list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static List<Integer> MergeSort(List<Integer> arr) {
        int end = arr.size();
        int mid = (end+1)/2;

        // 기저조건. list의 size가 0이 되는 경우는 초기 배열 arr의 길이가 홀수 일 경우
        if (arr.size() <= 1) {
            return arr;
        }
        // divide(분할)
        List<Integer> left = arr.subList(0, mid);
        List<Integer> right = arr.subList(mid, end);

        // conqure(정복)
        List<Integer> ll = MergeSort(left);
        List<Integer> rr = MergeSort(right);

        return Merge(ll, rr);
    }

    static List<Integer> Merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int index_left = 0;
        int index_right = 0;

        // 분할 된 list들을 merge
        // 두 배열 각각의 인덱스를 0부터 시작해 두 배열의 해당 인덱스끼리 비교. 작은 것을 먼저 채워줌
        while (index_left < a.size() && index_right < b.size()) {
            if (a.get(index_left) < b.get(index_right)) {
                result.add(a.get(index_left));
                index_left++;
            } else {
                result.add(b.get(index_right));
                index_right++;
            }
        }
        // 위쪽 while문에서 한쪽 배열의 index가 끝까지 도달하지 않았을 경우에 대해 나머지 배열을 쭉 추가해줌.
        if (index_left < a.size()) {
            while (index_left < a.size()) {
                result.add(a.get(index_left));
                index_left++;
            }
        } else {
            while (index_right < b.size()) {
                result.add(b.get(index_right));
                index_right++;
            }
        }
        return result;
    }


}
