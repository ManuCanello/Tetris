public class Pantalla {
    public static void esperar(int ms){
        try {
            Thread.sleep(ms);  
        } catch (InterruptedException e) {
            
        }
    }

    public static void borrarPantalla(){
        System.out.print("\033[H\033[2J");
    }
}
