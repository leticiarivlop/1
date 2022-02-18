/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.aplicacionbanco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author daw1
 */
public class Cuenta implements Comparable<Cuenta> {

    private String codigo;
    private String titular;
    private float saldo;
    List<Movimiento> movimientos;

    /**
     * Construye una nueva cuenta vacia,inicializando el codigo,el titular y el
     * saldo. Genera una lista(ArrayList) de movimientos que guarda la fecha del
     * movimineto percibido y el saldo actual de la cuenta.
     *
     * @param codigo codigo a introducido de la cuenta a crear
     * @param titular titular de la cuenta que hemos creado
     * @param saldo saldo de la cuenta
     */
    public Cuenta(String codigo, String titular, float saldo) {
        this.codigo = codigo;
        this.titular = titular;
        if (saldo >= 0) {
            this.saldo = saldo;
        }
        movimientos = new ArrayList<>();
        movimientos.add(new Movimiento(LocalDate.now(), 'I', saldo, saldo));
    }

    /**
     * Metodo que devuelve el codigo de la cuenta solicitada
     *
     * @return el codigo de la cuenta que buscamos
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que devuelve el titular de la cuenta solicitada
     *
     * @return el titular de la cuenta que buscamos
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Metodo que devuelve el saldo de la cuenta solicitada
     *
     * @return el saldo de la cuenta que buscamos
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Metodo que permite listar los movientos realizados en la cuenta
     *
     * @return devuelve los movimientos realizados en la cuenta
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * Método que permite listar los movimientos que se han realizado, añadiendo
     * la fecha a la cual se realizó.
     *
     * @param desde Fecha desde que se realizó el primer movimiento.
     * @param hasta Fecha del último movimiento.
     * @return Una lista con los movimientos que se han realizado.
     */
    public List<Movimiento> getMovimiento(LocalDate desde, LocalDate hasta) {
        List<Movimiento> salida = new ArrayList<>();
        Iterator<Movimiento> li = movimientos.iterator();
        Movimiento m;

        while (li.hasNext()) {
            System.out.print(li.next());
            m = li.next();
            if (m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta)) {
            }
        }
        return salida;
    }

    /**
     * Método que nos permite modificar el codigo de una cuenta en particular.
     *
     * @param codigo Código de la cuenta.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que nos permite modificar el titular de una cuenta.
     *
     * @param titular Titular de la cuenta.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Método nos permite modificar un saldo de una cuenta en concreto.
     *
     * @param saldo Saldo de la cuenta.
     */
    public void setSaldo(float saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo + "," + titular + "," + saldo;
    }

    /**
     * Metodo que permite ingresar dinero en la cuenta
     *
     * @param cantidad cantidad a ingresar en la cuenta
     */
    public void ingresar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'I', cantidad, saldo));
        }
    }

    /**
     * Metodo que permite reintegrar el dinero de la cuenta
     *
     * @param cantidad cantidad a reintegrar en la cuenta
     */
    public void reintegrar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'R', -cantidad, saldo));
        }
    }

    /**
     * Metodo que nos permite realizar una transferencia de una cantidad de
     * dinero determinadad, desde una cuenta origen a una cuenta destino.
     * Además, permite conocer la fecha a la cual se hizo la transferencia,
     * añadiendo un movimiento a la cuenta a ambas cuentas.
     *
     * @param destino Cuenta de destino al que se le realiza la transferencia.
     * @param cantidad Cantidad de dinero que se quiere transferir.
     */
    public void realizarTransferencia(Cuenta destino, float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            destino.saldo += cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'T', -cantidad, saldo));
            destino.movimientos.add(new Movimiento(LocalDate.now(), 'T', cantidad, destino.saldo));
        }
    }

    /**
     * Metodo que permite listar los movimientos de la cuenta
     *
     * @return devuelve los movimientos realizados en la cuenta
     */
    public String listarMovimientos() {
        StringBuilder sb = new StringBuilder();

        for (Movimiento m : movimientos) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Cuenta o) {
        return this.codigo.compareTo(o.codigo);
    }

}
