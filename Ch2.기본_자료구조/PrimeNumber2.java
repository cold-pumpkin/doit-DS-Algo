/*
 * 소수 판별 알고리즘 개선(1)

 - 2부터 시작하고 홀수에 대해서만 검사
 - 소수를 구하는 과정에서 그때까지 구한 소수를 배열에 저장
 - n이 소수인지 아닌지를 판단하기 위해서 쌓아두었던 소수에서 나눗셈 진행

*/

class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0;                // 나눗셈 연산 횟수
        int ptr = 0;                    // 찾는 소수 개수 (소수 저장 인덱스)
        int[] prime = new int[500];     // 소수 저장 배열

        prime[ptr++] = 2;
        for(int n = 3; n <= 1000; n += 2) {
            int p;
            for(p = 1; p < ptr; p++) {
                counter++;
                if(n % prime[p] == 0) {
                    break;
                }
            }
            if(p == ptr) {  
                // 저장해둔 모든 소수들에 대해서도 나누어 떨어지지 않으면 소수로 추가
                prime[ptr++] = n;
            }
        }

        for(int i = 0; i < ptr; i++) {
            System.out.print(prime[i] + " ");
        }
        System.out.println("\n나눗셈 수행횟수 : " + counter);
    }
}