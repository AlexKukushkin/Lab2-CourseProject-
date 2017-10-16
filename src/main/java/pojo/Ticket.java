package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Ticket implements Serializable {
    private int idTicket;
    private int idPatient;
    private int idDoctor;
    private int idMedCenter;
    private String patientDay;
    private String patientTime;
    private String patientDate;

    public Ticket() {
    }

    public Ticket(int idTicket, int idPatient, int idDoctor, int idMedCenter, String patientDay, String patientTime, String patientDate) {
        this.idTicket = idTicket;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.idMedCenter = idMedCenter;
        this.patientDay = patientDay;
        this.patientTime = patientTime;
        this.patientDate = patientDate;
    }
    public Ticket(int idPatient, int idDoctor, int idMedCenter, String patientDay, String patientTime, String patientDate) {
        this.idTicket = 0;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.idMedCenter = idMedCenter;
        this.patientDay = patientDay;
        this.patientTime = patientTime;
        this.patientDate = patientDate;
    }

    public int getIdTicket() {
        return idTicket;
    }

    @XmlElement
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdPatient() {
        return idPatient;
    }

    @XmlElement
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    @XmlElement
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdMedCenter() {
        return idMedCenter;
    }

    @XmlElement
    public void setIdMedCenter(int idMedCenter) {
        this.idMedCenter = idMedCenter;
    }

    public String getPatientDay() {
        return patientDay;
    }

    @XmlElement
    public void setPatientDay(String patientDay) {
        this.patientDay = patientDay;
    }

    public String getPatientTime() {
        return patientTime;
    }

    @XmlElement
    public void setPatientTime(String patientTime) {
        this.patientTime = patientTime;
    }

    public String getPatientDate() {
        return patientDate;
    }

    @XmlElement
    public void setPatientDate(String patientDate) {
        this.patientDate = patientDate;
    }
}
