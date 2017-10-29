package db;

import org.apache.log4j.Logger;
import pojo.Doctor;
import db.dao.DoctorDAO;
import serialization.JAXBSerialization;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class DoctorDatabaseManager {
    private static final Logger logger = Logger.getLogger(DoctorDatabaseManager.class);

    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "doctors")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Doctors {
                @XmlElement(name = "doctors")
                private List<Doctor> doctors = null;

                public List<Doctor> getDoctors() {
                    return doctors;
                }

                public void setDoctors(List<Doctor> doctorList) {
                    this.doctors = doctorList;
                }
            }

            DoctorDAO doctorDAO = new DoctorDAO();
            List<Doctor> doctorList = doctorDAO.getAll();

            Doctors doctors = new Doctors();
            doctors.setDoctors(doctorList);
//            JAXBSerialization.jaxbSerializeObject("DoctorListXML.xml", doctors);
            doctors = JAXBSerialization.jaxbDeSerializeObject("DoctorListXML.xml", Doctors.class);
            doctorDAO.insertAll(doctors.getDoctors());
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
