/*
 * 소수 판별 알고리즘 개선(2)

 - 어떤 정수 n은 그 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않으면 소수
 - 제곱근 구하기 보다는 제곱을 구하는 것이 더 빠르다는 것을 이용
 
*/

class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;
        for(int n = 5; n <= 1000; n += 2) {
            boolean flag = true;
            for(int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;   // 곱셈 : prime[i] * prime[i]
                                // 나눗셈 : n % prime[i]
                if(n % prime[i] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                prime[ptr++] = n;
                counter++;  // 이때도 prime[i] * prime[i] 연산 실행되었ㅇ므로 카운터 증가
            }
        }
        for(int i = 0; i < ptr; i++) {
            System.out.print(prime[i] + " ");
        }

        System.out.println("\n곱셈과 나눗셈 수행한 횟수 : " + counter);
    }
}
