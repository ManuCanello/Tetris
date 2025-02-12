public class Ficha {
    private int[][] ficha;

    public Ficha(int i){
        switch (i) {
            case 1 -> {
                int[][] t ={
                    {0,1,0},
                    {1,1,1},
                };
                this.ficha=t;
            }
            case 2 -> {
                int[][] cuadrado ={
                    {2,2},
                    {2,2},
                };
                this.ficha=cuadrado;
            }
            case 3 -> {
                int[][] l ={
                    {3,0},
                    {3,0},
                    {3,3},
                };
                this.ficha=l;
            }
            default -> throw new AssertionError();
        }
    }


    public int[][] getFicha() {
        return ficha;
    }

    public void setFicha(int[][] ficha) {
        this.ficha = ficha;
    }
}
