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
    private String chassi;
    private String nomeProp;
    private String placa;

    public Veiculos() {
        codigo = -1;
        descr = null;
        chassi = null;
        nomeProp = null;
        placa = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getNomeProp() {
        return nomeProp;
    }

    public void setNomeProp(String nomeProp) {
        this.nomeProp = nomeProp;
    }

}
