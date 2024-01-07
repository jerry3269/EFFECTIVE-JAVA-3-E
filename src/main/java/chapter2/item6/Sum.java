package chapter2.item6;

import java.util.Comparator;

// 코드 6-3 끔찍이 느리다! 객체가 만들어지는 위치를 찾았는가? (34쪽)
public class Sum {

    //오토박싱 O
    private static long sumSlow() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    //오토박싱 X
    private static long sumFast() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();

            if (d % 2 == 0) x += sumSlow(); //args[1]가 짝수(0포함)일 경우 Slow 실행
            else x += sumFast();            //args[1]가 홀수일 경우 Fast 실행

            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // VM이 최적화하지 못하게 막는 코드
        if (x == 42)
            System.out.println();
    }
}
