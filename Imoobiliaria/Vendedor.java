import java.util.*;
/**
 * Write a description of class Vendedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vendedor extends Utilizador{ //tipo = 2 vendedor
    
    public ArrayList<String> portfolio; //portfolio com imoveis para venda
    public HashMap<String,Imovel> historico; //hashmap<idImovel,Imovel> historico

    /**
     * Constructor for objects of class Vendedor
     */
    public Vendedor() {
        // initialise instance variables
        super(2,"","","","",""); //super(tipo, email, nome, password, dataNascimento, morada)
        portfolio = new ArrayList<String>();
        historico = new HashMap<String,Imovel>();
    }
    /**
     *  construtor parametrizado
     */
    public Vendedor(String e, String n, String p, String d, String m, ArrayList<String> port, HashMap<String,Imovel> h) {
        // initialise instance variables
        super(2,e,n,p,d,m); //  tem todas as ceninhas iguais ao comprador mais as especificas do vendedor
        portfolio = port;
        historico = h;
    }

    /**
     * construtor parametrizado novo utilizador
     */
    public Vendedor(String e, String n, String p, String d, String m) {
        // initialise instance variables
        super(2,e,n,p,d,m); //  tem todas as ceninhas iguais ao comprador mais as especificas do vendedor
        portfolio = new ArrayList<String>();
        historico = new HashMap<String, Imovel>();
    }
    /**
     *  construtor copia
     */
    public Vendedor(Vendedor v) {
        // initialise instance variables
        super(2,v.getEmail(),v.getNome(),v.getPassword(),v.getDataNasc(),v.getMorada()); //super(email, nome, password, dataNascimento, morada)
        portfolio = v.getPortfolio();
        historico = v.getHistorico();
    }

    public ArrayList<String> getPortfolio(){
        ArrayList<String> p = new ArrayList<String>();
    
        for(String u:portfolio) p.add(u);
        return p;
    }

    public HashMap<String,Imovel> getHistorico() { 
        HashMap<String,Imovel> aux= new HashMap<String,Imovel>();
        
        for(String s : historico.keySet()) {
            aux.put(s,historico.get(s).clone());
        }
        return aux;
    }

    public Vendedor clone() {
        Vendedor v = new Vendedor (this);
        return v;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Email: "); s.append(this.getEmail()+"\n");
        s.append("nome: "); s.append(this.getNome()+"\n");
        s.append("Data de Nascimento: "); s.append(this.getDataNasc()+"\n");
        s.append("morada: "); s.append(this.getMorada()+"\n");
        return s.toString();
    }

    public boolean equals(Vendedor a){
        if(a != null) return (this.getEmail().equals(a.getEmail()) &&
                              this.getNome().equals(a.getNome()) &&
                              this.getPassword().equals(a.getPassword()) &&
                              this.getDataNasc().equals(a.getDataNasc()) &&
                              this.getMorada().equals(a.getMorada())
                              // && this.favoritos.equals(a.getFavoritos())
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
