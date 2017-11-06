package db.entities;


import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_id_seq_gen")
    @SequenceGenerator(allocationSize = 1, name = "ticket_id_seq_gen", sequenceName = "public.\"ticket_id_seq\"")
    private int idTicket;
    private String timePatient;
    private String datePatient;

    public TicketEntity(int idTicket, String timePatient, String datePatient) {
        this.idTicket =  idTicket;
        this.timePatient = timePatient;
        this.datePatient = datePatient;
    }

    @Id
    @Column(name = "id_ticket")
    public int getIdTicket() {
        return idTicket;
    }

    @Column(name = "time_patient")
    public String getTimePatient() {
        return timePatient;
    }

    @Column(name = "date_patient")
    public String getDatePatient() {
        return datePatient;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setTimePatient(String timePatient) {
        this.timePatient = timePatient;
    }

    public void setDatePatient(String datePatient) {
        this.datePatient = datePatient;
    }
}
