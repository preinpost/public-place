package leetcode.N1491;

// 1491. Average Salary Excluding the Minimum and Maximum Salary
class Solution {
    public double average(int[] salary) {
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        double sum = 0;

        for (int sal : salary) {
            sum += sal;
            maxSalary = Math.max(sal, maxSalary);
            minSalary = Math.min(sal, minSalary);
        }

        sum -= maxSalary;
        sum -= minSalary;

        return sum / (salary.length - 2);
    }
}