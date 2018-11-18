/**
 * Menu
 */
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trees tree = new Trees();
        int opc = 0;
        do {
            System.out.println("--ARBOLES--");
            System.out.println("[1] Crear Arbol");
            System.out.println("[2] Insertar");
            System.out.println("[3] Consultar");
            System.out.println("[4] Eliminar");
            System.out.println("[5] Recorrido Preorden");
            System.out.println("[6] Recorrido Inorden");
            System.out.println("[7] Recorrido Postorden");
            System.out.println("[8] Salir");
            System.out.println("Ingrese su eleccion: ");
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opción incorrecta, intente nuevamente");
                continue;
            }
            switch (opc) {
                case 1:
                    if(!tree.emptyTree()){
                        System.out.println("El arbol ya ha sido creado");
                    }else{
                        tree.create(tree.validateNumber());
                    } 
                    break;
                case 2:
                    if(!tree.emptyTree()){
                        tree.insert(tree.getRaiz(),tree.validateNumber());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 3:
                    if(!tree.emptyTree()){
                        tree.individualQuery(tree.getRaiz(),tree.validateNumber());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 4:
                    if(!tree.emptyTree()){
                        tree.delete(tree.getRaiz(), tree.getAux() ,tree.validateNumber());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 5:
                    if(!tree.emptyTree()){
                        tree.preOrder(tree.getRaiz());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 6:
                    if(!tree.emptyTree()){
                        tree.inOrder(tree.getRaiz());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 7:
                    if(!tree.emptyTree()){
                        tree.postOrder(tree.getRaiz());
                    }else{
                        System.out.println("El arbol no ha sido creado");
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción incorrecta, intente nuevamente");
                    break;
            }
        } while (opc != 8);
    }
}