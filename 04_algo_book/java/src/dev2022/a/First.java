package dev2022.a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    Date date;
    int price;

    public Pair(Date date, int price) {
        this.date = date;
        this.price = price;
    }
}

public class First {

    public static void main(String[] args) {
        First f = new First();

        String[] purchase = {
                "2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"
        };
        
        f.solution(purchase);
    }

    public int[] solution(String[] purchase) {
        int[] answer = {};
        int totalPrice = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        for (String p : purchase) {
            String date = p.split(" ")[0];
            String price = p.split(" ")[1];
            totalPrice += Integer.parseInt(price);

            Queue<Date> q = new LinkedList<>();

            Date parsedDate = null;
            try {
                parsedDate = sdf.parse(date);
                q.offer(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }






            System.out.println("format = " + parsedDate);
            System.out.println("totalPrice = " + totalPrice);

        }


        return answer;
    }
}
