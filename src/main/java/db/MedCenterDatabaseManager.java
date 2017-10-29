package db;

import org.apache.log4j.Logger;
import pojo.MedCenter;
import db.dao.MedCenterDAO;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static serialization.JAXBSerialization.jaxbDeSerializeObject;

public class MedCenterDatabaseManager {
    private static final Logger logger = Logger.getLogger(MedCenterDatabaseManager.class);

    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "medCenters")
            @XmlAccessorType(XmlAccessType.FIELD)
            class MedCenters {
                @XmlElement(name = "medCenters")
                private List<MedCenter> medCenters = null;

                public List<MedCenter> getMedCenters() {
                    return medCenters;
                }

                public void setMedCenters(List<MedCenter> medCenterList) {
                    this.medCenters = medCenterList;
                }
            }

            MedCenterDAO medCenterDAO = new MedCenterDAO();
            List<MedCenter> medCenterList = medCenterDAO.getAll();

            MedCenters medCenters = new MedCenters();
            medCenters.setMedCenters(medCenterList);
            //JAXBSerialization.jaxbSerializeObject("MedCenterListXML.xml", medCenters);
            medCenters = jaxbDeSerializeObject("MedCenterListXML.xml", MedCenters.class);
            medCenterDAO.insertAll(medCenters.getMedCenters());
        } catch (MedCenterDAO.MedCenterDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
