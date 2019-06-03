package com.eiv.herencia;

/***
 * 
 * La clase implementa la interfaz <code>InterfazB</code> la cual a su vez extiende
 * a la interfaz <code>InterfazA</code> y por lo tanto la clase debe implementar TODOS
 * los metodos de todas las interfaces
 * 
 * @author diego.cairone
 *
 */
public class ClaseB implements InterfazB {

    @Override
    public int metodoA() {
        return 10;
    }

    @Override
    public int metodoB() {
        return 20;
    }

}
