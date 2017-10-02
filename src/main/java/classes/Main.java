package classes;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1, "Иван", "Иванович", "Иванов",
                "a101", 1, "Неврология");

        Admin admin1 = new Admin("admin", "qwe123");

        admin1.logIn("admin");
        admin1.setPassword("qwe123");

        Patient patient1 = new Patient("abc", "abc", 11, "male", "Владимир",
                "Владимирович", "Владимиров", "19/06/1988", 1234567,
                "B1110333", "1000BCA", "Ростов-на-Дону, пр.Ворошиловский 10, 12",
                "г.Москва, ул.Пушкина 15, 1");


        System.out.println(admin1.getLogin() + " " + admin1.getPassword());
        System.out.println(doctor1.getFirstName() + " " + doctor1.getSecondName() + " " + doctor1.getFamilyName());
        System.out.println(patient1.getFirstName() + " " + patient1.getSecondName() + " " + patient1.getFamilyName());
    }
}
