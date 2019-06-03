package com.eiv.herencia;

/***
 * 
 * Una clase solo puede extender a una unica clase pero puede implementar multiples interfaces.
 * Es decir, solo puede tener una sola clase padre; no existe la herencia multiple.
 * 
 * @author diego.cairone
 *
 */
public class ClaseD extends ClaseB implements InterfazC {

    @Override
    public int metodoC() {
        return 20;
    }
}
