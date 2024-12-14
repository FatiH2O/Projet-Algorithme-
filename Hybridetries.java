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

    public static char firstchar(String key) {
        
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
    // Si l'arbre est vide (racine est '/')
    if (this.isEmpty()) {
        // Si la clé est un seul caractère
        if (key.length() == 1) {
            this.setRac(firstchar(key));  // On insère le caractère à la racine
            this.inf = new Hybridetries();  // Création des sous-arbres vides
            this.eq = new Hybridetries();
            this.sup = new Hybridetries();
        } else { // Si la clé est plus longue
            this.setRac(firstchar(key));  // On insère le premier caractère à la racine
            this.eq = new Hybridetries();  // Création du sous-arbre égal
            this.eq.insertKey(remaining(key)); // On insère la partie restante dans eq
        }
    } else {
        char p = firstchar(key);  // On obtient le premier caractère de la clé à insérer
    
        // Si le caractère est inférieur à la racine, il va dans le sous-arbre 'inf'
        if (p < this.getrac()) {
          
            if (this.inf == null) {
                this.inf = new Hybridetries();  // Si 'inf' est nul, on crée un sous-arbre
            }
            this.inf = this.inf.insertKey(key);  // On insère la clé dans 'inf'
        }
        // Si le caractère est supérieur à la racine, il va dans le sous-arbre 'sup'
        else if (p > this.getrac()) {
             
            if (this.sup == null) {
                this.sup = new Hybridetries(); 
            }
            this.sup = this.sup.insertKey(key);
           

        }
        // Si le caractère est égal à la racine, il va dans le sous-arbre 'eq'
        else {
            System.out.println("ICI ");
            if (this.eq == null || this.eq.isEmpty()) {

                 System.out.println("je suis laaaaaaa");
                if(chari(key,1)>this.getrac()){
                    this.sup = new Hybridetries();
                    this.eq = this.eq.insertKey(key);
                }      
            }
            this.eq = this.eq.insertKey(remaining(key));
            
        }
    }
    return this; // On retourne l'objet courant pour permettre les insertions en chaîne
}


public void afficherArbreRec() {
    
    if (this.isEmpty()) {
        System.out.print("je suis vide");
        return; 
    }

    System.out.print(racine );

    
    if (eq != null && !eq.isEmpty()) {
        System.out.print("->eq->");
        eq.afficherArbreRec();
        
    }

   
    if (inf != null && !inf.isEmpty()) {
        inf.afficherArbreRec();
    }

    
    if (sup != null && !sup.isEmpty()) {
        System.out.print("->sup->");
        sup.afficherArbreRec();
    }

    
   
}


       
}