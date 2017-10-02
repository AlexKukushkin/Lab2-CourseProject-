package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Ticket implements Serializable {
    private String centerName;
    private Doctor doctor;
    private String dateTime;

    public Ticket() {
    }

    public Ticket(String centerName, Doctor doctor, String dateTime) {
        this.centerName = centerName;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public String getCenterName() {
        return centerName;
    }

    @XmlElement
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @XmlElement
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateTime() {
        return dateTime;
    }

    @XmlElement
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
