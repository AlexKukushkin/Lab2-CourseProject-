package db;

import pojo.Ticket;
import db.dao.TicketDAO;
import serialization.JAXBSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class TicketDatabaseManager {
    public static void main(String[] args) {
        try {
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
//            JAXBSerialization.jaxbSerializeObject("TicketListXML.xml", tickets);
            tickets = JAXBSerialization.jaxbDeSerializeObject("TicketListXML.xml", Tickets.class);
            ticketDAO.insertAll(tickets.getTickets());
        } catch (
                TicketDAO.TicketDAOException e)
        {
            e.printStackTrace();
        }
    }
}

