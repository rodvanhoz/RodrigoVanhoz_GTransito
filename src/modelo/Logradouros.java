
package modelo;

public class Logradouros {

    private int    codlog;
    private String descr;
    private String bairro;
    private String cep;
    private String cidade;

    public Logradouros(){
        codlog = -1;
        descr  = null;
        bairro = null;
        cep    = null;
        cidade = null;
    }

    public void setcodlog(int codlog){
        this.codlog = codlog;
    }

    public void setdescr(String descr){
        this.descr = descr;
    }

    public void setbairro(String bairro){
        this.bairro = bairro;
    }

    public void setcep(String cep){
        this.cep = cep;
    }

    public void setcidade(String cidade){
        this.cidade = cidade;
    }

    public int getcodlog(){
        return this.codlog;
    }

    public String getcodlogstr(){
        return new Integer(this.codlog).toString();
    }

    public String getdescr(){
        return this.descr;
    }

    public String getbairro(){
        return this.bairro;
    }

    public String getcep(){
        return this.cep;
    }

    public String getcidade(){
        return this.cidade;
    }
}
