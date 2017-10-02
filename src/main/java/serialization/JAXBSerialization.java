package serialization;

import classes.*;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBSerialization {
    public static void main(String[] args) {
        Doctor doctor2 = new Doctor(1, "Андрей", "Иванович", "Петров",
                "a102", 1, "Хирургия");

        Admin admin2 = new Admin("admin", "qwe123");

        admin2.logIn("admin");
        admin2.setPassword("qwe123");

        Patient patient2 = new Patient("abc", "abc", 11, "male", "Владимир",
                "Владимирович", "Владимиров", "19/06/1988", 1234567,
                "B1110333", "1000BCA", "Ростов-на-Дону, пр.Ворошиловский 10, 12",
                "г.Москва, ул.Пушкина 15, 1");

        Ticket ticket = new Ticket("МедЦентр Здоровье", doctor2, "12.01.2017 9:00");
        MedCenter medCenter = new MedCenter(111, "МедЦентр 'Здоровье'",
                                            53, "Тульская область",
                                            12, "Ворошиловский райнон");

        jaxbSerializeObject("Doctor.xml", doctor2);
        Doctor doctor3 = jaxbDeSerializeObject("Doctor.xml", Doctor.class);

        System.out.println(doctor3.getFirstName() + " "
                + doctor3.getSecondName() + " " + doctor3.getFamilyName() + " "
                + doctor3.getSpecialization() + " " + doctor3.getOffice());


        jaxbSerializeObject("Admin.xml", admin2);
        Admin admin3 = jaxbDeSerializeObject("Admin.xml", Admin.class);

        System.out.println(admin3.getLogin()+ " " + admin3.getPassword());

        jaxbSerializeObject("Patient.xml", patient2);
        Patient patient3 = jaxbDeSerializeObject("Patient.xml", Patient.class);

        System.out.println(patient3.getFirstName() + " "
                            + patient3.getSecondName() + " "
                            + patient3.getFamilyName() + " "
                            + patient3.getBirthDay() + " "
                            + patient3.getAddress() + " "
                            + patient3.getRegisterLocation());

        jaxbSerializeObject("Ticket1.xml", ticket);
        Ticket ticket2 = jaxbDeSerializeObject("Ticket1.xml", Ticket.class);

        System.out.println(ticket2.getCenterName() + " "
                + ticket2.getDoctor().getFirstName() + " " + ticket2.getDoctor().getSecondName() + " "
                + ticket2.getDoctor().getFamilyName() + " " + ticket2.getDateTime());

        jaxbSerializeObject("MedCenter.xml", medCenter);
        MedCenter medCenter2 = jaxbDeSerializeObject("MedCenter.xml", MedCenter.class);

        System.out.println(medCenter2.getCenterName() + " "
                + medCenter2.getRegionName() + " " + medCenter2.getLocationName());
    }

    public static void jaxbSerializeObject(String fileName, Object object) {
        try {

            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jaxbDeSerializeObject(String filePath, Class<T> tClass) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return tClass.cast(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
