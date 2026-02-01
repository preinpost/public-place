package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Property implements Comparable<Property> {
    int weight;
    int height;
    int index;

    public Property(int weight, int height, int index) {
        this.weight = weight;
        this.height = height;
        this.index = index;
    }

    @Override
    public int compareTo(Property o) {
        if (o.weight == this.weight) return this.height- o.height;
        return this.weight- o.weight;
    }
}

public class B7568 {

    static int[] answer;

    public static void main(String[] args) {

        B7568 b7568 = new B7568();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Property> properties = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            properties.add(new Property(a, b, i));
        }
        answer = new int[n];
        b7568.sol(properties);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public void sol(List<Property> properties) {
        Collections.sort(properties);


        for (int i = 0; i < properties.size(); i++) {
            Property current = properties.get(i);
            int rank = 1;

            for (int j = i+1; j < properties.size(); j++) {
                if (current.weight < properties.get(j).weight && current.height < properties.get(j).height) rank++;
            }
            answer[current.index] = rank;
        }
    }
}


