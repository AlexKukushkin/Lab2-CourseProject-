package dto;


public class DoctorDTO {

    private int idDoctor;
    private String firstName;
    private String familyName;
    private String patronymic;
    private String specialization;
    private String office;
    private String medcenterName;

    public DoctorDTO(int idDoctor, String firstName, String patronymic,
                     String familyName, String specialization, String office, String medcenterName) {
        this.idDoctor = idDoctor;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.familyName = familyName;
        this.specialization = specialization;
        this.office = office;
        this.medcenterName = medcenterName;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getMedcenterName() {
        return medcenterName;
    }

    public void setMedcenterName(String medcenterName) {
        this.medcenterName = medcenterName;
    }
}
