import java.util.*;
import java.text.*;
import java.lang.String;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App {

   
    private static Imoobiliaria remoox;

    private App() {}

    //abrir app
    public static void main(){
        limpaEcra();
        System.out.println("\t|-------------------------|\n");
        System.out.println("\t|    Bemvindo à Remoox,   |\n");
        System.out.println("\t|  A nossa Imoobiliária!  |\n");
        System.out.println("\t|-------------------------|\n");
        Input.lerString();
        carregarDados();
        menu1();
    }

    private static void carregarDados() {
        System.out.println("A iniciar carregamento de dados!");
        try {
            remoox = Imoobiliaria.initApp();
        }
        catch (Exception e) {
            remoox = new Imoobiliaria();
            System.out.println("Não foi possivel ler os dados!\n");
        } 
        System.out.println("Dados carregados.");
    }

    private static void menu1(){
        int opcao = 0, sair = 0;
        Utilizador def = new Utilizador();
        /*menu inicial*/
        do {
          //limpaEcra();
            System.out.println("\t|\n");
            System.out.println("\t|  1-Registar Utilizador. \n");
            System.out.println("\t|  2-Iniciar Sessão. \n");
            System.out.println("\t|  3-Consultar imóveis de um tipo até um preço. \n");
            System.out.println("\t|  4-Consultar imóveis habitáveis. \n");
            System.out.println("\t|  5-Obter Mapeamento de vendedores e imóveis. \n");
            System.out.println("\t|  0-Sair. \n");
            System.out.println("\t|\n");
            opcao = Input.lerInt();
            
            switch(opcao){
                case 1 :
                     limpaEcra();
                     System.out.println("\tRegistar Utilizador.\n");
                     try {
                        remoox.registarUtilizador(criarUtilizador());
                     }catch(Exception e){
                        System.out.println("impossivel criar utilizador"+e);
                     } 
                     //limpaEcra();
                     break;
                    
                case 2 :
                     limpaEcra();
                     System.out.println("\tIniciar Sessão.\n");
                     def = login();
                     if(def.getTipo()!=0){
                        menuReg(def);
                     }else {System.out.println("não conseguiu iniciar sessão");}
                     def = new Utilizador();
                     break;

                case 3 :
                     limpaEcra();
                     System.out.println("Consultar imóveis de um tipo até um preço");
                     consultarTipo(def);
                     break; 

                case 4 :
                     limpaEcra();
                     System.out.println("Consultar imóveis habitáveis");
                     consultarHabitaveis(def);
                     break; 

                case 5 :
                     limpaEcra();
                     System.out.println("Obter Mapeamento de vendedores e imóveis");
                     obterMapeamento();
                     break;

                case 0 :
                     sair=1;
                     System.exit(0);
                     break;
                    
                default :
                     System.out.println("\topção inválida.\n\n\n"); 
            }
            
            opcao=10;
        } while(sair==0);
    }

    public static void menuReg(Utilizador u){
        int opcao = 0, sair = 0;
        limpaEcra();
        
        /*menu vendedor*/
        do {
            opcao = 0;
            System.out.println("\t|\n");
            System.out.println("\t|  1-Consultar imóveis de um tipo até um preço. \n");
            System.out.println("\t|  2-Consultar imóveis habitáveis. \n");
            System.out.println("\t|  3-Obter Mapeamento de vendedores e imóveis. \n");
            System.out.println("\t|  --- Vendedores apenas ---\n");
            System.out.println("\t|  4-Registar Imóvel. \n");
            System.out.println("\t|  5-Visualizar 10 últimas consultas.\n");
            System.out.println("\t|  6-Alterar estado de um imóvel. \n");
            System.out.println("\t|  7-Consultar imóveis mais consultados.\n");
            System.out.println("\t|  --- Comprador apenas ---\n");
            System.out.println("\t|  8-Marcar imóvel como favorito. \n");
            System.out.println("\t|  9-Consultar imóveis favoritos.\n");
            System.out.println("\t|  0-Fechar Sessão. \n");
            System.out.println("\t|\n");
            opcao = Input.lerInt();
            
            switch(opcao){
                case 1 :
                     limpaEcra();
                     System.out.println("\tConsultar imóveis de um tipo até um preço\n");
                     consultarTipo(u);
                     limpaEcra();
                     break;
                    
                case 2 :
                     limpaEcra();
                     System.out.println("\tConsultar imóveis habitáveis\n");
                     consultarHabitaveis(u);
                     break;

                case 3 :
                     limpaEcra();
                     System.out.println("\tObter Mapeamento de vendedores e imóveis\n");
                     obterMapeamento();
                     break; 

                case 4 :
                     limpaEcra();
                     System.out.println("\tRegistar Imóvel\n");
                     try{
                        inserirImovel(u);
                     }catch(Exception e){;}
                     
                     break; 

                case 5 :
                     limpaEcra();
                     System.out.println("\tVisualizar 10 últimas consultas\n");
                     try{
                        verConsultas(u);
                     }catch(Exception e){System.out.println("Falha ao efetuar operação.");}
                     break;

                case 6 :
                     limpaEcra();
                     System.out.println("\tAlterar estado\n");
                     try{
                        alterarEstado(u);
                     }catch(Exception e){;}
                     break;

                case 7 :
                     limpaEcra();
                     System.out.println("\tConsultar imóveis mais consultados\nNão funciona\n");
                     Input.lerString();
                     break;

                case 8 :
                     limpaEcra();
                     System.out.println("\tMarcar imóvel como favorito\n");
                     try{
                         marcarFavorito(u);}
                     catch(Exception e){;}
                     break;

                case 9 :
                     limpaEcra();
                     System.out.println("\tConsultar imóveis favoritos\n");
                     try{verFavoritos(u);}
                     catch(Exception e){;}
                     break;

                case 0 :
                     sair=1;
                     System.out.println("A terminar sessão.\n");
                     
                     break;
                    
                default :
                     System.out.println("\topção inválida.\n\n\n"); 
            }
            
            
        } while(sair==0);
    }
    public static void limpaEcra(){
        System.out.println( "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static Utilizador criarUtilizador () {
        Utilizador utilizador = new Utilizador();
        String nome = "";
        String email = "";
        String password = "";
        String dataNascimento = "";
        String morada = "";
        String password2 = "";
        int i=0, j = -1;
        boolean f = true,g = true;
        Date nascimento = new Date();
        
        limpaEcra();
        System.out.println("\tDigite o seu email:\n");
        email = Input.lerString();
        
        
        limpaEcra();
        System.out.println("\tDigite o seu nome:\n");
        nome = Input.lerString();
        
        limpaEcra();
        System.out.println("\tDigite a sua password:\n");
        password = Input.lerString();
        
        limpaEcra();
        do {
            if(i!=0) {
                System.out.println("\tA password inserida não corresponde à inicial");
            }
            System.out.println("\tDigite novamente a password");
            password2 = Input.lerString();
            i++;
        }
        while(!password.equals(password2));
        
        limpaEcra();
        System.out.println("\tDigite a sua Morada:\n");
        morada = Input.lerString();
        
        limpaEcra();
        do {
            System.out.println("\tDigite a sua Data de Nascimento (formato: dd/mm/aaaa):\n");
            dataNascimento = Input.lerString();
            try {
                nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                f=false;
            }
            catch(ParseException e) {
                System.out.println("Data no formato errado"+e);
            }
        }while(f);
        limpaEcra();

        do {
            System.out.println("É:\n(1)Comprador.\n(2)Vendedor.");
            j = Input.lerInt();
            limpaEcra();
            if(j==1){ 
                g = false;
                try{
                    utilizador = new Comprador(email, nome, password, dataNascimento, morada);
                }catch(Exception e){
                   System.out.println("impossivel criar utilizador"+e);
                }
            }else if(j==2){
                    g = false;
                    try{
                        utilizador = new Vendedor(email, nome, password, dataNascimento, morada);
                    }catch(Exception e){
                        System.out.println("impossivel criar utilizador"+e);
                    }
                  }else {
                    System.out.println("Opção inválida, escolha novamente.");
                  }
        }while(g);

        return utilizador;
    }

   /* public static boolean ValidEmail(String mail) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(mail);
           return !m.matches();
    }*/
    public static Utilizador login() {
        String email = "";
        String pass = "";
        System.out.println("Introduza o seu email.\n");
        email = Input.lerString();
        System.out.println("Introduza a sua password.\n");
        pass = Input.lerString();
        limpaEcra();
        Utilizador util = new Utilizador();
        try{
            remoox.iniciaSessao(email, pass);
            util = remoox.utilizadores.get(email);
            System.out.println("Sessão iniciada.");
            Input.lerString();
            limpaEcra();
        }catch(Exception e) {
            System.out.println("não foi possível iniciar sessão");
            Input.lerString();
            limpaEcra();
        }
        return util;
    }


    public static void consultarTipo(Utilizador u) {
        int j = 1;
        String tipo = "";
        int preco = 0;
        ArrayList<Imovel> lista = new ArrayList<Imovel>();
        Consulta cons = new Consulta();
        do{
            System.out.println("Que tipo de imóveis pretende consultar?");
            System.out.println("Moradia/Apartamento/Terreno/Loja/LojaHabitavel");
            tipo = Input.lerString();
            if(tipo.equals("Moradia") || tipo.equals("moradia") || 
               tipo.equals("Apartamento") || tipo.equals("apartamento") ||
               tipo.equals("LojaHabitavel") || tipo.equals("lojahabitavel") ||
               tipo.equals("Terreno") || tipo.equals("terreno") ||
               tipo.equals("Loja") || tipo.equals("loja")) j = 0;
            else {
                System.out.println("Dado introduzido inválido.\n");
            }
        }while(j==1);
        System.out.println("Até que preço?");
        preco = Input.lerInt();
        limpaEcra();
        System.out.println("Estes são os imóveis deste tipo até este preço.");
        lista = remoox.getImovel(tipo,preco);
        for (Imovel i : lista) {
            System.out.println(i.toString());
            System.out.println("/---------------/");
            try{
                cons = new Consulta(i.getIdImovel(),u.getEmail());
                
            }catch(Exception e){System.out.println("Consulta nao criada: "+e);}
            try{
                remoox.adConsulta(cons);
            }catch(Exception e){System.out.println("Consulta nao adicionada: "+e);}
        }
        Input.lerString();
        limpaEcra();
    }

    public static void consultarHabitaveis(Utilizador u){
        int p = 0;
        Consulta cons = new Consulta();
        ArrayList<Habitavel> lista = new ArrayList<Habitavel>();
        System.out.println("Até que preço pretende pesquisar?");
        p = Input.lerInt();
        lista = remoox.getHabitaveis(p);
        for (Habitavel i : lista) {
            System.out.println(i.toString());
            System.out.println("/---------------/");
            try{
                cons = new Consulta(i.getIdImovel(),u.getEmail());
                
            }catch(Exception e){System.out.println("Consulta nao criada: "+e);}
            try{
                remoox.adConsulta(cons);
            }catch(Exception e){System.out.println("Consulta nao adicionada: "+e);}
        }
        Input.lerString();
        limpaEcra();
    }

    public static void alterarEstado(Utilizador ut) throws SemAutorizacaoException{
        String id = "", est = "";
        if(ut.getTipo() == 2){
            Vendedor u = (Vendedor) ut;
            System.out.println("Qual o imóvel que pretende alterar o estado. (código id)");
            id = Input.lerString();
            System.out.println("Para que estado pretende alterar?\nVendido / Reservado" );
            est = Input.lerString();
            if(u.portfolio.contains(id)){
                try{
                    remoox.setEstado(id, est);
                    System.out.println("estado alterado com sucesso");
                }catch(Exception e){;}
            }else {throw new SemAutorizacaoException("Não tem autorização.");}
        }else {
            throw new SemAutorizacaoException("Não tem autorização.");
        }
        Input.lerString();
        limpaEcra();
    }

    public static void verConsultas(Utilizador ut) throws SemAutorizacaoException { 
        ArrayList<Consulta> c = new ArrayList<Consulta>();
        if(ut.getTipo() == 2){
            Vendedor v = (Vendedor) ut;
            c = remoox.getConsultas();
            for (Consulta a : c) {
                if(v.portfolio.contains(a.getIdImovel())){
                    System.out.println(a.toString());
                    System.out.println("/---------------/");}
            }
        }else {
            throw new SemAutorizacaoException("Não tem autorização.");
        }
        Input.lerString();
        limpaEcra();
    }

    public static void inserirImovel (Utilizador ut) throws SemAutorizacaoException {
        
        int j = 0 , i = 0;
        String idV = ut.getEmail();
        String e = "Em venda"; // em venda, reservado ou vendido
        limpaEcra();
                
        System.out.println("\tEscreva a rua onde se situa o Imovel:\n");
        String r = Input.lerString();
        limpaEcra();
        System.out.println("\tEscreva o preço que pretende pedir pelo Imovel:\n");
        double pp = Input.lerDouble();
        limpaEcra();
        System.out.println("\tEscreva um preço minimo para o Imovel");
        double pm = Input.lerDouble(); 
        if(ut.getTipo() == 2){
            Vendedor v = (Vendedor)ut;
            do{
                System.out.println("Que tipo de imóveis pretende registar?");
                System.out.println("Moradia/Apartamento/Terreno/Loja/LojaHabitavel");
                String tipo = Input.lerString();
                String id = toStringId();
                if(tipo.equals("Moradia") || tipo.equals("moradia")){ i=3; 

                    System.out.println("Insira o tipo de moradia. (isolada, geminada, banda, gaveto)");
                    String t = Input.lerString();//isolada, geminada, banda, gaveto
                    System.out.println("\tInsira a Área de Implementação\n");                                     
                    double ai = Input.lerDouble();                          
                    System.out.println("\tInsira a Área de Terreno Coberta\n");                                           
                    double atc = Input.lerDouble();
                    System.out.println("\tInsira a Área de Terreno\n");                                                   
                    double at = Input.lerDouble();
                    System.out.println("\tInsira o número de quartos\n");                                                    
                    int q = Input.lerInt();
                    System.out.println("\tInsira o número de wcs\n");                                                    
                    int w = Input.lerInt();
                    System.out.println("\tInsira o número de Porta\n");                                                    
                    int np = Input.lerInt();

                    try{
                        Moradia m = new Moradia(id, r, pp, pm, e, t, ai, atc, at, q, w, np);
                        remoox.registaImovel(m);
                        Vendedor u = (Vendedor)remoox.utilizadores.get(idV);
                        u.portfolio.add(id);
                        //System.out.println(m.toString()); Input.lerString();
                    }catch(Exception ex) {
                        System.out.println("Nao foi possivel adicionar Moradia: "+ex);
                    }
                }
                else if(tipo.equals("Apartamento") || tipo.equals("apartamento")){ i=1; 
                        System.out.println("\tInsira o tipo de Apartamento. (simples, duplex, triplex)");
                        String t = Input.lerString();
                        System.out.println("\tInsira a Área de Terreno\n");                                                             
                        double at = Input.lerDouble();
                        System.out.println("\tInsira o número de quartos\n");                                                             
                        int q = Input.lerInt();
                        System.out.println("\tInsira o número de wcs\n");                                                             
                        int w = Input.lerInt();
                        System.out.println("\tInsira o número de Porta\n");                                                          
                        int np = Input.lerInt();
                        System.out.println("\tInsira o número de Andar\n");                                                          
                        int na = Input.lerInt();
                        System.out.println("\tPossui garagem? (true/false)\n");                                                           
                        boolean g = Boolean.parseBoolean(Input.lerString());

                        try{
                            Apartamento apart = new Apartamento(id, r, pp, pm, e, t, at, q, w, np, na, g);
                            remoox.registaImovel(apart);
                            Vendedor u = (Vendedor)remoox.utilizadores.get(idV);
                            u.portfolio.add(id);
                            //System.out.println(apart.toString());Input.lerString();
                        }catch(Exception ex) {
                            System.out.println("Nao foi possivel adicionar Apartamento: "+ex);
                        }                        
                     }
                     else if(tipo.equals("Terreno") || tipo.equals("terreno")){ i = 4; 
                                                        System.out.println("\tInsira o tipo de terreno. (Habitaçao ou Armazem)");
                                    String t = Input.lerString();//isolada, geminada, banda, gaveto
                                    System.out.println("\tInsira a Área de Construção\n");                           
                            double areaC = Input.lerDouble();
                            System.out.println("\tInsira o Diametro de Canalização. (Em mm)\n");                                                     
                            double diamC = Input.lerDouble();
                            System.out.println("\tInsira os kWh maximos suportados pela rede eletrica\n");                                                      
                            double kwh = Input.lerDouble();
                            System.out.println("\tTem acesso a esgotos? (Sim/Não)\n");                                                     
                            boolean ae = Input.lerBoolean();

                            try{
                                Terreno terr = new Terreno(id, r, pp, pm, e, t,areaC, diamC, kwh, ae) ;
                                remoox.registaImovel(terr);
                                Vendedor u = (Vendedor)remoox.utilizadores.get(idV);
                                u.portfolio.add(id);
                                //System.out.println(terr.toString());Input.lerString();
                            }catch(Exception ex) {
                                System.out.println("Nao foi possivel adicionar Terreno: "+ex);
                            }
                           }
                          else if(tipo.equals("Loja") || tipo.equals("loja")){ i= 2; 
                                    System.out.println("\tInsira o tipo de negócio viavél na loja.");
                                    String t = Input.lerString();
                                    System.out.println("\tInsira a Área de Terreno\n");                                              
                                    double at = Input.lerDouble();
                                    System.out.println("\tInsira o número de Porta\n");                                              
                                    int np = Input.lerInt();
                                    System.out.println("\tPossui wc? (true/false)\n");                                              
                                    boolean w = Boolean.parseBoolean(Input.lerString());
                                    
                                    try{
                                        Loja l = new Loja(id, r, pp, pm, e, t, at, np, w);
                                        remoox.registaImovel(l);
                                        Vendedor u = (Vendedor)remoox.utilizadores.get(idV);
                                        u.portfolio.add(id);
                                        //System.out.println(l.toString());Input.lerString();
                                    }catch(Exception ex) {
                                        System.out.println("Nao foi possivel adicionar Loja: "+ex);
                                    }
                                }
                               else if(tipo.equals("LojaHabitavel") || tipo.equals("LojaHabitavel")){ i= 5; 

                                        System.out.println("\tInsira o tipo de Loja Habitável(Apartamento). (simples, duplex, triplex)");
                                        String ti = Input.lerString(); //tipo de apartamento
                                        System.out.println("\tInsira a Área de Terreno\n");                                                               
                                        double at = Input.lerDouble();
                                        System.out.println("\tInsira o número de quartos\n");                                                               
                                        int q = Input.lerInt();
                                        System.out.println("\tInsira o número de wcs\n");                                                              
                                        int w = Input.lerInt();
                                        System.out.println("\tInsira o número de porta\n");                                                              
                                        int np = Input.lerInt();
                                        System.out.println("\tInsira o número de andar\n");                                                            
                                        int na = Input.lerInt();
                                        System.out.println("\tPossui garagem? (true/false)\n");                                                              
                                        boolean g = Boolean.parseBoolean(Input.lerString());
                                        System.out.println("\tInsira o tipo de loja\n");                                                              
                                        String tl = Input.lerString(); //tipo de loja
                                        System.out.println("\tInsira a Área)\n");                                                              
                                        double al = Input.lerDouble();
                                        System.out.println("\tPossui wc? (true/false)\n");                                                              
                                        boolean wcs = Boolean.parseBoolean(Input.lerString());

                                        try{
                                            Lojahab lojahab = new Lojahab( id, r, pp, pm, e, ti, at, q, w, np, na, g, tl, al, wcs);
                                            remoox.registaImovel(lojahab);
                                            Vendedor u = (Vendedor)remoox.utilizadores.get(idV);
                                            u.portfolio.add(id);
                                            //System.out.println(lojahab.toString());Input.lerString();
                                        }catch(Exception ex) {
                                            System.out.println("Nao foi possivel adicionar LojaHabitavel"+ex);
                                        }
                                    }
                                    else {
                                        System.out.println("Dado introduzido inválido.\n"); j=1;
                                    }
            }while(j==1);

    }
}

    public static void verFavoritos(Utilizador ut) throws SemAutorizacaoException {
      if(ut.getTipo() == 1){
        Comprador u = (Comprador) ut;
        ArrayList<String> aux = u.getFavorit();
        ArrayList<Imovel> fav = new ArrayList();
        TreeSet<Imovel> res = new TreeSet<Imovel>(new ComparatorPreco()); 
        for (String s : aux) {
            fav.add(remoox.imoveis.get(s));
        }

        for(Imovel e: fav){
            res.add(e.clone());}

        for (Imovel r : res) {
            System.out.println(r.toString());
        }
      }else {
            throw new SemAutorizacaoException("Não tem autorização.");
      }
    }

   

    public static void marcarFavorito(Utilizador ut) throws SemAutorizacaoException{
        String id = "";
        if(ut.getTipo() == 1){
            Comprador u = (Comprador) ut;
            System.out.println("Qual o imóvel que pretende marcar como favorito. (código id)");
            id = Input.lerString();
            //remoox.setFavorito(id);
            u.favoritos.add(id);
        }else {
            throw new SemAutorizacaoException("Não tem autorização.");
        }
    }

    public static void obterMapeamento(){
        HashMap<Imovel,Vendedor> map = remoox.getMapeamentoImoveis();
        for (Imovel key : map.keySet()) {
            System.out.println(key.toString() + "\n" + map.get(key).toString());
        }

    }

    public static String toStringId() {
        int i = remoox.getContador()+1;
        StringBuilder s = new StringBuilder();
        s.append("id"); s.append(i+"\n");
        return s.toString();
    }
}
