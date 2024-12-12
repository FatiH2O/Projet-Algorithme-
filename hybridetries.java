public class hybridetries implements Inthybridetries {
    public hybridetries(String lettre){
        this.eq=null;
        this.inf=null;
        this.sup=null;
        this.letter=lettre;

    }


    public hybridetries(hybridetries eq,hybridetries inf,hybridetries sup){

        this.eq=eq;
        this.inf=inf;
        this.sup=sup;
    }  
    private  hybridetries eq;
    private  hybridetries inf;
    private  hybridetries sup;
    private char letter;
    private int cpt=0;

    // charAt(), substring(), isEmpty() dans la bibli String 

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






    public  hybridetries setKey(char key,hybridetries A, ){
        this. = key;
    

        return 
    }
}