package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq_gen")
    @SequenceGenerator(allocationSize = 1, name = "patient_id_seq_gen", sequenceName = "public.\"patient_id_seq\"")
    private int idPatient;
    private String firstName;
    private String familyName;
    private String patronymic;
    private String birthDate;
    private String passport;
    private String SNILS;
    private String medpolis;
    private String registration;
    private String homeLocation;
    private String sexType;

    public PatientEntity(String firstName, String familyName, String patronymic, String birthDate,
                         String passport, String SNILS, String medpolis, String registration,
                         String homeLocation, String sexType) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.SNILS = SNILS;
        this.medpolis = medpolis;
        this.registration = registration;
        this.homeLocation = homeLocation;
        this.sexType = sexType;
    }

    @Id
    @Column(name = "id_patient")
    public int getIdPatient() {
        return idPatient;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "birth_date")
    public String getBirthDate() {
        return birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public String getSNILS() {
        return SNILS;
    }

    public String getMedpolis() {
        return medpolis;
    }

    public String getRegistration() {
        return registration;
    }

    @Column(name = "home_location")
    public String getHomeLocation() {
        return homeLocation;
    }

    @Column(name = "sextype")
    public String getSexType() {
        return sexType;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public void setMedpolis(String medpolis) {
        this.medpolis = medpolis;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
}
