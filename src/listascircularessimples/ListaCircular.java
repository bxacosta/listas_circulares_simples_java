package listascircularessimples;
/**
 * 
 * @author xavier
 */
public class ListaCircular {
    // Puntero que indica el inicio de la lista o conocida tambien
    // como cabeza de la lista.
    private Nodo inicio;
    // Puntero que indica el final de la lista o el ultimo nodo.
    private Nodo ultimo;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;
    /**
     * Constructor por defecto.
     */
    public void Lista(){
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }
    /**
     * Consulta si la lista esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Consulta cuantos elementos (nodos) tiene la lista.
     * @return numero entero entre [0,n] donde n es el numero de elementos
     * que contenga la lista.
     */
    public int getTamanio(){
        return tamanio;
    }
    /**
     * Agrega un nuevo nodo al final de la lista circular.
     * @param valor a agregar.
     */
    public void agregarAlFinal(int valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            ultimo = nuevo;
            // Y el puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
        // Caso contrario el nodo se agrega al final de la lista.
        } else{
            // Apuntamos con el ultimo nodo de la lista al nuevo.
            ultimo.setSiguiente(nuevo);
            // Apuntamos con el nuevo nodo al inicio de la lista.
            nuevo.setSiguiente(inicio);
            // Como ahora como el nuevo nodo es el ultimo se actualiza
            // la variable ultimo.
            ultimo = nuevo;
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }
    /**
     * Agrega un nuevo nodo al inicio de la lista circular.
     * @param valor a agregar.
     */   
    public void agregarAlInicio(int valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            ultimo = nuevo;  
            // Y el puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
        // Caso contrario va agregando los nodos al inicio de la lista.
        } else{
            // Une el nuevo nodo con la lista existente.
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = nuevo;
            // El puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }
    /**
     * Inserta un nuevo nodo despues de otro, ubicado por el valor que contiene.
     * @param referencia valor del nodo anterios al nuevo nodo a insertar.
     * @param valor del nodo a insertar.
     */
    public void insertarPorReferencia(int referencia, int valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Verifica si la lista contiene elementos
        if (!esVacia()) {
            // Consulta si el valor existe en la lista.
            if (buscar(referencia)) {
                // Crea ua copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                // Consulta si el nodo a insertar va despues del ultimo
                if (aux == ultimo) {
                    // Apuntamos con el ultimo nodo de la lista al nuevo.
                    aux.setSiguiente(nuevo);
                    // Apuntamos con el nuevo nodo al inicio de la lista.
                    nuevo.setSiguiente(inicio);
                    // Como ahora como el nuevo nodo es el ultimo se actualiza
                    // la variable ultimo.
                    ultimo = nuevo;
                } else {
                    // Crea un respaldo de la continuación de la lista.
                    Nodo siguiente = aux.getSiguiente();
                    // Enlaza el nuevo nodo despues del nodo de referencia.
                    aux.setSiguiente(nuevo);
                    // Une la continuacion de la lista al nuevo nodo.
                    nuevo.setSiguiente(siguiente);
                }
                // Incrementa el contador de tamaño de la lista.
                tamanio++;
            }
        }      
    }
    /**
     * Inserta un nuevo nodo despues en una posición determinada.
     * @param posicion en la cual se va a insertar el nuevo nodo.
     * @param valor valor del nuevo nodo de la lista.
     */
    public void insrtarPorPosicion(int posicion, int valor){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if(posicion>=0 && posicion<=tamanio){
            Nodo nuevo = new Nodo();
            nuevo.setValor(valor);
            // Consulta si el nuevo nodo a ingresar va al inicio de la lista.
            if(posicion == 0){
                // Une el nuevo nodo con la lista existente.
                nuevo.setSiguiente(inicio);
                // Renombra al nuevo nodo como el inicio de la lista.
                inicio = nuevo;
                // El puntero del ultimo debe apuntar al primero.
                ultimo.setSiguiente(inicio);
            }
            else{
                // Si el nodo a inserta va al final de la lista.
                if(posicion == tamanio){
                    // Apuntamos con el ultimo nodo de la lista al nuevo.
                    ultimo.setSiguiente(nuevo);
                    // Apuntamos con el nuevo nodo al inicio de la lista.
                    nuevo.setSiguiente(inicio);
                    // Como ahora como el nuevo nodo es el ultimo se actualiza
                    // la variable ultimo.
                    ultimo = nuevo;     
                }
                else{
                    // Si el nodo a insertar va en el medio de la lista.
                    Nodo aux = inicio;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Nodo siguiente = aux.getSiguiente();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setSiguiente(nuevo);
                    // Une el nuevo nodo con el resto de la lista.
                    nuevo.setSiguiente(siguiente);
                }
            }
            // Incrementa el contador de tamaño de la lista.
            tamanio++;
        }
    }
    /**
     * Obtiene el valor de un nodo en una determinada posición.
     * @param posicion del nodo que se desea obtener su valor.
     * @return un numero entero entre [0,n-1] n = numero de nodos de la lista.
     * @throws Exception
     */
    public int getValor(int posicion) throws Exception{
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tamanio){
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getValor();
            }else{
                // Crea una copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Retorna el valor del nodo.
                return aux.getValor();
            }
        // Crea una excepción de Posicion inexistente en la lista.
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    /**
     * Busca si existe un valor en la lista.
     * @param referencia valor a buscar.
     * @return true si existe el valor en la lista.
     */
    public boolean buscar(int referencia){
        // Crea una copia de la lista.
        Nodo aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al primer nodo nuevamente.
        do{
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getValor()){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    /**
     * Consulta la posición de un elemento en la lista
     * @param referencia valor del nodo el cual se desea saber la posición.
     * @return un valor entero entre [0,n] que indica la posición del nodo. 
     * @throws Exception 
     */
    public int getPosicion(int referencia) throws Exception{
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea una copia de la lista.
            Nodo aux = inicio;
            // COntado para almacenar la posición del nodo.
            int cont = 0;
            // Recoore la lista hasta llegar al nodo de referencia.
            while(referencia != aux.getValor()){
                // Incrementa el contador.
                cont ++;
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
            // Retorna el valor del contador.
            return cont;
        // Crea una excepción de Valor inexistente en la lista.
        } else {
            throw new Exception("Valor inexistente en la lista.");
        }
    }
    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     * @param referencia valor del nodo el cual se desea actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editarPorReferencia(int referencia, int valor){
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al nodo de referencia.
            while(aux.getValor() != referencia){
                aux = aux.getSiguiente();
            }
            // Actualizamos el valor del nodo
            aux.setValor(valor);
        }
    }
    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado
     * por su posición.
     * @param posicion en la cual se encuentra el nodo a actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editarPorPosicion(int posicion , int valor){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tamanio){
            // Consulta si el nodo a eliminar es el primero.
            if(posicion == 0){
                // Alctualiza el valor delprimer nodo.
                inicio.setValor(valor);
            }
            else{
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                Nodo aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Alctualiza el valor del nodo.
                aux.setValor(valor);
            }
        }
    }
    /**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     * @param referencia valor del nodo que se desea eliminar.
     */
    public void removerPorReferencia(int referencia){
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (inicio.getValor() == referencia) {
                // El primer nodo apunta al siguiente.
                inicio = inicio.getSiguiente();
                // Apuntamos con el ultimo nodo de la lista al inicio.
                ultimo.setSiguiente(inicio); 
            } else{
                // Crea ua copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while(aux.getSiguiente().getValor() != referencia){
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a eliminar.
                    Nodo siguiente = aux.getSiguiente();
                    // Enlaza el nodo anterior al de eliminar con el 
                    // sguiente despues de el.
                    aux.setSiguiente(siguiente.getSiguiente());  
                    // Actualizamos el puntero del ultimo nodo
                }
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }
    /**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por su posición.
     * @param posicion en la cual se encuentra el nodo a eliminar.
     */
    public void removerPorPosicion(int posicion){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tamanio){
            // Consulta si el nodo a eliminar es el primero
            if(posicion == 0){
                // Elimina el primer nodo apuntando al siguinte.
                inicio = inicio.getSiguiente();
                // Apuntamos con el ultimo nodo de la lista al inicio.
                ultimo.setSiguiente(inicio);
            }
            // En caso que el nodo a eliminar este por el medio 
            // o sea el ultimo
            else{
                // Crea una copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a eliminar.
                    Nodo siguiente = aux.getSiguiente();
                    // Enlaza el nodo anterior al de eliminar con el 
                    // sguiente despues de el.
                    aux.setSiguiente(siguiente.getSiguiente());  
                    // Actualizamos el puntero del ultimo nodo
                }
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }
    /**
     * Elimina la lista
     */
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Elimina el valor y la referencia al primer nodo.
        ultimo = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
    
    /**
     * Mustra en pantalla los elementos de la lista.
     */
    public void listar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            Nodo aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }while(aux != inicio);
        }
    }
}
