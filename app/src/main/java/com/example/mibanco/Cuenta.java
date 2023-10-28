package com.example.mibanco;

import java.io.Serializable;

public class Cuenta implements Serializable {
    private String rut;
    private String nombres;
    private String apellidos;
    private String numSecreto;
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(String rut, String nombres, String apellidos, String numSecreto, int saldo) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numSecreto = numSecreto;
        this.saldo = saldo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumSecreto() {
        return numSecreto;
    }

    public void setNumSecreto(String numSecreto) {
        this.numSecreto = numSecreto;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean validar() {
        boolean errores = false;
        if(rut.trim().length() ==0) errores = true;
        if(nombres.trim().length() ==0) errores = true;
        if(apellidos.trim().length() ==0) errores = true;
        if(numSecreto.trim().length() != 6) errores = true;
        if(saldo < 0) errores = true;
        return !errores;
    }
    public boolean depositar(int monto) throws Exception {
        if(monto > 0) {
            saldo += monto;
            return true;
        } else {
            throw new Exception("Deposito no puede ser negativo!");
        }
    }
    public boolean girar(int monto) throws Exception {
        if(saldo < monto) {
            throw new Exception("No alcanza la plata para girar");
        }else if(monto < 0) {
            throw new Exception("Monto no puede ser negativo");
        } else {
            saldo -= monto;
            return true;
        }
    }
    public boolean pagar(String rut, String clave, int monto) throws Exception {
        if(saldo < monto) {
            throw new Exception("No alcanza la plata para el pago");
        }else if(monto < 0) {
            throw new Exception("Monto no puede ser negativo");
        } else if(rut.equals(this.rut) == false) {
            throw new Exception("Rut no coincide");
        } else if(clave != numSecreto){
            throw new Exception("numero secreto no coincide");
        } else {
            saldo -= monto;
            return true;
        }
    }

}
