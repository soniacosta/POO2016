
/**
 * Write a description of class Terreno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terreno extends Imovel {
    // instance variables - replace the example below with your own
    //classe deste é 4 = terreno
    private String tipo; //construcao de habitaçao ou construcao de armazens
    private double areaConstrucao;
    private double diamCanalizacao; //em mm
    private double kWhMaxSuportado; //kWh maximo suportado pela rede eletrica
    private boolean acessoEsgotos; //se existe acesso à rede de esgotos

    //Constructor for objects of class Terreno
    /**
     *  construtor vazio
     */
    public Terreno(){
        // initialise instance variables
        super(4,"", "", 0, 0,""); //super(id, rua, precoPedido, precoMinimo,estado)
        tipo = "";
        areaConstrucao = 0;
        diamCanalizacao = 0;
        kWhMaxSuportado = 0;
        acessoEsgotos = false;
    }
    /**
     *  construtor parametrizado
     */
    public Terreno(String id, String r, double pp, double pm, String e, String t, double areaC, double diamC, double kwh, boolean ae) {
        // initialise instance variables
        super(4,id, r, pp, pm,e); //super(rua, precoPedido, precoMinimo,estado)
        tipo = t;
        areaConstrucao = areaC;
        diamCanalizacao = diamC;
        kWhMaxSuportado = kwh;
        acessoEsgotos = ae;
    }

    /**
     * construtor copia
     */

    public Terreno (Terreno t){
        // initialise instance variables
        super(4,t.getIdImovel(), t.getRua(), t.getPrecoPedido(), t.getPrecoMinimo(), t.getEstado());
        tipo = t.getTipo();
        areaConstrucao = t.getAreaConstrucao();
        diamCanalizacao = t.getDiamCanalizacao();
        kWhMaxSuportado = t.getKWhMaxSuportado();
        acessoEsgotos = t.getAcessoEsgotos(); 
    }

    // metodos de instancia
    // getters 
    public String getTipo() { return tipo; }

    public double getAreaConstrucao() { return areaConstrucao; }

    public double getDiamCanalizacao() { return diamCanalizacao; }

    public double getKWhMaxSuportado() { return kWhMaxSuportado; }

    public boolean getAcessoEsgotos() { return acessoEsgotos; }

    //setters
    public void setTipo(String t) { tipo = t; }

    public void setAreaConstrucao(double ac) { areaConstrucao = ac; }

    public void setDiamCanalizacao(double diamC) { diamCanalizacao = diamC; }

    public void setKWhMaxSuportado(double kwh) { kWhMaxSuportado = kwh; }

    public void setAcessoEsgotos(boolean ae) { acessoEsgotos = ae; }


    public Terreno clone(){
        Terreno t = new Terreno(this);
        return t;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("idImovel: "); s.append(this.getIdImovel()+"\n");
        s.append("Rua: "); s.append(this.getRua()+"\n");
        s.append("Preço Pedido: "); s.append(this.getPrecoPedido()+"\n");
        s.append("Estado: "); s.append(this.getEstado()+"\n");
        s.append("Tipo: "); s.append(this.tipo+"\n");
        s.append("Area disponível para construção: "); s.append(this.areaConstrucao+"\n");
        s.append("Diâmetro das canalizações (em mm): "); s.append(this.acessoEsgotos+"\n");
        s.append("kWH máximo suportado pela rede elétrica: "); s.append(this.acessoEsgotos+"\n");
        s.append("Acesso à rede de esgotos: "); s.append(this.acessoEsgotos+"\n");
        return s.toString();
    }

    public boolean equals(Terreno a){
        if(a != null) return (this.getIdImovel().equals(a.getIdImovel()) &&
                              this.getRua().equals(a.getRua()) &&
                              this.getPrecoPedido() == a.getPrecoPedido() &&
                              this.getPrecoMinimo() == a.getPrecoMinimo() &&
                              this.getTipo().equals(a.getTipo()) &&
                              this.areaConstrucao == a.getAreaConstrucao() &&
                              this.diamCanalizacao == a.getDiamCanalizacao() &&
                              this.kWhMaxSuportado == a.getKWhMaxSuportado() &&
                              this.acessoEsgotos == a.getAcessoEsgotos()
                              );
        else return false;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return  y;
    }
}
