package db;

import pojo.Calendar;
import db.dao.CalendarDAO;
import serialization.JAXBSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class CalendarDatabaseManager {
    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "calendars")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Calendars {
                @XmlElement(name = "calendars")
                private List<Calendar> calendars = null;

                public List<Calendar> getCalendars() {
                    return calendars;
                }

                public void setCalendars(List<Calendar> calendarList) {
                    this.calendars = calendarList;
                }
            }

            CalendarDAO calendarDAO = new CalendarDAO();
            List<Calendar> calendarList = calendarDAO.getAll();

            Calendars calendars = new Calendars();
            calendars.setCalendars(calendarList);
//            JAXBSerialization.jaxbSerializeObject("CalendarListXML.xml", calendars);
            calendars = JAXBSerialization.jaxbDeSerializeObject("CalendarListXML.xml", Calendars.class);
            calendarDAO.insertAll(calendars.getCalendars());
        } catch (CalendarDAO.CalendarDAOException e) {
            e.printStackTrace();
        }
    }
}
