import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("ah yes");
        ArrayList<Emplyoee> eghisaifji = new ArrayList<Emplyoee>();
        ArrayList<String> thing = new ArrayList<>();
        thing.add("java");
        thing.add("c#");
        eghisaifji.add(new pprogrammer(100324, 92, thing, "aisfusahfu", "isjfisdjif", 1239876, "java camp"));
        thing.clear();
        thing.add("java");
        thing.add("rust");
        thing.add("c#");
        eghisaifji.add(new pprogrammer(100324, 92, thing, "aisfusahfu", "isjfisdjif", 12653, "java camp"));
        thing.clear();
        thing.add("java");
        thing.add("c#");
        eghisaifji.add(new pprogrammer(100324, 92, thing, "aisfusahfu", "isjfisdjif", 15423, "java camp"));
        eghisaifji.add(new Masgwehr(329, 2939, 3, "ISAJDIJASD", 27654, "aisjidjaisjd"));
        eghisaifji.add(new Masgwehr(329, 2939, 3, "ISAJDIJiisajs", 27654, "aisjidjaisjd"));
        eghisaifji.add(new Masgwehr(329, 2939, 3, "ISAJaisdjakskdjDIJASD", 2654, "aisjidjaisjd"));
        eghisaifji.add(new intern(223, "ajsdjasdjasifjsai", 223, "iasjiajsf", 345623, "iasjidajsd"));
        eghisaifji.add(new intern(223, "jasdajdk", 223, "iasjiajsf", 2765433, "iasjidajsd"));
        eghisaifji.add(new intern(223, "ajskjaksfkakfj", 223, "iasjiajsf", 232435, "iasjidajsd"));

        for (Emplyoee employee : eghisaifji) {
            System.out.println(employee.calacslalry());
            if (employee instanceof pprogrammer) {
                pprogrammer p = (pprogrammer) employee;
                p.writecode();
                p.showprogramminglangs();
                p.toString();
            }
            if (employee instanceof Masgwehr) {
                Masgwehr m = (Masgwehr) employee;
                m.cundcutMeeting();
                m.toString();
            }
            if (employee instanceof intern) {
                intern i = (intern) employee;
                i.attendtraining();
                i.toString();
            }
        }
    }

}
