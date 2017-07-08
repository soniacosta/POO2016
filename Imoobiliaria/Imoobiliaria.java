import java.util.*;
import java.io.*;

/**
 * Write a description of class ImOObiliaria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Imoobiliaria {
    // instance variables - tirar daqui os static...
    public static HashMap<String, Imovel> imoveis; //idImovel , Imovel
    public static HashMap<String, Utilizador> utilizadores; //email , Utilizador
    public static ArrayList<Consulta> consultas;
    public static int contador;

    //construtores
    /**
     * Construtor vazio
     */
    public Imoobiliaria() {
        // initialise instance variables
        imoveis = new HashMap<String, Imovel>();
        contador = 0;
        utilizadores = new HashMap<String, Utilizador>();
        consultas = new ArrayList<Consulta>();
    }

    /**
     * Construtor parametrizado
     */
    public Imoobiliaria(HashMap<String,Imovel> im, HashMap<String,Utilizador> us, ArrayList<Consulta> cons, int cont) {

        imoveis = new HashMap<String,Imovel>();
        for (Imovel i: im.values())
            this.imoveis.put(i.getIdImovel(), i.clone());

        utilizadores = new HashMap<String,Utilizador>();
        for (Utilizador u: us.values())
            this.utilizadores.put(u.getEmail(), u.clone());
        
        consultas = new ArrayList<Consulta>();
        for (Consulta c: cons) consultas.add(c);

        contador = cont;
    }

    /**
     * Construtor de copia
     */
    public Imoobiliaria(Imoobiliaria i) {
        imoveis = i.getImoveis();
        utilizadores = i.getUtilizadores();
        contador = i.getContador();
    }
    
    public HashMap<String,Utilizador> getUtilizadores() { 
        HashMap<String,Utilizador> aux= new HashMap<String,Utilizador>();
        
        for(String s : utilizadores.keySet()) {
            aux.put(s,utilizadores.get(s).clone());
        }
        return aux;
    }

    public HashMap<String,Imovel> getImoveis() { 
        HashMap<String,Imovel> aux= new HashMap<String,Imovel>();
        
        for(String s : imoveis.keySet()) {
            aux.put(s,imoveis.get(s).clone());
        }
        return aux;
    }

    public int getContador(){ return contador; }

    public void setContador(int i) {this.contador = i;}
    /**
     * /---------------- metodos ---------------------/  
     * 
     */
     
    /**
     * Aplicação deverá estar pré-populada com conjunto de dados significativos,
     * que permita testar toda a aplicação no dia da entrega.
     * 
     */
    public static Imoobiliaria initApp() { 
        Imoobiliaria imo = new Imoobiliaria();
        //criar imoveis e pessoas
        ArrayList<String> texto = new ArrayList<String>();
        try{
            FileInputStream fis = new FileInputStream("estado.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linha = br.readLine();
            while(linha != null){
                texto.add(linha);
                linha = br.readLine();
            }
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao ler o ficheiro: "+e);
        }  
        
        for (String x : texto) {
            Integer i = 0;
            if(imo.getImoveis().isEmpty()){
                i = 1;
            }else{
                i = imo.getImoveis().size() + 1;
            }
            String[] tokens = x.split(">");
            if(tokens.length == 2){
                String[] var = tokens[1].split(",");
                if(tokens[0].equals("Moradia")){
                    if(var.length == 13){ 
                        String id = var[0];
                        String r = var[1];
                        double pp = Double.parseDouble(var[2]);
                        double pm = Double.parseDouble(var[3]);
                        String e = var[4];
                        String t = var[5];
                        double ai = Double.parseDouble(var[6]);
                        double atc = Double.parseDouble(var[7]);
                        double at = Double.parseDouble(var[8]);
                        int q = Integer.parseInt(var[9]);
                        int w = Integer.parseInt(var[10]);
                        int np = Integer.parseInt(var[11]);
                        String idV = var[12];
                        try{
                            Moradia m = new Moradia(id, r, pp, pm, e, t, ai, atc, at, q, w, np);
                            imo.registaImovel(m);
                            Vendedor u = (Vendedor)imo.getUtilizadores().get(idV);
                            u.portfolio.add(id);
                            //System.out.println(m.toString()); Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar Moradia: "+ex);
                        }
                    }
                }else if (tokens[0].equals("Terreno")) {
                    if(var.length == 11){
                        String id = var[0];
                        String r = var[1];
                        double pp = Double.parseDouble(var[2]);
                        double pm = Double.parseDouble(var[3]);
                        String e = var[4];
                        String t = var[5];
                        double areaC = Double.parseDouble(var[6]);
                        double diamC = Double.parseDouble(var[7]);
                        double kwh = Double.parseDouble(var[8]);
                        boolean ae = Boolean.parseBoolean(var[9]);
                        String idV = var[10];
                        try{
                            Terreno terr = new Terreno(id, r, pp, pm, e, t,areaC, diamC, kwh, ae) ;
                            imo.registaImovel(terr);
                            Vendedor u = (Vendedor)imo.getUtilizadores().get(idV);
                            u.portfolio.add(id);
                            //System.out.println(terr.toString());Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar Terreno: "+ex);
                        }
                    }
                }else if (tokens[0].equals("Loja")) {
                    if(var.length == 11){
                        String id = var[0];
                        String r = var[1];
                        double pp = Double.parseDouble(var[2]);
                        double pm = Double.parseDouble(var[3]);
                        String e = var[4];
                        String t = var[5];
                        double at = Double.parseDouble(var[6]);
                        int np = Integer.parseInt(var[7]);
                        boolean w = Boolean.parseBoolean(var[8]);
                        String idV = var[10];
                        try{
                            Loja l = new Loja(id, r, pp, pm, e, t, at, np, w);
                            imo.registaImovel(l);
                            Vendedor u = (Vendedor)imo.getUtilizadores().get(idV);
                            u.portfolio.add(id);
                            //System.out.println(l.toString());Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar Loja: "+ex);
                        }
                       
                    }
                }else if (tokens[0].equals("Apartamento")) {
                    if(var.length == 13){
                        String id = var[0];
                        String r = var[1];
                        double pp = Double.parseDouble(var[2]);
                        double pm = Double.parseDouble(var[3]);
                        String e = var[4];
                        String t = var[5];
                        double at = Double.parseDouble(var[6]);
                        int q = Integer.parseInt(var[7]);
                        int w = Integer.parseInt(var[8]);
                        int np = Integer.parseInt(var[9]);
                        int na = Integer.parseInt(var[10]);
                        boolean g = Boolean.parseBoolean(var[11]);
                        String idV = var[12];
                        try{
                            Apartamento apart = new Apartamento(id, r, pp, pm, e, t, at, q, w, np, na, g);
                            imo.registaImovel(apart);
                            Vendedor u = (Vendedor)imo.getUtilizadores().get(idV);
                            u.portfolio.add(id);
                            //System.out.println(apart.toString());Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar Apartamento: "+ex);
                        }

                    }
                }else if(tokens[0].equals("LojaHabitavel")) {
                    if(var.length == 15){
                        String id = var[0];
                        String r = var[1];
                        double pp = Double.parseDouble(var[2]);
                        double pm = Double.parseDouble(var[3]);
                        String e = var[4];
                        String ti = var[5]; //tipo de apartamento
                        double at = Double.parseDouble(var[6]);
                        int q = Integer.parseInt(var[7]);
                        int w = Integer.parseInt(var[8]);
                        int np = Integer.parseInt(var[9]);
                        int na = Integer.parseInt(var[10]);
                        boolean g = Boolean.parseBoolean(var[11]);
                        String tl = var[12]; //tipo de loja
                        double al = Double.parseDouble(var[13]);
                        boolean wcs = Boolean.parseBoolean(var[14]);
                        String idV = var[12];
                        try{
                            Lojahab lojahab = new Lojahab( id, r, pp, pm, e, ti, at, q, w, np, na, g, tl, al, wcs);
                            imo.registaImovel(lojahab);
                            Vendedor u = (Vendedor)imo.getUtilizadores().get(idV);
                            u.portfolio.add(id);
                            //System.out.println(lojahab.toString());Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar LojaHabitavel"+ex);
                        }

                    }
                }else if (tokens[0].equals("Comprador")) {
                    if(var.length == 5){
                        String e = var[0];
                        String n = var[1];
                        String p = var[2];
                        String d = var[3];
                        String m = var[4];
                        ArrayList<String> f = new ArrayList<String>();
                        Comprador c = new Comprador(e, n, p, d, m, f);
                        try{
                            imo.utilizadores.put(e, c);
                            //System.out.println(c.toString());Input.lerString();
                        }catch(Exception ex){
                            System.out.println("Nao foi possivel adicionar Comprador: "+ex);
                        }
                    }        
                }else if (tokens[0].equals("Vendedor")) {
                    if(var.length == 5){
                        String e = var[0];
                        String n = var[1];
                        String p = var[2];
                        String d = var[3];
                        String m = var[4];
                        ArrayList<String> port = new ArrayList<String>();
                        HashMap<String, Imovel> h = new HashMap<String, Imovel>();
                        Vendedor v = new Vendedor(e, n, p, d, m, port, h);
                        try{
                            imo.utilizadores.put(e, v);
                            //System.out.println(v.toString());Input.lerString();
                        }catch(Exception ex){
                            System.out.println(""+ex);
                        }
                    }
                }else if (tokens[0].equals("Addf")) {
                    if(var.length == 2){
                        String idC = var[0];
                        String idIm = var[1];
                        try{
                            Comprador u = (Comprador)imo.utilizadores.get(idC);
                            u.favoritos.add(idIm);
                        }catch(Exception e){System.out.println("Impossivel adicionar favorito "+e);}
                    }
                }
            }
        }   

        return imo;
    }
    /**
    * Registar um utilizador, quer vendedor, quer comprador
    *
    */
    public void registarUtilizador (Utilizador utilizador) throws UtilizadorExistenteException {
        if(!utilizadores.containsKey(utilizador.getEmail())){
                utilizadores.put(utilizador.getEmail(),utilizador);
                //System.out.println("funcionou, registou!");
        }else {
            throw new UtilizadorExistenteException("Este utilizador ("+utilizador.getEmail()+") já existe.");
        }
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
    /**
    * validar o acesso à aplicação utilizando as credenciais (email e password)
    *
    */
    public void iniciaSessao (String email, String password)  throws SemAutorizacaoException {
 
        Utilizador user = utilizadores.get(email);
        if(!user.getPassword().equals(password)){
            throw new SemAutorizacaoException("");
        }            
    }


    public void fechaSessao(){ ;
    }

    /**
    * todos os utilizadores
    */
    /**
    * consultar a lista de todos os imoveis de um dado tipo (Terreno, Moradia, ...)
    * até um certo preço
    *
    */
    public ArrayList<Imovel> getImovel (String cl, int preco){
           double p = (double)preco;
           ArrayList<Imovel> listImoveis = new ArrayList<Imovel>();
           int i = 0;
           if(cl.equals("Moradia") || cl.equals("moradia")){ i=3; }
           else if(cl.equals("Apartamento") || cl.equals("apartamento")){ i=1; }
                else if(cl.equals("Loja") || cl.equals("loja")){ i=1; }
                    else if(cl.equals("Terreno") || cl.equals("terreno")){ i = 4; }
                        else{ i= 5; }
            for(String s : imoveis.keySet()) {
                if((imoveis.get(s).getClasse() == i) && (imoveis.get(s).getPrecoPedido() <= preco)) {
                    listImoveis.add(imoveis.get(s).clone());
                };
            }
           return listImoveis;
    }

    /**
    * consultar a lista de todos os imoveis habitaveis
    * a definiçao de habitavel sera fornecida atempadamente
    *
    */
    public ArrayList<Habitavel> getHabitaveis(int preco){
        ArrayList<Habitavel> listHab = new ArrayList<Habitavel>();
        double p = (double) preco;
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia){
                Moradia a = (Moradia) i; 
                if(p>=a.getPrecoPedido()){
                    listHab.add(a);
                }
            }else if(i instanceof Apartamento){
                        Apartamento a = (Apartamento) i;
                        if(p>=a.getPrecoPedido()){
                            listHab.add(a);
                        }
                  } else if(i instanceof Lojahab){
                            Lojahab a = (Lojahab) i; 
                            if(p>=a.getPrecoPedido()){
                                listHab.add(a);
                            }
                         } 
        }
        
        return listHab;
    }

    /**
    * obter um mapeamento entre todos os imoveis e respectivos vendedores
    *
    */
    public HashMap<Imovel, Vendedor> getMapeamentoImoveis(){
        HashMap m = new HashMap<Imovel,Vendedor>();
        Vendedor vAux = new Vendedor();
        for (Utilizador u : utilizadores.values()) {
            if(u instanceof Vendedor){
                vAux = (Vendedor) u;
                for (String s : vAux.portfolio) {
                    m.put(this.imoveis.get(s).clone(),vAux.clone());
                }

            }
            
        }
        return m;
    }

    /**
    * venderdores only (é necessario estarem previamente autenticados)
    */
    /**
    * colocar um imovel à venda
    *
    */
    public static void registaImovel (Imovel im) throws ImovelExisteException {
        if(imoveis.containsKey(im.getIdImovel())) {
            throw new ImovelExisteException("Este imóvel já existe");
        }
        else {
            imoveis.put(im.getIdImovel(), im);
            contador++;
        }
    }

    /**
    * visualizar uma lista com as datas (e emails, caso exista essa informaçao) 
    * das 10 ultimas consultas aos imoveis que tem para venda
    *
    */
    public ArrayList<Consulta> getConsultas() {
        int i = 0;
        ArrayList<Consulta> lc = new ArrayList<Consulta>();
        int tamanho = consultas.size()+1;
        while(i!=tamanho && i!=10){
            lc.add(this.consultas.get(i));i++;
        }
        return lc;
    }

    /**
    * alterar o estado de um imovel, de acordo com as acoes feitas sobre ele
    *
    */
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException , EstadoInvalidoException {
        if(!imoveis.containsKey(idImovel)) {
            throw new ImovelInexistenteException("Este imóvel não existe");
        }
        else if(estado.equals("Vendido")){
            imoveis.get(idImovel).setEstado(estado); 
             }
             else if(estado.equals("Reservado")){
                imoveis.get(idImovel).setEstado(estado);
             }            
        
    }
    /*
    /**
    * obter um conjunto com os codigos dos imoveis mais consultados
    * (ou seja, com mais de N consultas)
    *
    */
   /* public Set<String> getTopImoveis(int n) {}*/

    /**
    * compradores registados 
    */
    /**
    * marcar um imovel como favorito
    *
    */
   /* public void setFavorito(String idImovel) throws ImovelInexistenteException {
        if(imoveis.containsKey(idImovel)){;}
        else{ throw new ImovelInexistenteException(System.out.println("Imovel Inexistente"));}
        
    }*/
    /**
    * consultar imoveis favoritos ordenados por preço
    *
    */
    public /*TreeSet<Imovel>*/void getFavoritos() throws SemAutorizacaoException {

    }

    public void adConsulta(Consulta c){
        consultas.add(0,c);
    }
}
