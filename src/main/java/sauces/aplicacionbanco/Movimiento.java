/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.aplicacionbanco;

import java.time.LocalDate;

/**
 *
 * @author daw1
 */
public class Movimiento {

    private LocalDate fecha;
    private char tipo;
    private float cantidad;
    private float saldo;

    /**
     * Construye un movimiento vacio que inicializa la fecha, el tipo de
     * movimiento, la cantidad del movimiento y el saldo actual.
     *
     * @param fecha Fecha en la que se realiza el movimiento.
     * @param tipo Tipo de movimiento.
     * @param cantidad Cantidad de dinero que se ha efectuado en el movimiento.
     * @param saldo Saldo de la cuenta actual.
     */
    public Movimiento(LocalDate fecha, char tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    /**
     * Método que devuelve la fecha.
     *
     * @return Un LocalDate del movimiento.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Metodo que establece la fecha local del sistema
     * @param fecha fecha del sistema
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Método que devuelve el tipo de movimiento.
     *
     * @return Tipo de movimiento que se ha realizado.
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo de movimiento
     * @param tipo tipo de movimiento
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que devuelve la cantidad de dinero que se ha efectuado en el
     * movimiento.
     *
     * @return Cantidad del movimiento.
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Metodo que establece la cantidad del movimiento
     * @param cantidad cantidad del moviento
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que devuelve el saldo de la cuenta en el momento.
     *
     * @return Saldo de la cuenta en el momento del movimiento.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Metodo que establece el saldo de una cuenta despues del moviento
     * @param saldo de la cuenta
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return fecha + "," + tipo + "," + cantidad + "," + saldo;
    }
}
