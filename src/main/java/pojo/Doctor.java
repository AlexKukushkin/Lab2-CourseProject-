package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Doctor extends User implements Serializable {
    private int idDoctor;
    private String firstName;
    private String patronymic;
    private String familyName;
    private String birthDate;
    private String office;
    private String specialization;
    private int medCenterID;

    public Doctor(String login, String password, String role, String firstName, String patronymic,
                  String familyName, String birthDate, String office, String specialization) {
        super(login, password, role);
        this.idDoctor = 0;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.office = office;
        this.specialization = specialization;
    }

    public Doctor(int idDoctor, String login, String password, String role, String firstName, String patronymic,
                  String familyName, String birthDate, String office, String specialization, int medCenterID) {
        super(login, password, role);
        this.idDoctor = idDoctor;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.office = office;
        this.specialization = specialization;
        this.medCenterID = medCenterID;
    }
    public Doctor(int idDoctor, String firstName, String patronymic, String familyName, String birthDate,
                  String office, String specialization, int medCenterID) {
        this.idDoctor = idDoctor;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.office = office;
        this.specialization = specialization;
        this.medCenterID = medCenterID;
    }

    public Doctor() {
    }

    public Doctor(String firstName, String patronymic, String familyName, String birthDate, String office, String specialization) {
        this.idDoctor = 0;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.office = office;
        this.specialization = specialization;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    @XmlElement
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @XmlElement
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFamilyName() {
        return familyName;
    }

    @XmlElement
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getOffice() {
        return office;
    }

    @XmlElement
    public void setOffice(String office) {
        this.office = office;
    }

    public String getSpecialization() {
        return specialization;
    }

    @XmlElement
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @XmlElement
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getMedCenterID() {
        return medCenterID;
    }

    @XmlElement
    public void setMedCenterID(int medCenterID) {
        this.medCenterID = medCenterID;
    }
}
