package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Doctor implements Serializable{
    private int idDoctor;
    private String firstName;
    private String secondName;
    private String familyName;
    private String office;
    private int idSpecialization;
    private String specialization;

    public Doctor() {
    }

    public Doctor(int idDoctor, String firstName, String secondName, String familyName, String office, int idSpecialization, String specialization) {
        this.idDoctor = idDoctor;
        this.firstName = firstName;
        this.secondName = secondName;
        this.familyName = familyName;
        this.office = office;
        this.idSpecialization = idSpecialization;
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

    public String getSecondName() {
        return secondName;
    }

    @XmlElement
    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public int getIdSpecialization() {
        return idSpecialization;
    }

    @XmlElement
    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @XmlElement
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
