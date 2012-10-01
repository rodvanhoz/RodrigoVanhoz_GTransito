/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Rodrigo Vanhoz
 */
public class Multa {
    public static enum tipoMulta {
        LEVE,
        LEVÍSSIMA,
        GRAVE,
        GRAVÍSSIMA,
        MEDIA
    }
    tipoMulta tp;
    
    private String nomeProp;
    private String descVeic;
    private Date data;
    private int pontuacao;

    public Multa() {
        nomeProp = null;
        descVeic = null;
        data = null;
        tp = tipoMulta.LEVÍSSIMA;
    }
    
    

    public Multa(String nomeProp, String descVeic, Date data, int pontuacao) {
        this.nomeProp = nomeProp;
        this.descVeic = descVeic;
        this.data = data;
        this.pontuacao = pontuacao;
    }

    public String getNomeProp() {
        return nomeProp;
    }

    public void setNomeProp(String nomeProp) {
        this.nomeProp = nomeProp;
    }

    public String getDescVeic() {
        return descVeic;
    }

    public void setDescVeic(String descVeic) {
        this.descVeic = descVeic;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public int getTamanho() {
       return tp.getDeclaringClass().getEnumConstants().length;
    }
    
    public String getNomeValor( int indice ) {
        String retorna = "";
        int ind = 0 ;
        
        for ( tipoMulta i : tipoMulta.values() ) {
            if ( ind ++ == indice ) {
                retorna = i.name();
            }
        }
        return retorna;
    }
}
