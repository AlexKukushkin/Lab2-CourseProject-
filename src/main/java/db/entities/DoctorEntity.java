package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_id_seq_gen")
    @SequenceGenerator(allocationSize = 1, name = "doctor_id_seq_gen", sequenceName = "public.\"doctor_id_seq\"")
    private int idDoctor;
    private String firstName;
    private String familyName;
    private String patronymic;
    private String birthDate;
    private String specialization;
    private String office;

    public DoctorEntity(String firstName, String familyName, String patronymic,
                        String birthDate, String specialization, String office) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.specialization = specialization;
        this.office = office;
    }

    @Id
    @Column(name = "id_doctor")
    public int getIdDoctor() {
        return idDoctor;
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

    public String getSpecialization() {
        return specialization;
    }

    public String getOffice() {
        return office;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
