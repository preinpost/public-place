package devtest2022a;

public class A {

    /*              (앞)     (뒤)
        감소하지 않는 형태 a <= b

        원래점수와 바뀐 점수 차이의 합을 구해야한다
     */

    public static void main(String[] args) {
        A a = new A();

//        int[] grade = new int[] {3,3,3,3,3,2};
//        int[] grade = new int[] {2,1,3};
        int[] grade = new int[] {3,2,3,6,4,5};

        int solution = a.solution(grade);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] grade) {
        int answer = 0;

        int min = Integer.MAX_VALUE;

        for (int i = grade.length-1; i >= 0; i--) {

            min = Math.min(min, grade[i]);

            if (grade[i] > min) {
                answer += grade[i] - min;
            }
        }

        return answer;
    }

}
