import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Consulta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Consulta
{
    // instance variables - replace the example below with your own
    private String idImovel;
    private String idUser;
    private String d; //data
    /**
     * Construtor vazio
     */
    
    public Consulta() {
        idImovel = "";
        idUser = "";
        d = data();
    }
    
    /** 
    * construtor parametrizado
    */
    
   public Consulta(String idi, String idu) {
       // initialise instance variables
       idImovel = idi;
       idUser = idu;
       d = data();
   }
   
   public Consulta(String idi, String idu, String dat) {
       // initialise instance variables
       idImovel = idi;
       idUser = idu;
       d = dat;
   }
   
   /**
    * Construtor de cópia
    */
   public Consulta(Consulta a) {
       this(a.getIdImovel(), a.getIdUser(), a.getData());
   }
   
   // Metodos de instancia
   // getters
   
   public String getIdImovel() { return idImovel; }
   
   public String getIdUser() { return idUser; }
   
   public String getData() { return d; }
   
   // setters
   
   public void setIdImovel(String idi) { idImovel = idi; }
   
   public void setIdUser(String idu) {idUser = idu;}
   
   public void setData(String a) {d = a;}
   
   public Consulta clone() {
       Consulta a = new Consulta(this);
       return a;
   }
   
   public String toString() {
       StringBuilder s = new StringBuilder();
       s.append("idImovel: "); s.append(this.getIdImovel()+"\n");
       s.append("isUser: "); s.append(this.getIdUser()+"\n");
       s.append("Data: "); s.append(this.getData() + "\n");
       return s.toString();
   }
   
   public boolean equals(Consulta a) {
       if (a != null) return (this.idImovel.equals(a.getIdImovel())&& 
                              this.idUser.equals(a.getIdUser()) &&
                              this.d.equals(a.getData())
                              );
       else return false;
   }
   
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String data(){
        String time = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        /*String d="";
        String month="";
        String day="";
        String year="";

        GregorianCalendar gregorianCalendar=new GregorianCalendar();            
        month=String.valueOf(gregorianCalendar.get(GregorianCalendar.MONTH));            
        day=String.valueOf(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
        year=String.valueOf(gregorianCalendar.get(GregorianCalendar.YEAR));
        
        d = day+"-"+month+"-"+year;*/
        return time;
    }
}
