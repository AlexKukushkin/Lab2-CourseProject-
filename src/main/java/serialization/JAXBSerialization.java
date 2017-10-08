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

        Doctor doctor1 = new Doctor("doc", "d","Иван", "Иванович", "Иванов",
                "1980/05/01", "b101", "неврология");

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
            Doctor doctor2 = new Doctor("doc2", "d2","Петр", "Петрович", "Петров",
                    "1980/05/01", "b102", "неврология");
            Doctor doctor3 = new Doctor("doc3", "d3","Алексей", "Алексеевич", "Алексеев",
                    "1980/05/01", "b104", "пульмонология");
            Doctor doctor4 = new Doctor("doc4", "d4","Анна", "Романовна", "Клюева",
                    "1980/05/01", "b103", "неврология");
            Doctor doctor5 = new Doctor("doc5", "d5","Ольга", "Ивановна", "Сергеева",
                    "1980/05/01", "b105", "кинезиотерапия");

            doctors.getDoctors().add(doctor2);
            doctors.getDoctors().add(doctor3);
            doctors.getDoctors().add(doctor4);
            doctors.getDoctors().add(doctor5);
        }

        Admin admin2 = new Admin("admin", "qwe12322");

        Patient patient2 = new Patient("abc", "abc","Владимир", "Владимирович",
                "Владимиров", "1980/05/01", "b557891", "sn127832",
                "str117771", "г.Москва, ул. Петропавловская 13/1, 12", "Ростов-на-Дону, пр.Ворошиловский 10, 12",
                "мужской");

        Ticket ticket = new Ticket(1, 1, 1, "понедельник", "9:00", "1980/05/01");
        MedCenter medCenter = new MedCenter("Радуга", "Адмиралтейский район","г.Санкт-Петербург, ул.Ленинградская 17");

        //serialization doctor
        jaxbSerializeObject("Doctor.xml", doctor1);
        //deserialization doctor
        Doctor doctor_deserialized = jaxbDeSerializeObject("Doctor.xml", Doctor.class);
        System.out.println(doctor_deserialized.getFirstName() + " "
                + doctor_deserialized.getFamilyName() + " " + doctor_deserialized.getPatronymic() + " "
                + doctor_deserialized.getBirthDate() + " " + doctor_deserialized.getSpecialization() + " "
                + doctor_deserialized.getOffice());

        //serialization doctor list
        jaxbSerializeObject("DoctorsList.xml", doctors);
        //deserialization doctor list
        Doctors doctors_deserialized = jaxbDeSerializeObject("DoctorsList.xml", Doctors.class);

        for(int i = 0; i < doctors_deserialized.getDoctors().size(); i++){
            System.out.println(doctors_deserialized.getDoctors().get(i).getFirstName() + " "
                    + doctors_deserialized.getDoctors().get(i).getFamilyName() + " "
                    + doctors_deserialized.getDoctors().get(i).getPatronymic() + " "
                    + doctors_deserialized.getDoctors().get(i).getBirthDate() + " "
                    + doctors_deserialized.getDoctors().get(i).getSpecialization() + " "
                    + doctors_deserialized.getDoctors().get(i).getOffice());
        }

        //serialization admin
        jaxbSerializeObject("Admin.xml", admin2);
        //deserialization admin
        Admin admin3 = jaxbDeSerializeObject("Admin.xml", Admin.class);
        System.out.println(admin3.getLogin() + " " + admin3.getPassword());

        //serialization patient
        jaxbSerializeObject("Patient.xml", patient2);
        //deserialization patient
        Patient patient3 = jaxbDeSerializeObject("Patient.xml", Patient.class);
        System.out.println(patient3.getFirstName() + " "
                + patient3.getFamilyName() + " "
                + patient3.getPatronymic() + " "
                + patient3.getBirthDate() + " "
                + patient3.getAddress() + " "
                + patient3.getRegisterLocation());

        //serialization ticket
        jaxbSerializeObject("Ticket1.xml", ticket);
        //deserialization ticket
        Ticket ticket2 = jaxbDeSerializeObject("Ticket1.xml", Ticket.class);
        System.out.println(ticket2.getIdTicket() + " " + ticket2.getIdMedCenter() + " "
                + ticket2.getIdDoctor() + " " + ticket2.getIdPatient() + " "
                + " " + ticket2.getPatientDate() + " " + ticket2.getPatientDay() + " " + ticket2.getPatientTime());

        //serialization medcenter
        jaxbSerializeObject("MedCenterDAO.xml", medCenter);
        //deserialization medcenter
        MedCenter medCenter2 = jaxbDeSerializeObject("MedCenterDAO.xml", MedCenter.class);
        System.out.println(medCenter2.getMedCenterName() + " " + medCenter2.getRegionName() + " " + medCenter2.getLocationName());
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
