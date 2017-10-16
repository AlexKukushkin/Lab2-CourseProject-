package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement
public class Patient extends User implements Serializable{

    private int idPatient;
    private String firstName;
    private String familyName;
    private String patronymic;
    private String birthDate;
    private String passport;
    private String SNILS;
    private String medPolis;
    private String registerLocation;
    private String address;
    private String sexType;
    private int idUser;

    public Patient(String login, String password, String role, String firstName, String familyName, String patronymic,
                   String birthDate, String passport, String SNILS, String medPolis,
                   String registerLocation, String address, String sexType) {
        super(login, password, role);
        this.idPatient = 0;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medPolis = medPolis;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
    }

    public Patient(int idPatient, String login, String password, String role, String firstName, String familyName, String patronymic,
                   String birthDate, String passport, String SNILS, String medPolis,
                   String registerLocation, String address, String sexType) {
        super(login, password, role);
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medPolis = medPolis;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
    }

    public Patient(int idPatient, String firstName, String familyName, String patronymic,
                        String birthDate, String passport, String SNILS, String medPolis, String registerLocation,
                        String address, String sexType, int idUser) {
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medPolis = medPolis;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.idUser = idUser;
    }

    public Patient(String firstName, String familyName, String patronymic,
                   String birthDate, String passport, String SNILS, String medPolis, String registerLocation,
                   String address, String sexType, int idUser) {
        this.idPatient = 0;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medPolis = medPolis;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.idUser = idUser;
    }

    public Patient(String firstName, String familyName, String patronymic,
                   String birthDate, String passport, String SNILS, String medPolis, String registerLocation,
                   String address, String sexType) {
        this.idPatient = 0;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medPolis = medPolis;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.idUser = 0;
    }

    public Patient() {
    }

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

    public String getFamilyName() {
        return familyName;
    }

    @XmlElement
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @XmlElement
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @XmlElement
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMedPolis() {
        return medPolis;
    }

    @XmlElement
    public void setMedPolis(String medPolis) {
        this.medPolis = medPolis;
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

    public int getIdUser() {
        return idUser;
    }

    @XmlElement
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
