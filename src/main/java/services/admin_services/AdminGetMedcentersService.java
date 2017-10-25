package services.admin_services;

import db.dao.MedCenterDAO;
import org.apache.log4j.Logger;
import pojo.MedCenter;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class AdminGetMedcentersService {
    private static final Logger logger = Logger.getLogger(AdminGetMedcentersService.class);

    public List<MedCenter> doAdminGetMedcenters() throws ServletException, IOException {
        List<MedCenter> medCenters = null;

        try {
            medCenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return medCenters;
    }
}
