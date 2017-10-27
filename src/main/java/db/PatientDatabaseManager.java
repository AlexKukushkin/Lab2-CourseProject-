package db;

import org.apache.log4j.Logger;
import pojo.Patient;
import db.dao.PatientDAO;
import serialization.JAXBSerialization;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class PatientDatabaseManager {
    private static final Logger logger = Logger.getLogger(PatientDatabaseManager.class);

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
            JAXBSerialization.jaxbSerializeObject("PatientListXML.xml", patients);
//            patients = JAXBSerialization.jaxbDeSerializeObject("PatientListXML.xml", Patients.class);
//            patientDAO.insertAll(patients.getPatients());
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}

