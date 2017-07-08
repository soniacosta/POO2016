/**
 * Write a description of class Apartamento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apartamento extends Imovel implements Habitavel{
    // instance variables - replace the example below with your own
    //classe deste é 1 = apartamento
    private String tipo; //simples, duplex, triplex
    private double areaTotal;
    private int quartos;
    private int wcs;
    private int numeroPorta;
    private int numeroAndar;
    private boolean garagem; //sim ou nao

    //Constructor for objects of class Apartamento
    /**
     * construtor vazio
     */
    public Apartamento() {
        // initialise instance variables
        super(1,"", "", 0, 0, ""); //super(id, rua, precoPedido, precoMinimo, estado)
        tipo = "";
        areaTotal = 0;
        quartos = 0;
        wcs = 0;
        numeroPorta = 0;
        numeroAndar = 0;
        garagem = false;
    }
    /**
     * construtor parametrizado
     */
    public Apartamento(String id, String r, double pp, double pm,String e, String t, double at, int q, int w, int np, int na, Boolean g) {
        // initialise instance variables
        super(1,id, r, pp, pm, e); //super(rua, precoPedido, precoMinimo)
        tipo = t;
        areaTotal = at;
        quartos = q;
        wcs = w;
        numeroPorta = np;
        numeroAndar = na;
        garagem = g;
    }

    public Apartamento(int cl, String id, String r, double pp, double pm,String e, String t, double at, int q, int w, int np, int na, Boolean g) {
        // initialise instance variables
        super(cl,id, r, pp, pm, e); //super(rua, precoPedido, precoMinimo)
        tipo = t;
        areaTotal = at;
        quartos = q;
        wcs = w;
        numeroPorta = np;
        numeroAndar = na;
        garagem = g;
    }
    /**
     * construtor copia
     */
    
    public Apartamento(Apartamento m) {
        // initialise instance variables
            super(1,m.getIdImovel(), m.getRua(), m.getPrecoPedido(), m.getPrecoMinimo(), m.getEstado()); //super(rua, precoPedido, precoMinimo)
            tipo = m.getTipo();
            areaTotal = m.getAreaTotal();
            quartos = m.getQuartos();
            wcs = m.getWcs();
            numeroPorta = m.getNumPorta();
            numeroAndar = m.getNumAndar();
            garagem = m.getGaragem();
    }

    // metodos de instancia
    // getters 
    public String getTipo() { return tipo; }

    public double getAreaTotal() { return areaTotal; }

    public int getQuartos() { return quartos; }

    public int getWcs() { return wcs; }

    public int getNumPorta() { return numeroPorta; }

    public int getNumAndar() { return numeroAndar; }

    public boolean getGaragem() { return garagem; }

    //setters
    public void setTipo(String t) { tipo = t; }

    public void setAreaTotal(double at) { areaTotal = at; }

    public void setQuartos(int q) { quartos = q; }

    public void setWcs(int w) { wcs = w; }

    public void setNumPorta(int np) { numeroPorta = np; }

    public void setNumAndar(int na) { numeroAndar = na; }

    public void setGaragem(Boolean g) { garagem = g; }


    public Apartamento clone(){
        Apartamento a = new Apartamento(this);
        return a;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("idImovel: "); s.append(this.getIdImovel()+"\n");
        s.append("Rua: "); s.append(this.getRua()+"\n");
        s.append("Preço Pedido: "); s.append(this.getPrecoPedido()+"\n");
        s.append("Estado: "); s.append(this.getEstado()+"\n");
        s.append("Tipo: "); s.append(this.tipo+"\n");
        s.append("Area Total: "); s.append(this.areaTotal+"\n");
        s.append("Quartos: "); s.append(this.quartos+"\n");
        s.append("Wcs: "); s.append(this.wcs+"\n");
        s.append("Numero da Porta: "); s.append(this.numeroPorta+"\n");
        s.append("Numero do Andar: "); s.append(this.numeroAndar+"\n");
        s.append("Garagem: "); s.append(this.garagem+"\n");
        return s.toString();
    }
    
    public boolean equals(Apartamento a){
        if(a != null) return (this.getIdImovel().equals(a.getIdImovel()) &&
                              this.getRua().equals(a.getRua()) &&
                              this.getPrecoPedido() == a.getPrecoPedido() &&
                              this.getPrecoMinimo() == a.getPrecoMinimo() &&
                              this.getEstado().equals(a.getEstado()) &&
                              this.getTipo().equals(a.getTipo()) &&
                              this.areaTotal == a.getAreaTotal() &&
                              this.quartos == a.getQuartos() &&
                              this.wcs == a.getWcs() &&
                              this.numeroPorta == a.getNumPorta() &&
                              this.numeroAndar == a.getNumAndar() &&
                              this.garagem == a.getGaragem() 
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
