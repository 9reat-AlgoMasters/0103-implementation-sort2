# Dual-Pivot Quick Sort
## 특징
- `Arrays.sort` 가 사용하는 알고리즘
- `Insertion Sort` 와 `Quick Sort`를 합친 것
- 두 개의 pivot을 써서 전체 영역을 3영역으로 나누어 정렬을 진행한다.

## 정렬과정
1) 배열의 가장 왼쪽 항목은 `lp`, 가장 오른쪽 항목은 `rp`로 설정
2) `lp > rp` 인 경우 서로 `swap`한다.
3) `lp` 와 `rp`를 pivot 으로 이용하여 세 개의 영역으로 분할한다.
4) 이 때 퀵소트처럼 각 피봇들을 기점으로 숫자들의 대소관계가 유지되어야 한다.


# Reference
1. [Dual-Pivot Quick Sort 설명](https://cs-vegemeal.tistory.com/53)
    - 설명만 참고 (구현은 부정확)
2. [Dual-Pivot Quick Sort 구현](https://defacto-standard.tistory.com/38)
3. [Dual-Pivot Quick Sort와 Tim Sort 에 대한 간단 비교 정리](https://ongveloper.tistory.com/385)