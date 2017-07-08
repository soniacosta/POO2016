import java.util.Comparator;
import java.io.Serializable;

public class ComparatorPreco implements Comparator<Imovel>, Serializable {
  
   public int compare(Imovel i1, Imovel i2) {

     
     if(i1.getPrecoPedido() > i2.getPrecoPedido())
       return 1; 
     if(i1.getPrecoPedido() < i2.getPrecoPedido())
       return -1;
     else return 0;     
      
     
   }
    
}