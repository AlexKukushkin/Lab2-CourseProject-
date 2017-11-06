package dto;


public class TicketDTO {

    private int idTicket;
    private String doctorFIO;
    private String office;
    private String specialization;
    private String time;
    private String date;

    public TicketDTO(int idTicket, String doctorFIO, String office, String specialization, String time, String date) {
        this.idTicket = idTicket;
        this.doctorFIO = doctorFIO;
        this.office = office;
        this.specialization = specialization;
        this.time = time;
        this.date = date;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
