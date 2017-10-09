package db;

import classes.Patient;
import classes.Ticket;
import db.dao.PatientDAO;
import db.dao.TicketDAO;
import serialization.JAXBSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class DatabaseManager {
    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "patients")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Patients {
                @XmlElement(name = "patients")
                private List<Patient> patients = null;

                public List<Patient> getPatients() {
                    return patients;
                }

                public void setPatients(List<Patient> patients) {
                    this.patients = patients;
                }
            }

            PatientDAO patientDAO = new PatientDAO();
            List<Patient> patientList = patientDAO.getAll();
            Patients patients = new Patients();
            patients.setPatients(patientList);
            //System.out.println(patient);
            //JAXBSerialization.jaxbSerializeObject("PatientListXML.xml", patients);
            patients = JAXBSerialization.jaxbDeSerializeObject("PatientListXML.xml", Patients.class);
            patientDAO.insertAll(patients.getPatients());
            //=====================================
            @XmlRootElement(name = "tickets")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Tickets {
                @XmlElement(name = "tickets")
                private List<Ticket> tickets = null;

                public List<Ticket> getTickets() {
                    return tickets;
                }

                public void setTickets(List<Ticket> ticketList) {
                    this.tickets = ticketList;
                }
            }

            TicketDAO ticketDAO = new TicketDAO();
            List<Ticket> ticketList = ticketDAO.getAll();
            System.out.println(ticketList);
            Tickets tickets = new Tickets();
            tickets.setTickets(ticketList);
            //JAXBSerialization.jaxbSerializeObject("TicketListXML.xml", tickets);
            tickets = JAXBSerialization.jaxbDeSerializeObject("TicketListXML.xml", Tickets.class);
            ticketDAO.insertAll(tickets.getTickets());

        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        } catch (TicketDAO.TicketDAOException e) {
            e.printStackTrace();
        }
    }
}
