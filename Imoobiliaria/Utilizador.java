import java.lang.Object;
/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilizador {
    
    private int tipo; //se é vendedor ou comprador comprador= 1 , vendedor=2
    private String email;
    private String nome;
    private String password;
    private String dataNascimento;
    private String morada;

    
    // Constructor for objects of class Utilizador
    /**
    * Construtor vazio
    */
    public Utilizador() {
        // initialise instance variables
        tipo = 0;
        email = "";
        nome = "";
        password = "";
        dataNascimento = "";
        morada = "";
    }
    /**
    * construtor parametrizado
    *
    * @param e email que identifica o utilizador
    * @param n nome 
    * @param p password
    * @param d data de Nascimento
    * @param m morada
    */
    public Utilizador(int t, String e, String n, String p, String d, String m) {
        // initialise instance variables
        tipo = t;
        email = e;
        nome = n;
        password = p;
        dataNascimento = d;
        morada = m;
    }

    /** 
     * Construtor de cópia.
     * 
     * @param a utilizador a ser copiado
     */
    public Utilizador(Utilizador a) {
        this(a.getTipo(), a.getEmail(), a.getNome(), a.getPassword(), a.getDataNasc(), a.getMorada());
    }

    //metodos de instancia
    //getters 
    public int getTipo() { return tipo; }

    public String getEmail() { return email; }

    public String getNome() { return nome; }

    public String getPassword() { return password; }

    public String getDataNasc() { return dataNascimento; } 

    public String getMorada() { return morada; } 

    //setters
    public void setTipo(int t) { tipo = t;}

    public void setEmail(String e) { email = e; }

    public void setNome(String n) { nome = n; }

    public void setPassword(String p) { password = p; }

    public void setDataNasc(String d) { dataNascimento = d; }

    public void setMorada(String m) { morada = m; }

    public Utilizador clone(){
        Utilizador a = new Utilizador(this);
        return a;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("Email: "); s.append(this.email+"\n");
        s.append("nome: "); s.append(this.nome+"\n");
        //A PASSWORD APARECE NO TOSTRING???
        s.append("Data de Nascimento: "); s.append(this.dataNascimento+"\n");
        s.append("morada: "); s.append(this.morada+"\n");
        return s.toString();
    }
    
    public boolean equals(Utilizador a){
        if(a != null) return (this.tipo==a.getTipo() &&
                              this.email.equals(a.getEmail()) &&
                              this.nome.equals(a.getNome()) &&
                              this.password.equals(a.getPassword()) &&
                              this.dataNascimento.equals(a.getDataNasc()) &&
                              this.morada.equals(a.getMorada()) );
        else return false;
    }

    //metodos
}
