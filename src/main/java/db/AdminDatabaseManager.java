package db;

import classes.Admin;
import db.dao.AdminDAO;
import serialization.JAXBSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class AdminDatabaseManager {
    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "admins")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Admins {
                @XmlElement(name = "admins")
                private List<Admin> admins = null;

                public List<Admin> getAdmins() {
                    return admins;
                }

                public void setAdmins(List<Admin> adminList) {
                    this.admins = adminList;
                }
            }

            AdminDAO adminDAO = new AdminDAO();
            List<Admin> adminList = adminDAO.getAll();

            Admins admins = new Admins();
            admins.setAdmins(adminList);
            JAXBSerialization.jaxbSerializeObject("AdminListXML.xml", admins);
//            admins = jaxbDeSerializeObject("AdminListXML.xml", Admins.class);
//            adminDAO.insertAll(admins.getAdmins());
        } catch (AdminDAO.AdminDAOException e) {
            e.printStackTrace();
        }
    }
}
