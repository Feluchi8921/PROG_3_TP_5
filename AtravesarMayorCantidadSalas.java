import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtravesarMayorCantidadSalas {
    //Atributos
    private GrafoDirigido<Integer> grafo;
    private int entrada;
    private int salida;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMasLargo;

    //Constructor
    public AtravesarMayorCantidadSalas(GrafoDirigido<Integer> grafo, int entrada, int salida){
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
        this.caminoMasLargo = new ArrayList<>();
        this.entrada = entrada;
        this.salida = salida;
    }

    public ArrayList<Integer> caminoMayorSalas(int entrada, int salida){
        this.visitados.clear(); //limpio visitados
        this.caminoMasLargo.clear(); //limpio caminoMasLargo
        ArrayList<Integer> caminoParcial = new ArrayList<>(); //Creo un camino auxiliar
        visitados.add(entrada); //lo agrego a visitados
        caminoParcial.add(entrada); //lo agrego al camino auxiliar
        otroCaminoMasLargo(entrada, salida, caminoParcial);
        return caminoMasLargo;
    }

    private void otroCaminoMasLargo(int entrada, int salida, ArrayList<Integer> caminoParcial){
        //Si llegue a destino
        if(entrada==salida){
            if(caminoParcial.size()>=caminoMasLargo.size()){
                //Si el camino auxiliar es mayor lo reemplazo
                caminoMasLargo.clear(); //borro el camino mas largo y guardo el nuevo
                caminoMasLargo.addAll(caminoParcial);
            }
        }
        //Sino llamo a la recursion
        else{
            //Creo un iterador de adyacentes
            Iterator<Integer> it1 = this.grafo.obtenerAdyacentes(entrada);
            //mientras haya siguiente
            while(it1.hasNext()){
                //guardo el adyacente
                Integer ady = it1.next();
                //Si no fue visitado
                if(!visitados.contains(ady)){
                    //lo marco como visitado
                    visitados.add(ady);
                    //lo agrego a camino Parcial
                    caminoParcial.add(ady);
                    //llamo a la recursion y le paso el adyacente
                    otroCaminoMasLargo(ady, salida, caminoParcial);
                    //Limpio lo que agrege
                    visitados.remove(ady);
                    caminoParcial.remove(ady);
                }
            }
        }
    }
}
