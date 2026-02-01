package kakaob2022;

import java.util.Stack;

public class A {

    static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static class Saving {
        String date;
        int amount;
        int rate;

        public Saving(String date, int rate, int amount) {
            this.date = date;
            this.rate = rate;
            this.amount = amount;
        }
    }

    public int solution(String[] ledgers) {
        int answer = 0;

        Stack<Saving> stk = new Stack<>();

        for (int i = 0; i < ledgers.length; i++) {

            String[] split = ledgers[i].split(" ");
            String date = split[0];
            int rate = Integer.parseInt(split[1]);
            int amount = Integer.parseInt(split[2]);

            if (amount < 0) {
                // 인출 시
                int tmp = (-1) * amount;

                while(tmp > 0) {
                    Saving pop = stk.pop();
                    if (pop.amount < tmp) {
                        tmp -= pop.amount;

                        // 이자 계산
                        answer += calculateInter(date, pop.date, pop.amount, pop.rate);

                    } else {
                        // 남은금액 입금 및 이자계산
                        pop.amount -= tmp;
                        answer += calculateInter(date, pop.date, tmp, pop.rate);
                        tmp = 0;
                        stk.add(pop);
                    }
                }
            } else {
                // 입금 시
                stk.add(new Saving(date, rate, amount));
            }
        }

        while (!stk.isEmpty()) {
            String date = "12/31";

            Saving pop = stk.pop();
            answer += calculateInter(date, pop.date, pop.amount, pop.rate);
        }

        return answer;
    }

    public int calculateInter(String date, String popDate, int amount, int rate) {
        return (int) Math.floor(amount * (rate / 100.0) * ((calculateDate(date) - calculateDate(popDate)) / 365.0));
    }

    public int calculateDate(String date) {

        String[] split = date.split("\\/");

        int monthIdx = Integer.parseInt(split[0]) - 1;
        int day = Integer.parseInt(split[1]);

        int dayCnt = 0;
        for (int i = monthIdx; i >= 0 ; i--) {
            dayCnt += days[i];
        }

        dayCnt -= days[monthIdx] - day;

        return dayCnt;
    }

    public static void main(String[] args) {
        A a = new A();

//        String[] ledgers = new String[] {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
        String[] ledgers = new String[] {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};

        a.solution(ledgers);
    }
}
