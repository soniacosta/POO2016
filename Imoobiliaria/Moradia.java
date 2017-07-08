
/**
 * Write a description of class Moradia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moradia extends Imovel implements Habitavel {
    // instance variables - replace the example below with your own
    //classe deste é 3 = moradia
    private String tipo; //isolada, geminada, banda, gaveto
    private double areaImplantacao;
    private double areaTotalCoberta;
    private double areaTerreno;
    private int quartos;
    private int wcs;
    private int numeroPorta;

    //Constructor for objects of class Moradia
    /**
     * construtor vazio
     */
    public Moradia() {
        // initialise instance variables
        super(3,"", "", 0, 0,""); //super(id, rua, precoPedido, precoMinimo,estado)
        tipo = "";
        areaImplantacao = 0;
        areaTotalCoberta = 0;
        areaTerreno = 0;
        quartos = 0;
        wcs = 0;
        numeroPorta = 0;
    }
    /**
     * construtor parametrizado
     */
    public Moradia(String id, String r, double pp, double pm, String e, String t, double ai, double atc, double at, int q, int w, int np) {
        // initialise instance variables
        super(3,id, r, pp, pm,e); //super(id, rua, precoPedido, precoMinimo)
        tipo = t;
        areaImplantacao = ai;
        areaTotalCoberta = atc;
        areaTerreno = at;
        quartos = q;
        wcs = w;
        numeroPorta = np;
    }
    /**
     * construtor copia
     */
    public Moradia(Moradia m) {
        // initialise instance variables
        super(3,m.getIdImovel(), m.getRua(), m.getPrecoPedido(), m.getPrecoMinimo(), m.getEstado()); //super(id, rua, precoPedido, precoMinimo)
        tipo = m.getTipo();
        areaImplantacao = m.getAreaImplantacao();
        areaTotalCoberta = m.getAreaTotalCoberta();
        areaTerreno = m.getAreaTerreno();
        quartos = m.getQuartos();
        wcs = m.getWcs();
        numeroPorta = m.getNumPorta();
    }

    //metodos de instancia
    //getters 
    public String getTipo() { return tipo; }

    public double getAreaImplantacao() { return areaImplantacao; }

    public double getAreaTotalCoberta() { return areaTotalCoberta; }

    public double getAreaTerreno() { return areaTerreno; }

    public int getQuartos() { return quartos; }

    public int getWcs() { return wcs; }

    public int getNumPorta() { return numeroPorta; }

    //setters
    public void setTipo(String t) { tipo = t; }

    public void setAreaImplantacao(double ai) { areaImplantacao = ai; }

    public void setAreaTotalCoberta(double atc) { areaTotalCoberta = atc; }

    public void setAreaTerreno(double at) { areaTerreno = at; }

    public void setQuartos(int q) { quartos = q; }

    public void setWcs(int w) { wcs = w; }

    public void setNumPorta(int np) { numeroPorta = np; }


    public Moradia clone(){
        Moradia a = new Moradia(this);
        return a;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("idImovel: "); s.append(this.getIdImovel()+"\t");        
        s.append("Estado: "); s.append(this.getEstado()+"\n");
        s.append("Rua: "); s.append(this.getRua()+"\n");
        s.append("Numero da Porta: "); s.append(this.numeroPorta+"\n");
        s.append("Preço Pedido: "); s.append(this.getPrecoPedido()+"\n");
        s.append("Tipo: "); s.append(this.tipo+"\n");
        s.append("Area Implantacao: "); s.append(this.areaImplantacao+"\n");
        s.append("Area Total Coberta: "); s.append(this.areaTotalCoberta+"\n");
        s.append("Area Terreno: "); s.append(this.areaTerreno+"\n");
        s.append("Quartos: "); s.append(this.quartos+"\n");
        s.append("Wcs: "); s.append(this.wcs+"\n");

        return s.toString();
    }
    
    public boolean equals(Moradia a){
        if(a != null) return (this.getIdImovel().equals(a.getIdImovel()) &&
                              this.getRua().equals(a.getRua()) &&
                              this.getPrecoPedido() == a.getPrecoPedido() &&
                              this.getPrecoMinimo() == a.getPrecoMinimo() &&
                              this.getEstado().equals(a.getIdImovel()) &&
                              this.getTipo().equals(a.getTipo()) &&
                              this.areaImplantacao == a.getAreaImplantacao() &&
                              this.areaTotalCoberta == a.getAreaTotalCoberta() &&
                              this.areaTerreno == a.getAreaTerreno() &&
                              this.quartos == a.getQuartos() &&
                              this.wcs == a.getWcs() &&
        					  this.numeroPorta == a.getNumPorta()) ;
        else return false;
    }

    public boolean getHabitavel(){
        return true;
    }
    
}
