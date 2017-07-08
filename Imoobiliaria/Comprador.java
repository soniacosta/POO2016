import java.util.*;

/**
 * Write a description of class Comprador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comprador extends Utilizador {//tipo = 1 comprador
    
    public ArrayList<String> favoritos; //lista de idImovel 

    // Constructor for objects of class Comprador
    /**
     * 	construtor vazio
     */
    public Comprador() {
        // initialise instance variables
        super(1,"","","","",""); //super(email, nome, password, dataNascimento, morada)
        favoritos = new ArrayList<String>();
    }

    /**
     *  construtor parametrizado
     */
    public Comprador(String e, String n, String p, String d, String m, ArrayList<String> f) {
    	// initialise instance variables
        super(1,e,n,p,d,m);
        favoritos = f;
    }
    /**
     * construtor parametrizado novo utilizador
     */
    public Comprador(String e, String n, String p, String d, String m) {
      // initialise instance variables
        super(1,e,n,p,d,m);
        favoritos = new ArrayList<String>();
    }

    /**
     * 	construtor copia
     */
    public Comprador(Comprador c) {
        // initialise instance variables
        super(1,c.getEmail(),c.getNome(),c.getPassword(),c.getDataNasc(),c.getMorada()); //super(email, nome, password, dataNascimento, morada)
        favoritos = c.getFavorit();
    }

    public ArrayList<String> getFavorit(){
        ArrayList<String> f = new ArrayList<String>();
    
        for(String u:favoritos) f.add(u);
        return f;
    }

    public Comprador clone() {
    	Comprador c = new Comprador(this);
    	return c;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Email: "); s.append(this.getEmail()+"\n");
        s.append("nome: "); s.append(this.getNome()+"\n");
        s.append("Data de Nascimento: "); s.append(this.getDataNasc()+"\n");
        s.append("morada: "); s.append(this.getMorada()+"\n");
        return s.toString();
    }

    public boolean equals(Comprador a){
        if(a != null) return (this.getEmail().equals(a.getEmail()) &&
                              this.getNome().equals(a.getNome()) &&
                              this.getPassword().equals(a.getPassword()) &&
                              this.getDataNasc().equals(a.getDataNasc()) &&
                              this.getMorada().equals(a.getMorada())
                              // && this.favoritos.equals(a.getFavoritos())
                              );
        else return false;
    }

}
