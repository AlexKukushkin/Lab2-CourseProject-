package pojo;

import java.io.Serializable;

public class Calendar implements Serializable {

    private int idCalendar;
    private int idDoctor;
    private String monDay;
    private String tuesDay;
    private String wednesDay;
    private String thursDay;
    private String friDay;
    private String saturDay;
    private String sunDay;

    private String firstName;
    private String familyName;
    private String patronymic;
    private String specialization;
    private String office;

    public Calendar(int idCalendar, int idDoctor, String monDay, String tuesDay,
                    String wednesDay, String thursDay, String friDay, String saturDay, String sunDay,
                    String firstName, String familyName, String patronymic, String specialization, String office) {
        this.idCalendar = idCalendar;
        this.idDoctor = idDoctor;
        this.monDay = monDay;
        this.tuesDay = tuesDay;
        this.wednesDay = wednesDay;
        this.thursDay = thursDay;
        this.friDay = friDay;
        this.saturDay = saturDay;
        this.sunDay = sunDay;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.specialization = specialization;
        this.office = office;
    }

    public Calendar() {
    }

    public Calendar(int idDoctor, String monDay, String tuesDay,
                    String wednesDay, String thursDay, String friDay,
                    String saturDay, String sunDay) {
        this.idCalendar = 0;
        this.idDoctor = idDoctor;
        this.monDay = monDay;
        this.tuesDay = tuesDay;
        this.wednesDay = wednesDay;
        this.thursDay = thursDay;
        this.friDay = friDay;
        this.saturDay = saturDay;
        this.sunDay = sunDay;
    }

    public Calendar(int idCalendar, int idDoctor, String monDay, String tuesDay,
                    String wednesDay, String thursDay, String friDay,
                    String saturDay, String sunDay) {
        this.idCalendar = idCalendar;
        this.idDoctor = idDoctor;
        this.monDay = monDay;
        this.tuesDay = tuesDay;
        this.wednesDay = wednesDay;
        this.thursDay = thursDay;
        this.friDay = friDay;
        this.saturDay = saturDay;
        this.sunDay = sunDay;
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
        return monDay;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }

    public String getTuesDay() {
        return tuesDay;
    }

    public void setTuesDay(String tuesDay) {
        this.tuesDay = tuesDay;
    }

    public String getWednesDay() {
        return wednesDay;
    }

    public void setWednesDay(String wednesDay) {
        this.wednesDay = wednesDay;
    }

    public String getThursDay() {
        return thursDay;
    }

    public void setThursDay(String thursDay) {
        this.thursDay = thursDay;
    }

    public String getFriDay() {
        return friDay;
    }

    public void setFriDay(String friDay) {
        this.friDay = friDay;
    }

    public String getSaturDay() {
        return saturDay;
    }

    public void setSaturDay(String saturDay) {
        this.saturDay = saturDay;
    }

    public String getSunDay() {
        return sunDay;
    }

    public void setSunDay(String sunDay) {
        this.sunDay = sunDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
