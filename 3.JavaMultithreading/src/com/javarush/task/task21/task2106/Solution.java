package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Solution)) return false;//++
        if (this == o) return true; //++

        Solution solution1 = (Solution) o; //+

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false; //++
        if (anInt != solution1.anInt) return false; //++
        if ((date != null ? date.equals(solution1.date) : solution1.date == null)!=true )return false;//++
        if ((solution != null ? solution.equals(solution1.solution) : solution1.solution == null)!=true) return false;//+
        return string != null ? string.equals(solution1.string) : solution1.string == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        //result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        HashSet<Solution> set = new HashSet<>();
        Solution sol = new Solution(10,"nigers",22, new Date(new Date().getTime()),null);
        set.add(sol);
        System.out.println(set.contains(new Solution(10,"nigers",22, new Date(new Date().getTime()),null)));

    }
}
