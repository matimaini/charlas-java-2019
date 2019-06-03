package com.eiv.herencia;

/**
 * Una clase puede implementar mas de una interfaz
 * 
 * @author diego.cairone
 *
 */
public class ClaseC implements InterfazB, InterfazC {

    @Override
    public int metodoA() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public int metodoC() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public int metodoB() {
        // TODO Auto-generated method stub
        return 30;
    }

}
