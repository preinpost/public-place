package devtest2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Two {


    public static class Pot {
        private int takeTime;
        private int stagedTime;

        public Pot(int takeTime, int stagedTime) {
            this.takeTime = takeTime;
            this.stagedTime = stagedTime;
        }

        public String toString() {
            return "[takeTime = " + takeTime + " | stagedTime = " + stagedTime + "]";
        }
    }

    static class Solution {
        public int solution(int n, String[] recipes, String[] orders) {

            HashMap<String, Integer> recipeMap = new HashMap<>();

            for (String recipe : recipes) {
                String[] split = recipe.split("\\s+");
                recipeMap.put(split[0], Integer.parseInt(split[1]));
            }

            int time = 1;

            ArrayList<Pot> firePit = new ArrayList<>(n); // 화구

            ArrayList<String> orderList = new ArrayList<>(Arrays.asList(orders));

            while (true) {
                System.out.println("============================");
                System.out.println("time = " + time);

                String itemName = null;
                int startTime = 0;


                if(orderList.size() > 0) {
                    String orderSet = orderList.get(0);
                    String[] split = orderSet.split("\\s+");


                    itemName = split[0];
                    startTime = Integer.parseInt(split[1]);
                }

                System.out.println(String.format("Current Pointer = %s", itemName));
                System.out.println("orderList.size() = " + orderList.size());

                for (int i = 0 ; i < firePit.size() ; i++) {
                    boolean isComplete = checkExpired(firePit.get(i));
//                    System.out.println(String.format("평가 항목 : %s | 완료 여부 : %s", firePit.get(i), isComplete));


                    if (isComplete) {
                        firePit.remove(i);
                    } else {
                        Pot pot = firePit.get(i);
                        pot.stagedTime++;
                    }
                }

                System.out.println("firePit.size() = " + firePit.size());
                                                    // time이 4초 일때, B 3이 들어가야 함
                if (itemName != null && firePit.size() < n && startTime <= time) {
                    firePit.add(new Pot(recipeMap.get(itemName), 1));
                    System.out.println("ItemAdded = " + itemName);

                    if (orderList.size() > 0) {
                        orderList.remove(0);
                    }
                }


                System.out.println("firePit = " + firePit);

                if (time != 0 && firePit.size() == 0) {
                    break;
                }

                time++;



            }

            return time;
        }

        public boolean checkExpired(Pot firedPot) {
            if (firedPot.stagedTime == firedPot.takeTime) {
                System.out.println("somepot END");
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int n = 2;
//        String[] recipes = {"A 3","B 2"};
//        String[] orders = {"A 1","A 2","B 3","B 4"};


//        int n = 3;
//        String[] recipes = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
//        String[] orders = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"};


        int n = 1;
        String[] recipes = {"COOKIE 10000"};
        String[] orders = {"COOKIE 300000"};
//        310000


        int answer = sol.solution(n, recipes, orders);
        System.out.println("answer = " + answer);

    }
}
