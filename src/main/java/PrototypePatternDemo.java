import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

interface IBacteria{

    public IBacteria iBacteriaClone();

    public String getDnaCode();

}

class Bacteria implements IBacteria{

    String dnaCode;

    Bacteria(String dnaCode){

        this.dnaCode = dnaCode;
    }

    public String getDnaCode() {
        return dnaCode;
    }

    public void setDnaCode(String dnaCode) {
        this.dnaCode = dnaCode;
    }

    public IBacteria iBacteriaClone() {
        return new Bacteria(dnaCode);
    }
}

class BacteriaFactory{


    static Map<String,IBacteria> bacteriaMap =new HashMap<>();

    static {


        bacteriaMap.put("Bacteria",new Bacteria("simon"));
    }

     public static Optional<IBacteria> getProtoType(String type){

        if("Bacteria".equals(type)){

            return Optional.of(bacteriaMap.get(type)!=null?bacteriaMap.get(type).iBacteriaClone():null);
        }

        return Optional.of(null);
    }

}



public class PrototypePatternDemo {

 public static void  main(String args[]){

     System.out.println(BacteriaFactory.getProtoType("Bacteria").isPresent()?BacteriaFactory.getProtoType("Bacteria").get()
             .iBacteriaClone().getDnaCode():"Bacteria not present of the given type");
 }





}
