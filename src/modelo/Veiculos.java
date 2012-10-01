/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rodrigo Vanhoz
 */
public class Veiculos {
    private int codigo;
    private String descr;
    private double chassi;
    private String nomeProp;

    public Veiculos() {
        codigo = -1;
        descr = null;
        chassi = 0;
        nomeProp = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getChassi() {
        return chassi;
    }

    public void setChassi(double chassi) {
        this.chassi = chassi;
    }

    public String getNomeProp() {
        return nomeProp;
    }

    public void setNomeProp(String nomeProp) {
        this.nomeProp = nomeProp;
    }

}
