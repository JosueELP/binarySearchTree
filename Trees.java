/**
 * Trees
 */
import java.util.Scanner;
public class Trees {
    private Node raiz;
    private Node aux;
    //Setters and Getters
    public void setRaiz(Node raiz){
        this.raiz = raiz;
    }
    public Node getRaiz(){
        return raiz;
    }
    public void setAux(Node aux){
        this.aux = aux;
    }
    public Node getAux(){
        return raiz;
    }
    //CREAR ARBOL   
    public void create(int number){
        if(raiz == null){
            Node n = new Node();
            n.setHD(null);
            n.setHI(null);
            n.setNumber(number);
            raiz = n;
        }else{
            System.out.println("El arbol ya esta creado");
        }
    }
    //INSERTAR AL ARBOL
    public void insert(Node ra, int number){
        Node p = ra;
        if(number < p.getNumber()){
            if(p.getHI() == null){
                Node n = new Node();
                n.setHD(null);
                n.setHI(null);
                n.setNumber(number);
                p.setHI(n);
            }else{
                insert(p.getHI(), number);
            }
        }else if(number > p.getNumber()){
            if(p.getHD() == null){
                Node n = new Node();
                n.setHD(null);
                n.setHI(null);
                n.setNumber(number);
                p.setHD(n);
            }else{
                insert(p.getHD(), number);
            }
        }else{
            System.out.println("El nodo ya se encuentra en el arbol");
        }
    }
    //CONSULTA
    public void individualQuery(Node raiz, int number){
        Node p = raiz;
        if(number < p.getNumber() && p.getHI() != null){
            individualQuery(p.getHI(), number);
        }else if(number > p.getNumber() && p.getHD() != null){
            individualQuery(p.getHD(), number);
        }else if (number == p.getNumber()){
            showInfo(p);
        }else{
            System.out.println("Numero no encontrado");
        }
    }
    //ELIMINAR
    public void delete(Node ra, Node aux ,int number){
        Node p = ra;
        Node q = aux, o = null, r=null;
        if(number < p.getNumber()){
            q = p;
            delete(p.getHI(), q ,number);
        }else if(number > p.getNumber()){
            q = p;
            delete(p.getHD(), q ,number);
        }else{
            o = p;
            if(o.getHI() == null && o.getHD() == null){
                if(o == raiz){
                    raiz = null;
                }else{ 
                    if(q.getHI() == p){
                        q.setHI(p.getHI());
                    }else if(q.getHD() == p){
                        q.setHD(p.getHD());
                    }
                } 
            }else{
                if(o.getHD() == null){
                    if(o == raiz){
                        raiz = o.getHI();
                    }else{
                        p = o.getHI();
                        o.setNumber(p.getNumber());
                        o.setHI(p.getHI());
                        o.setHD(p.getHD());
                        o = p;
                    }
                }else{
                    if(o.getHI() == null){
                        if(o == raiz){
                            raiz = o.getHD();
                        }else{
                            p = o.getHD();
                            o.setNumber(p.getNumber());
                            o.setHI(p.getHI());
                            o.setHD(p.getHD());
                            o = p;
                        }
                    }else{
                        q = o.getHI();
                        r = q;
                        while (q.getHD() != null) {
                            r = q;
                            q = q.getHD();
                        }
                        o.setNumber(q.getNumber());
                        o = q;
                        r.setHD(q.getHI());
                        if(p.getHI() == o){
                            p.setHI(o.getHI());
                        }else if(p.getHD() == o){
                            p.setHD(o.getHD());
                        }
                    }
                }
            }
        }
        p = null;
        q = null;
        o = null;
        r = null;
    }
    //RECORRIDO PREORDEN
    public void preOrder(Node ra){
        Node p = ra;
        if(p != null){
            showInfo(p);
            preOrder(ra.getHI());
            preOrder(ra.getHD());
        }
    }
    //RECORRIDO INORDEN
    public void inOrder(Node ra){
        Node p = ra;
        if(p != null){
            inOrder(ra.getHI());
            showInfo(p);
            inOrder(ra.getHD());
        }
    }
    //RECORRIDO POSTORDEN
    public void postOrder(Node ra){
        Node p = ra;
        if(p != null){
            inOrder(ra.getHI());
            inOrder(ra.getHD());
            showInfo(p);
        }
    } 
    //IMPRIMIR DATOS DEL NODO
    public void showInfo(Node p){
        System.out.println("--------------------------");
        System.out.println("Numero: " + p.getNumber());
        System.out.println("--------------------------");
    }
    //VALIDACION DEL NUMERO
    public int validateNumber(){
        Scanner sc = new Scanner(System.in);
        int number=0;
        do {
            System.out.println("Ingrese el numero [1-100]: ");
            try{
              number = Integer.parseInt(sc.nextLine());
            }
            catch(Exception e){
              System.out.println("ENTRADA NO VALIDA");
              continue;
            }
            if(number < 1 || number > 100){
                System.out.println("Error, intente de nuevo");
            }
        } while (number < 1 || number > 100);
        return number;
    }
    //METODOS AUXILIARES
    public boolean emptyTree(){
        if(raiz == null){
          return true;
        }
        return false;
    }
}