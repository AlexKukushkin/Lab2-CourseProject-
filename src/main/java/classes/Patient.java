package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Patient extends User{

    private int idPatient;
    private String sexType;
    private String firstName;
    private String secondName;
    private String familyName;
    private String birthDay;
    private int polisNumber;
    private String passport;
    private String SNILS;
    private String address;
    private String registerLocation;

    public int getIdPatient() {
        return idPatient;
    }

    @XmlElement
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getSexType() {
        return sexType;
    }

    @XmlElement
    public void setSexType(String sexType) {
        this.sexType = sexType;
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

    public String getBirthDay() {
        return birthDay;
    }

    @XmlElement
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getPolisNumber() {
        return polisNumber;
    }

    @XmlElement
    public void setPolisNumber(int polisNumber) {
        this.polisNumber = polisNumber;
    }

    public String getPassport() {
        return passport;
    }

    @XmlElement
    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSNILS() {
        return SNILS;
    }

    @XmlElement
    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterLocation() {
        return registerLocation;
    }

    @XmlElement
    public void setRegisterLocation(String registerLocation) {
        this.registerLocation = registerLocation;
    }

    public Patient() {
    }

    public Patient(String login, String password, int idPatient, String sexType, String firstName,
                   String secondName, String familyName, String birthDay, int polisNumber, String passport,
                   String SNILS, String address, String registerLocation)
    {
        super(login, password);
        this.idPatient = idPatient;
        this.sexType = sexType;
        this.firstName = firstName;
        this.secondName = secondName;
        this.familyName = familyName;
        this.birthDay = birthDay;
        this.polisNumber = polisNumber;
        this.passport = passport;
        this.SNILS = SNILS;
        this.address = address;
        this.registerLocation = registerLocation;
    }
}
