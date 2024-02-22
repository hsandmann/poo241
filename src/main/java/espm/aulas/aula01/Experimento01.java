package espm.aulas.aula01;

public class Experimento01 {

    public static void main(String[] args) {

        String a = "espm";
        String b = "espm";
        String c = "es";
        String d = c + "pm";
        System.out.println(a + " == " + b + " : " + (a == b));
        System.out.println(a + " == " + d + " : " + (a == d));
        System.out.println(a + " equals " + d + " : " + (a.equals(d)));
        
    }

}
