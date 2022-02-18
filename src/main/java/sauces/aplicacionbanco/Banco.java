/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.aplicacionbanco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class Banco {

    private String nombre;
    private List<Cuenta> cuentas;

    /**
     * Método que inicializa el nombre de la cuenta. Además guarda el nombre en
     * un Hashset.
     *
     * @param nombre Nombre de la cuenta.
     */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new ArrayList<>();
    }

    /**
     * Método que devuleve el nombre de la cuenta solicitada.
     *
     * @return Nombre de la cuenta solicitada.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que guarda las cuentas creadas en una lista (ArrayList).
     *
     * @return Lista de cuentas creadas.
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Método que modifica el nombre de la cuenta solicitada.
     *
     * @param nombre Nombre de la cuenta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Método que nos permite abrir una cuenta, estableciendole un código, un
     * titular y un saldo.
     *
     * @param codigo Codigo de la cuenta.
     * @param titular Titular de la cuenta.
     * @param saldo Saldo de la cuenta.
     * @return Verdadero si la cuenta ha sido creada con éxito.
     */
    public boolean abrirCuenta(String codigo, String titular, float saldo) {
        boolean salida = false;

        if (buscarCuenta(codigo) == -1) {
            salida = cuentas.add(new Cuenta(codigo, titular, saldo));
        }
        return salida;
    }

    /**
     * Método que develve la cuenta en funcion del código que se le ha
     * solicitado.
     *
     * @param codigo Codigo de la cuenta.
     * @return Cuenta en funcion del codigo solicitado.
     */
    public Cuenta getCuenta(String codigo) {
        Cuenta c = null;
        int posicion;

        posicion = buscarCuenta(codigo);
        if (posicion != -1) {
            c = cuentas.get(posicion);
        }
        return c;
    }

    /**
     * Método que permite cancelar una cuenta pasándole un codigo de cuenta
     * concreto.
     *
     * @param codigo Codigo de la cuenta.
     * @return Verdadero si la cuenta ha sido cancelada con éxito.
     */
    public boolean cancelarCuenta(String codigo) {
        boolean salida = false;
        Cuenta c = getCuenta(codigo);

        if (c != null) {
            salida = cuentas.remove(c);
        }
        return salida;

    }

    /**
     * Método que devuelve el total de depositos de las cuentas creadas.
     *
     * @return Total de depositos de las cuentas creadas.
     */
    public float getTotalDepositos() {
        float acumulador = 0;
        for (Cuenta c : cuentas) {
            acumulador += c.getSaldo();
        }
        return acumulador;
    }

    private int buscarCuenta(String codigo) {
        int posicion = -1;

        for (int i = 0; i < cuentas.size() && posicion == -1; i++) {
            if (cuentas.get(i).getCodigo().equals(codigo)) {
                posicion = i;
            }
        }
        return posicion;
    }

}