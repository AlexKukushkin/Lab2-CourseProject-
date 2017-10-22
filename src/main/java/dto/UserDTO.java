package dto;

public class UserDTO {
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

    public UserDTO(String firstName, String familyName, String patronymic, String birthDate, String passport,
                   String SNILS, String medPolis, String registerLocation, String address, String sexType) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getMedPolis() {
        return medPolis;
    }

    public void setMedPolis(String medPolis) {
        this.medPolis = medPolis;
    }

    public String getRegisterLocation() {
        return registerLocation;
    }

    public void setRegisterLocation(String registerLocation) {
        this.registerLocation = registerLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
}
