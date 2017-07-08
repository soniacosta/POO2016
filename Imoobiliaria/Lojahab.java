
/**
 * Write a description of class lojahab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lojahab extends Apartamento implements Habitavel{
    // instance variables - replace the example below with your own
    //classe deste é 5 = lojaHab
    private String tipoLoja; //tipo de negocio viavel na loja
    private double area;
    private int numeroPorta;
    private boolean wc; //sim ou nao


    //Constructor for objects of class Loja
    /**
     * construtor vazio
     */
    public Lojahab() {
        // initialise instance variables
        super(5,"", "", 0, 0, "", "", 0, 0, 0, 0, 0, false); 
        tipoLoja = "";
        area = 0;
        numeroPorta = 0;
        wc = false;

    }
    /**
     * construtor parametrizado
     */
    public Lojahab(String id, String r, double pp, double pm, String e, String ti, double at, int q,int w, int np, int na, boolean g, String tl, double al,boolean wcs) {
        // initialise instance variables
        super(5,id, r, pp, pm, e, ti, at, q,w, np, na, g); //super(id, rua, precoPedido, precoMinimo, estado, resto)
        tipoLoja = tl;
        area = al;
        numeroPorta = np;
        wc = wcs;

    }
    /**
     * construtor copia
     */
    public Lojahab(Lojahab m) {
        // initialise instance variables
        super(5,m.getIdImovel(), m.getRua(), m.getPrecoPedido(), m.getPrecoMinimo(), m.getEstado(), m.getTipo(), m.getArea(), m.getQuartos(), m.getWcs(), m.getNumPorta(), m.getNumAndar(), m.getGaragem()); //super(rua, precoPedido, precoMinimo)
        tipoLoja = m.getTipo();                                                                                                                                           
        area = m.getArea();
        numeroPorta = m.getNumPorta();
        wc = m.getWc();

    }

    //metodos de instancia
    //getters 
    public String getTipoLoja() { return tipoLoja; }

    public double getArea() { return area; }

    public int getNumPorta() { return numeroPorta; }

    public boolean getWc() { return wc; }
    


    //setters
    public void setTipoLoja(String t) { tipoLoja = t; }

    public void setArea(double at) { area = at; }

    public void setNumPorta(int np) { numeroPorta = np; }

    public void setWc(boolean w) { wc = w; }

    public Lojahab clone(){
        Lojahab a = new Lojahab(this);
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
    
    public boolean equals(Lojahab a){
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


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean getHabitavel(){
        return true;
    }
}
