# SWExpertAcademy_MockTest_Java_5658
SW Expert Academy  5658. [모의 SW 역량테스트] 보물상자 비밀번호


# SWExpertAcademy_D3_Java_8016

## SW Expert Academy D3 8016. 홀수 피라미드

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
    
input 정수 `N`과 `K`가 들어온다. `N`개의 `16`진수의 숫자가 들어오며 시계방향으로 숫자들을 돌리면서 한 변에 있는 숫자들 중 `K`번째로 큰 숫자를 출력하는 문제이다. 각 변에는 동일한 개수의 숫자가 있고 `4`개의 변으로 이루어져 있는 자물쇠를 돌리면서 숫자를 만들어 낸다. 

[입력]
> 가장 첫 줄에는 테스트 케이스의 개수 `T`가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 숫자의 개수 `N`과 크기 순서 `K`가 주어 진다.
> 그 다음 줄에는 `16`진수 `0~F` 숫자가 공백 없이 `N`개 주어진다.

[출력]
> 출력의 각 줄은 `#t`로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
> (`t`는 테스트 케이스의 번호를 의미하며 `1`부터 시작한다.)

### 풀이

`N`개의 `16`진수 숫자가 `01234...BCDEF`로 들어왔다고 하자. 한변에 있는 숫자의 개수는 `N/4`이며 받아온 input문자열을 `substring` 으로 `N/4`씩 가져와서 `16`진수 문자열을 `10`진수로 바꿔서 집합에 담아준 후 처리하였다. `substring`을 이용할 경우 문자열의 끝에서 `beginIndex`가 시작한다면 다시 첫 index부터 문자열을 가져와야한다. 이 문제는 앞 문자열을 뒤에 붙이는 트릭을 이용하여 해결하였다.

```java
str = str + str.substring(0, period);
```

`K`번째 수는 `Arrays.sort()`를 이용하여 오름차순으로 정렬후 뒤에서 부터 `K`번째 숫자를 출력하는 것으로 해결하였다.


```java
int N = sc.nextInt();
int K = sc.nextInt();
sc.nextLine();

String str = sc.nextLine();
int period = N/4;
str = str + str.substring(0, period);

Set<Integer> candidates = new HashSet<>();
for (int i = 0; i < str.length() - period; i++) {
  candidates.add(Integer.parseInt(str.substring(i, i + period), 16));
}
int[] passwords = new int[candidates.size()];
int idx = 0;
for (int i : candidates) {
  passwords[idx++] = i;
}
Arrays.sort(passwords);
System.out.println("#"+test_case+" "+passwords[passwords.length - K]);
```
