package serialization;

import db.dao.CalendarDAO;
import org.apache.log4j.Logger;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBSerialization {
    private static final Logger logger = Logger.getLogger(JAXBSerialization.class);

    public static void jaxbSerializeObject(String fileName, Object object) {
        try {

            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);

        } catch (JAXBException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    public static <T> T jaxbDeSerializeObject(String filePath, Class<T> tClass) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return tClass.cast(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return null;
    }
}
