package classes;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("doc1", "d1","Иван", "Иванович", "Иванов",
                "1975/05/05", "a111", "травматология");

        Admin admin1 = new Admin("admin", "qwe123");

        Patient patient1 = new Patient("kkk", "8", "Петр", "Петров",
                "Петрович", "1985/05/05", "b123457", "SN12231",
                "str12305", "Ростов-на-Дону, пр.Ворошиловский 10, 12",
                "г.Москва, ул.Пушкина 15, 1", "мужской");

        System.out.println(admin1.getLogin() + " " + admin1.getPassword());
        System.out.println(doctor1.getFirstName() + " " + doctor1.getFamilyName() + " " + doctor1.getPatronymic() + " " + doctor1.getBirthDate());
        System.out.println(patient1.getFirstName() + " " + patient1.getFamilyName() + " " + patient1.getPatronymic() + " " + patient1.getBirthDate());
    }
}
