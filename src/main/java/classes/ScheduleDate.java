package classes;

import java.io.Serializable;

public class ScheduleDate implements Serializable{

    public static void sheduleTime() {
        int SIZE = 7;
        String[][] schedule = new String[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                schedule[i][j] = "8.30 - 9.30";
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(schedule[i][j]);
            }
            System.out.println();
        }
    }
}
