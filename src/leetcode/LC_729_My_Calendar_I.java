package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_729_My_Calendar_I {

    // Passed, but lack performance

    // Difficulty: MEDIUM

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        boolean isBooked = false;

        List<Integer[]> values1 = Arrays.asList(new Integer[]{10,20},                new Integer[]{15,25},                new Integer[]{30,20});
        for (Integer[] book : values1) {
            isBooked = myCalendar.book(book[0], book[1]);
            System.out.printf("%s \n", isBooked ? "Booked!" : "Not Booked!");
        }

        myCalendar.clear();
        System.out.println("\nTest2\n");

        List<Integer[]> values2 = Arrays.asList(new Integer[]{20,29},                new Integer[]{13,22},                new Integer[]{44,50},
                new Integer[]{1,7}  ,                new Integer[]{2,10} ,                new Integer[]{14,20},
                new Integer[]{19,25},                new Integer[]{36,42},                new Integer[]{45,50},//
                new Integer[]{47,50},                new Integer[]{39,45},                new Integer[]{44,50},
                new Integer[]{16,25},                new Integer[]{45,50},                new Integer[]{45,50},//
                new Integer[]{12,20},                new Integer[]{21,29},                new Integer[]{11,20},
                new Integer[]{12,17},                new Integer[]{34,40},                new Integer[]{10,18},
                new Integer[]{38,44},                new Integer[]{23,32},                new Integer[]{38,44},
                new Integer[]{15,20},                new Integer[]{27,33},                new Integer[]{34,42},
                new Integer[]{44,50},                new Integer[]{35,40},                new Integer[]{24,31});

        for (Integer[] book : values2) {
            isBooked = myCalendar.book(book[0], book[1]);
            System.out.printf("%s \n", isBooked ? "Booked!" : "Not Booked!");
        }

        myCalendar.clear();
        System.out.println("\nTest3\n");

        List<Integer[]> values3 = Arrays.asList(new Integer[]{23, 32},                new Integer[]{42,50},                new Integer[]{6,14},
                new Integer[]{0,7},                new Integer[]{21,30},                new Integer[]{26,31});

        for (Integer[] book : values3) {
            isBooked = myCalendar.book(book[0], book[1]);
            System.out.printf("%s \n", isBooked ? "Booked!" : "Not Booked!");
        }
    }

    private static class MyCalendar {

        List<Integer[]> allBookings;

        public MyCalendar() {
            this.allBookings = new ArrayList<>();
        }

        public void clear() {
            this.allBookings.clear();
        }

        public boolean book(int startTime, int endTime) {
           boolean isDoubleBooking = allBookings.parallelStream()
                    .anyMatch(book ->
                            ((startTime < book[0] && book[0] < endTime) || (startTime < book[1] && book[1] <= endTime))
                            || ((book[0] < startTime && startTime < book[1]) || (book[0] < endTime && endTime < book[1]))
                    );
            if (!isDoubleBooking) {
                this.allBookings.add(new Integer[]{ startTime, endTime });
            }
            return !isDoubleBooking;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

}
