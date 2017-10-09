package classes;

import java.io.Serializable;

public class Calendar implements Serializable {

    private int idCalendar;
    private int idDoctor;
    private String MonDay;
    private String TuesDay;
    private String WednesDay;
    private String ThursDay;
    private String FriDay;
    private String SaturDay;
    private String SunDay;

    public Calendar() {
    }

    public Calendar(int idDoctor, String monDay, String tuesDay,
                    String wednesDay, String thursDay, String friDay,
                    String saturDay, String sunDay) {
        this.idCalendar = 0;
        this.idDoctor = idDoctor;
        MonDay = monDay;
        TuesDay = tuesDay;
        WednesDay = wednesDay;
        ThursDay = thursDay;
        FriDay = friDay;
        SaturDay = saturDay;
        SunDay = sunDay;
    }

    public Calendar(int idCalendar, int idDoctor, String monDay, String tuesDay,
                    String wednesDay, String thursDay, String friDay,
                    String saturDay, String sunDay) {
        this.idCalendar = idCalendar;
        this.idDoctor = idDoctor;
        MonDay = monDay;
        TuesDay = tuesDay;
        WednesDay = wednesDay;
        ThursDay = thursDay;
        FriDay = friDay;
        SaturDay = saturDay;
        SunDay = sunDay;
    }

    public int getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(int idCalendar) {
        this.idCalendar = idCalendar;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getMonDay() {
        return MonDay;
    }

    public void setMonDay(String monDay) {
        MonDay = monDay;
    }

    public String getTuesDay() {
        return TuesDay;
    }

    public void setTuesDay(String tuesDay) {
        TuesDay = tuesDay;
    }

    public String getWednesDay() {
        return WednesDay;
    }

    public void setWednesDay(String wednesDay) {
        WednesDay = wednesDay;
    }

    public String getThursDay() {
        return ThursDay;
    }

    public void setThursDay(String thursDay) {
        ThursDay = thursDay;
    }

    public String getFriDay() {
        return FriDay;
    }

    public void setFriDay(String friDay) {
        FriDay = friDay;
    }

    public String getSaturDay() {
        return SaturDay;
    }

    public void setSaturDay(String saturDay) {
        SaturDay = saturDay;
    }

    public String getSunDay() {
        return SunDay;
    }

    public void setSunDay(String sunDay) {
        SunDay = sunDay;
    }

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
