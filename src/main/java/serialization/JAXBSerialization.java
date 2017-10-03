package serialization;

import classes.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class JAXBSerialization {
    public static void main(String[] args) {

        Doctor doctor1 = new Doctor(1, "Андрей", "Иванович", "Петров",
                "a102", 1, "Хирургия");

        @XmlRootElement(name = "doctors")
        @XmlAccessorType(XmlAccessType.FIELD)
        class Doctors
        {
            @XmlElement(name = "doctors")
            private List<Doctor> doctors = null;

            public List<Doctor> getDoctors() {
                return doctors;
            }

            public void setDoctors(List<Doctor> doctors) {
                this.doctors = doctors;
            }
        }
        Doctors doctors = new Doctors();
        {
            doctors.setDoctors(new ArrayList<>());
            Doctor doctor2 = new Doctor(1, "Андрей", "Иванович", "Петров",
                    "a102", 1, "Хирургия");
            Doctor doctor3 = new Doctor(2, "Михаил", "Иванович", "Петров",
                    "a103", 2, "Стоматология");
            Doctor doctor4 = new Doctor(3, "Василий", "Иванович", "Петров",
                    "a104", 3, "Неврология");
            Doctor doctor5 = new Doctor(4, "Владимир", "Иванович", "Петров",
                    "a105", 4, "Нейрохирургия");

            doctors.getDoctors().add(doctor2);
            doctors.getDoctors().add(doctor3);
            doctors.getDoctors().add(doctor4);
            doctors.getDoctors().add(doctor5);
        }

        Admin admin2 = new Admin("admin", "qwe12322");

        Patient patient2 = new Patient("abc", "abc", 11, "male", "Владимир",
                "Владимирович", "Владимиров", "19/06/1988", 1234567,
                "B1110333", "1000BCA", "Ростов-на-Дону, пр.Ворошиловский 10, 12",
                "г.Москва, ул.Пушкина 15, 1");

        Ticket ticket = new Ticket("МедЦентр Здоровье", doctor1, "12.01.2017 9:00");
        MedCenter medCenter = new MedCenter(111, "МедЦентр 'Здоровье'",
                53, "Тульская область",
                12, "Ворошиловский райнон");

        jaxbSerializeObject("Doctor.xml", doctor1);
        Doctor doctor_deserialized = jaxbDeSerializeObject("Doctor.xml", Doctor.class);

        System.out.println(doctor_deserialized.getFirstName() + " "
                + doctor_deserialized.getSecondName() + " " + doctor_deserialized.getFamilyName() + " "
                + doctor_deserialized.getSpecialization() + " " + doctor_deserialized.getOffice());

        jaxbSerializeObject("DoctorsList.xml", doctors);
        Doctors doctors_deserialized = jaxbDeSerializeObject("DoctorsList.xml", Doctors.class);

        for(int i = 0; i < doctors_deserialized.getDoctors().size(); i++){
            System.out.println(doctors_deserialized.getDoctors().get(i).getFirstName() + " "
                    + doctors_deserialized.getDoctors().get(i).getSecondName() + " " + doctors_deserialized.getDoctors().get(i).getFamilyName() + " "
                    + doctors_deserialized.getDoctors().get(i).getSpecialization() + " " + doctors_deserialized.getDoctors().get(i).getOffice());
        }

        //Admin object Serialization
        jaxbSerializeObject("Admin.xml", admin2);
        //Admin object DeSerialization
        Admin admin3 = jaxbDeSerializeObject("Admin.xml", Admin.class);

        System.out.println(admin3.getLogin() + " " + admin3.getPassword());

        //Patient object Serialization
        jaxbSerializeObject("Patient.xml", patient2);
        //Patient object DeSerialization
        Patient patient3 = jaxbDeSerializeObject("Patient.xml", Patient.class);

        System.out.println(patient3.getFirstName() + " "
                + patient3.getSecondName() + " "
                + patient3.getFamilyName() + " "
                + patient3.getBirthDay() + " "
                + patient3.getAddress() + " "
                + patient3.getRegisterLocation());

        //Ticket object Serialization
        jaxbSerializeObject("Ticket1.xml", ticket);
        //Ticket object DeSerialization
        Ticket ticket2 = jaxbDeSerializeObject("Ticket1.xml", Ticket.class);

        System.out.println(ticket2.getCenterName() + " "
                + ticket2.getDoctor().getFirstName() + " " + ticket2.getDoctor().getSecondName() + " "
                + ticket2.getDoctor().getFamilyName() + " " + ticket2.getDateTime());

        //MedCenter object Serialization
        jaxbSerializeObject("MedCenter.xml", medCenter);
        //MedCenter object Serialization
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
