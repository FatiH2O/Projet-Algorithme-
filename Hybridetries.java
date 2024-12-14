public class Hybridetries  {

    //constructeur abr vide
    public Hybridetries(){
        this.racine='/';
        this.inf = null;
        this.eq = null;
        this.sup = null;

    }

    
    private Hybridetries eq;
    private Hybridetries inf;
    private Hybridetries sup;
    private char racine;
    private int cpt=0;

    // charAt(), substring(), isEmpty() dans la bibli String

    //primitive sur le clé 

    public char firstchar(String key) {
        
        if (key != null && !key.isEmpty()) {
            return key.charAt(0);  
        } 
        System.out.println("la clé est vide");
        return '0';

    }

    public static String remaining(String key){

        if (key != null && !key.isEmpty()) {
            return key.substring(1);  
        } 
        System.out.println("la clé est vide");
        return "0";
     }

    public static char chari(String key,int i) {
        try{
        if (key != null && !key.isEmpty()) {
            return key.charAt(i);  
        }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("la clé est vide");
        return '0';

    }

    public static int length(String key) {

        return key.length();
    }

    //Primitive abr

    public  boolean  isEmpty(){
       return this.racine== '/';
       
    }

    public char getrac(){
        return racine;
    }
    
     public char setRac(char k){
        return racine= k;
    }

   
public Hybridetries insertKey(String key) {
    
    if (this.isEmpty()) {
       
        if (key.length() == 1) {
            System.out.println("FIN"+ this.firstchar(key));
            this.setRac(firstchar(key));  
            this.inf = new Hybridetries();  
            this.eq = new Hybridetries();
            this.sup = new Hybridetries();
            
        } else { 
            System.out.println("EQ " + this.firstchar(key));
            this.setRac(firstchar(key));  
            this.inf = new Hybridetries();  
            this.eq = new Hybridetries();
            this.sup = new Hybridetries();  
            return this.eq.insertKey(remaining(key)); 
        }
    } else {
        char p = firstchar(key); 
        System.out.println("helo");
      
        if (p < this.getrac()) {
            System.out.println("INF " +this.firstchar(key));
           
            return this.inf = this.inf.insertKey(key);  
        }
      
        else if (p > this.getrac()) {
            System.out.println("SUP " +this.firstchar(key));
            
           return this.sup = this.sup.insertKey(key);
           

        }
       
        else {
            System.out.println("eqBIS " + this.firstchar(key));
            if(key.length()==1){return this;}

           if (this.eq.isEmpty()) {
                System.out.println("im empty");
                  if(chari(key,1)>getrac()||chari(key,1)<getrac()){
                   return this.insertKey(remaining(key));
                  }
                    
            }
            return this.eq = this.eq.insertKey(remaining(key));
            
        }
    }
    return this; 
}


/*public void afficherArbreRec() {
    
    if (this.isEmpty()) {
        System.out.print("je suis vide");
        return; 
    }

    System.out.print(racine );
   
    
    if (eq != null && !eq.isEmpty()) {
       
        System.out.println("->eq->");
        eq.afficherArbreRec();
        
    }

   
    if (inf != null && !inf.isEmpty()) {
        inf.afficherArbreRec();
    }

    
    if (sup != null && !sup.isEmpty()) {
        System.out.println("->sup->");
        sup.afficherArbreRec();
    }

    
   
}*/


       
}