package dsa.striver.greedyalgorithms;

import java.util.Arrays;

public class AssignCookies {

    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        //your code goes here

        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int l = 0, r =0;

        while (l < Student.length && r < Cookie.length) {

            if (Student[l] <= Cookie[r]) {
                l++;
            }
            r++;
        }

        return l;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int student[] = {1, 2};
        int cookie[] = {1, 2, 3};
        System.out.println(assignCookies.findMaximumCookieStudents(student, cookie));
    }
}
