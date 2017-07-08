
/**
 * Write a description of class Loja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loja extends Imovel{
    // instance variables - replace the example below with your own
    //classe deste é 2 = loja
    private String tipo; //tipo de negocio viavel na loja
    private double area;
    private int numeroPorta;
    private boolean wc; //sim ou nao


    //Constructor for objects of class Loja
    /**
     * construtor vazio
     */
    public Loja() {
        // initialise instance variables
        super(2,"", "", 0, 0, ""); //super(id, rua, precoPedido, precoMinimo, estado)
        tipo = "";
        area = 0;
        numeroPorta = 0;
        wc = false;

    }
    /**
     * construtor parametrizado
     */
    public Loja(String id, String r, double pp, double pm, String e, String t, double at, int np, boolean w) {
        // initialise instance variables
        super(2,id, r, pp, pm, e); //super(id, rua, precoPedido, precoMinimo, estado)
        tipo = t;
        area = at;
        numeroPorta = np;
        wc = w;

    }
    /**
     * construtor copia
     */
    public Loja(Loja m) {
        // initialise instance variables
        super(2,m.getIdImovel(), m.getRua(), m.getPrecoPedido(), m.getPrecoMinimo(), m.getEstado()); //super(rua, precoPedido, precoMinimo)
        tipo = m.getTipo();
        area = m.getArea();
        numeroPorta = m.getNumPorta();
        wc = m.getWc();
  
    }

    //metodos de instancia
    //getters 
    public String getTipo() { return tipo; }

    public double getArea() { return area; }

    public int getNumPorta() { return numeroPorta; }

    public boolean getWc() { return wc; }
    
   

    //setters
    public void setTipo(String t) { tipo = t; }

    public void setArea(double at) { area = at; }

    public void setNumPorta(int np) { numeroPorta = np; }

    public void setWc(boolean w) { wc = w; }

   


    public Loja clone(){
        Loja a = new Loja(this);
        return a;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("idImovel: "); s.append(this.getIdImovel()+"\n");
        s.append("Rua: "); s.append(this.getRua()+"\n");
        s.append("Preço Pedido: "); s.append(this.getPrecoPedido()+"\n");
        s.append("Estado: "); s.append(this.getEstado()+"\n");
        s.append("Tipo: "); s.append(this.getTipo()+"\n");
        s.append("Area: "); s.append(this.area+"\n");
        s.append("Numero da Porta: "); s.append(this.numeroPorta+"\n");
        s.append("Wc: "); s.append(this.wc+"\n");

        return s.toString();
    }
    
    public boolean equals(Loja a){
        if(a != null) return (this.getIdImovel().equals(a.getIdImovel()) &&
                              this.getRua().equals(a.getRua()) &&
                              this.getPrecoPedido() == a.getPrecoPedido() &&
                              this.getPrecoMinimo() == a.getPrecoMinimo() &&
                              this.getEstado().equals(a.getEstado()) &&
                              this.getTipo().equals(a.getTipo()) &&
                              this.area == a.getArea() &&
                              this.numeroPorta == a.getNumPorta() &&
                              this.wc == a.getWc()
                              );
        else return false;
    }
   
}
