package testPackage;

import datos.Reclamo;

public class Test {

    public static void main(String[] args) {
        String space = " ";
        String cat = "*";
        System.out.println(cat.repeat(36));
        System.out.println("*" + space.repeat(9) + "MENU DE OPCIONES" + space.repeat(9) + "*");
        System.out.println(cat.repeat(36));
        System.out.println("*1.Agregar Reclamo" + space.repeat(17) + "*");
        System.out.println("*2.Genrar Arbol" + space.repeat(20) + "*");
        System.out.println("*3.Proceso de Reclamos" + space.repeat(13) + "*");
        System.out.println("*4.Eliminar Reclamos" + space.repeat(15) + "*");
        System.out.println("*0.Salir" + space.repeat(27) + "*");
        System.out.println(cat.repeat(36));
        System.out.printf("-->");
    }

}
