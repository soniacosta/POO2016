import java.io.Serializable;
/**
 * Write a description of class Imovel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Imovel implements Serializable{
    
    public int classe;
    private String idImovel;
    private String rua;
    private double precoPedido;
    private double precoMinimo;
    private String estado; //em venda, reservado, vendido

    // Constructor for objects of class Imovel
    /**
    * Construtor vazio
    */
    public Imovel() {
        // initialise instance variables
        classe = 0;
        idImovel = "";
        rua = "";
        precoPedido = 0;
        precoMinimo = 0;
        estado = "";
    }
    /**
    * construtor parametrizado
    */
    public Imovel(int cl, String id, String r, double pp, double pm, String e) {
        // initialise instance variables
        classe = cl;
        idImovel = id;
        rua = r;
        precoPedido = pp;
        precoMinimo = pm;
        estado = e;
    }

    /** 
     * Construtor de cópia.
     */
    public Imovel(Imovel a) {
        this(a.getClasse(), a.getIdImovel(), a.getRua(), a.getPrecoPedido(), a.getPrecoMinimo(), a.getEstado());
    }

    //metodos de instancia
    //getters 
    public int getClasse() { return classe; }

    public String getIdImovel() { return idImovel; }

    public String getRua() { return rua; }

    public double getPrecoPedido() { return precoPedido; }

    public double getPrecoMinimo() { return precoMinimo; }
    
    public String getEstado() { return estado; }

    //setters
    public void setClasse(int cl) { classe = cl; }

    public void setIdImovel(String id) { idImovel = id; }

    public void setRua(String r) { rua = r; }

    public void setPrecoPedido(double pp) { precoPedido = pp; }

    public void setPrecoMinimo(double pm) { precoMinimo = pm; }
    
    public void setEstado(String e) { estado = e; }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("idImovel: "); s.append(this.getIdImovel()+"\n");
        s.append("Rua: "); s.append(this.rua+"\n");
        s.append("Preço Pedido: "); s.append(this.precoPedido+"\n");
        s.append("Estado: "); s.append(this.getEstado()+"\n");
        return s.toString();
    }
    
    public Imovel clone(){
        Imovel i = new Imovel(this);
        return i;
    }
    
    public boolean equals(Imovel a){
        if(a != null) return (this.classe==a.getClasse() &&
                              this.idImovel.equals(a.getIdImovel()) &&
                              this.rua.equals(a.getRua()) &&
                              this.precoPedido == a.getPrecoPedido() &&
                              this.precoMinimo == a.getPrecoMinimo() &&
                              this.estado.equals(a.getEstado())
                              );
        else return false;
    }

}
