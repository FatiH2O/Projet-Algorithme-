

public class Hybridetries  {

    /*classe racine = couple char int pour marquer la fin d'un mot */
    public class Racine{
        public Racine(char ra,int cpt,boolean visited){
            this.ra=ra;
            this.cpt=cpt; //pour marquer la fin d'un mot
            this.visited=visited; //pour e pas compter les mots deux fois
        }
        private char ra;
        private int cpt;
        private boolean visited;

        public char getRa(){
            return ra;
        }

        public void setRa(char ra ){
            this.ra=ra;
        }

        public int getcpt(){
            return cpt;
        }

        public void setcpt(int cpt ){
            this.cpt=cpt;
        }

        public boolean getVisited(){
            return visited;
        }

        public void setVisited(){
            visited= true;
        }


    }

    /*Fin classe racine  */


    //constructeur abr vide
    public Hybridetries(){
        this.racine= new Racine('/',0,false);
        this.inf = null;
        this.eq = null;
        this.sup = null;

    }

    
    private Hybridetries eq;
    private Hybridetries inf;
    private Hybridetries sup;
    private  Racine racine ;
    private static int end_word=0;

    // charAt(), substring(), isEmpty() dans la bibli String

    //primitive sur le clé 

    /*recuperer la première lettre de la clé */
    public static char firstchar(String key) {
        
        if (key != null && !key.isEmpty()) {
            return key.charAt(0);  
        } 
        System.out.println("la clé est vide");
        return '0';

    }
/*récuperer la cle sans la première lettre */
    public static String remaining(String key){

        if (key != null && !key.isEmpty()) {
            return key.substring(1);  
        } 
        System.out.println("la clé est vide");
        return "0";
     }


//pas utilisé pour l'instant
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

    /*longeur de la clé */
    public static int length(String key) {

        return key.length();
    }

    //Primitive abr

    /*arbre vide ou pas */
    public  boolean  isEmpty(){
       return this.racine.getRa()=='/'&&this.racine.getcpt()==0;
       
    }
    /*recuper racine  */
    public Racine getrac(){
        return this.racine;
    }
    
     public void setRac(char k){
        this.racine.setRa(k);
    }

    public int getCpt(){
        return end_word;
    }

    public void setCpt(){
        end_word++;
}
    public void set_end_of_word(){
        this.racine.setcpt(end_word);
    };

   
public Hybridetries insertKey(String key) {
    
    if (this.isEmpty()) {
       
        if (key.length() == 1) {
          //  System.out.println("FIN"+ this.firstchar(key.toLowerCase()));
            this.setRac(firstchar(key.toLowerCase()));
            this.setCpt();
            this.set_end_of_word();
            System.out.println(" FIN " + this.getrac().getRa()+ " "+ this.getrac().getcpt());

            this.inf = new Hybridetries();  
            this.eq = new Hybridetries();
            this.sup = new Hybridetries();
            return this;
            
        } else { 
            //System.out.println("EQ " + this.firstchar(key.toLowerCase()));
            this.setRac(firstchar(key.toLowerCase()));
            System.out.println("EQ " + this.getrac().getRa()+ " "+ this.getrac().getcpt());  
            this.inf = new Hybridetries();  
            this.eq = new Hybridetries();
            this.sup = new Hybridetries();  
            this.eq.insertKey(remaining(key)); 
        }
    } else {
        char p = firstchar(key); 
       
      
        if (p < this.getrac().getRa()) {
            System.out.println("INF " +this.firstchar(key.toLowerCase()));
           
            this.inf = this.inf.insertKey(key);  
        }
      
        else if (p > this.getrac().getRa()) {
            System.out.println("SUP " +this.firstchar(key.toLowerCase()));
            
            this.sup = this.sup.insertKey(key.toLowerCase());
           

        }
       
        else {
            System.out.println("eqBIS " + this.firstchar(key));
            if(key.length()==1&&this.getrac().getcpt()==0){ //afin de marquer la fin d'un nouveau mot préfixe d'un autre mot qui était dja dans le dico
                this.setCpt();
                this.set_end_of_word();
                return this;
            }
            else if(key.length()==1&&this.getrac().getcpt()!=0){
                System.out.println(" FIN mot deja dans le dico " + this.getrac().getcpt());
                this.setCpt();
                return this;//on ne fait rien car mot deja ds le dico
            }

            this.eq = this.eq.insertKey(remaining(key.toLowerCase()));
            
        }
    }
    return this;
}


    public boolean  Recherche(Hybridetries arbre,String mot){

     if(mot==" "){System.out.println("false " + this.getrac().getcpt());return false;}

     char p = firstchar(mot.toLowerCase());
     
       
     if(this.isEmpty()){System.out.println("false " + this.getrac().getcpt());return false;}

     if (p < this.getrac().getRa()) {
           return inf.Recherche(this.inf, mot.toLowerCase());  
        }
      
     else if (p > this.getrac().getRa()) {
            return sup.Recherche(this.sup,mot.toLowerCase());
        }
       
     else {
            if(mot.length()==1&&this.getrac().getcpt()!=0){System.out.println("true " + this.getrac().getcpt());return true;}
            else if (mot.length()==1){System.out.println("false " + this.getrac().getcpt()); return false;}

           return  eq.Recherche(this.eq,remaining(mot.toLowerCase()));  
        }
        
    }

    
    public int ComptageMots(Hybridetries arbre){

     if(arbre.isEmpty()) return 0; 
     
       
     if(arbre.getrac().getcpt()!=0&&arbre.getrac().getVisited()==false){//si pas visité et c'est un mots on rajoute 1
        arbre.getrac().setVisited();
        return 1+ ComptageMots(arbre.eq)+ComptageMots(arbre.sup)+ ComptageMots(arbre.inf);
     }else{
        return ComptageMots(arbre.eq)+ComptageMots(arbre.sup)+ ComptageMots(arbre.inf);
     }

    }
    





       
}