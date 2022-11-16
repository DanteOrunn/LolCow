// ARBOL DE BUSQUEDA BINARIA
package arbolapp;

import datos.Alumno;
import datos.DatoArbol;
import datos.Reclamo;
import entradaDatos.Consola;
import nodoAB.Nodo;
import estructuras.ArbolBinarioBusqueda;
import java.util.Scanner;
import listaSE.ListaSe;
import listaSE.NodoL;

public class ArbolBBAPP {

    private ListaSe lista, listaNovedades;
    private ArbolBinarioBusqueda abbIndice;

    public ArbolBBAPP() {
        abbIndice = new ArbolBinarioBusqueda();
        lista = new ListaSe();
        listaNovedades = new ListaSe();
    }

    public static void main(String[] args) {
        ArbolBBAPP MiArbol = new ArbolBBAPP();
        MiArbol.menuDeOpciones();
    }

    public void cargarLista(ListaSe lista) {
        do {
            Reclamo reclamo = new Reclamo();
            boolean res=false;
            do{
                reclamo.cargarDNI();
                res=lista.search(reclamo);
                if(res)
                    System.out.println("Reclamo existente");
            }while(res);            
            reclamo.cargarDatos();
            lista.insert(reclamo);
        } while (Consola.deseaContinuar());
    }

    public void generarArbolIndice() {
        NodoL p = lista.inicio();
        while (p != null) {
            DatoArbol nuevo = new DatoArbol(p.getDato().getDni(), p);
            // si el nodo de la lista es Object =>
            //DatoArbol nuevo = new DatoArbol(((Alumno)p.getDato()).getDni(), p);
            //leer linea 43 en clase DatoArbol si se quiere generalizar
            abbIndice.insertar(nuevo);
            p=p.getPs();
        }
        System.out.println("Arbol Creado!");
    }

    public void actualizar() {
        NodoL p = listaNovedades.inicio();
        while (p != null) {
            //si NodoL es object aqui se aplica cast tambien
            Nodo buscado = abbIndice.buscar(new DatoArbol(p.getDato().getDni(), p));
            if (buscado == null) {
                lista.insert(p.getDato());
                abbIndice.insertar(new DatoArbol(p.getDato().getDni(), lista.inicio()));
            } else {
                ((DatoArbol) buscado.getDato()).getDir().setDato(p.getDato());
            }
            p=p.getPs();
        }
        listaNovedades=new ListaSe();
        System.out.println("Lista novedades eliminada");
    }

    public void procesarReclamos() {
        //dni->busca arbol reclamo,->si esta en gestio pasa a true
        Reclamo r=new Reclamo();
        r.cargarDNI();
        Nodo buscado=abbIndice.buscar(new DatoArbol(r.getDni()));
        if(buscado!=null){
            r=((DatoArbol)buscado.getDato()).getDir().getDato();
            if(r.isEstadoReclamo()){
                System.out.println("solucionado");
            }else{
                r.setEstadoReclamo(true);
                System.out.println("Se soliciono el problema");
            }
        }else{
            System.out.println("No se encontro registro");
        }
    }

    public void eliminarReclamo() {
        Reclamo r=new Reclamo();
        r.cargarDNI();
        Nodo buscado = abbIndice.borrarElem(new DatoArbol(r.getDni()));
        if (buscado != null) {
            System.out.println("El elemento no existe");
        } else {
            System.out.println("Elemento eliminado");
        }
    }

    public void menuDeOpciones() {
        Scanner ingreso = new Scanner(System.in);
        int option;
        do {
            menu();
            option = Integer.parseInt(ingreso.nextLine());
            switch (option) {
                case 1:
                    cargarLista(lista);
		            abbIndice = new ArbolBinarioBusqueda();
                    break;
                case 2:
                    generarArbolIndice();
                    System.out.println("Arbol Generado");
                    Consola.pausa();
                    break;
                case 3:
                    procesarReclamos();
                    break;
                case 4:
                    eliminarReclamo();
                    break;
                case 5:
                    abbIndice.postorden();
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

    private void menu() {
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
