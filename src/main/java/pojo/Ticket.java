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

    private String firstName;
    private String familyName;
    private String patronymic;
    private String doctorFIO;
    private String office;
    private String specialization;
    private String centerName;

    public Ticket(int idTicket, String firstName, String familyName,
                  String patronymic, String doctorFIO, String office, String specialization, String patientDay,
                  String patientTime, String patientDate, String centerName) {
        this.idTicket = idTicket;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.doctorFIO = doctorFIO;
        this.office = office;
        this.specialization = specialization;
        this.patientDay = patientDay;
        this.patientTime = patientTime;
        this.patientDate = patientDate;
        this.centerName = centerName;
    }

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

    public String getDoctorFIO() {
        return doctorFIO;
    }

    public void setDoctorFIO(String doctorFIO) {
        this.doctorFIO = doctorFIO;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
