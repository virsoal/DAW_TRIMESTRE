import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        //estas son mis variables
        int numAleatorio = 0;
        boolean encontrado = false;
        int numLinea = 0;
        int numBingo = 0;
        int intentosLinea = 0;
        int intentosBingo = 0;
        boolean bingoCantado = false;
        boolean lineaCantada= false;
        int recorrido=0;
        //le pido al usuario que meta ciertos datos
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce en cuantos intentos cree que acertará el bingo:");
        int apuestaIntentos = scanner.nextInt();
        System.out.println("\n¿Cual es tu apuesta?:");
        int apuesta = scanner.nextInt();
        //crear carton 10 numeros aleatorios entre el 1 y 99
        System.out.println("Los números del carton son:");
        int[] carton = new int[10];
        //recorro mi carton y genero mis numeros aleatorios
        for (int i = 0; i < carton.length; i++) {
            boolean salir = false;
            while (!salir) {
                numAleatorio = (int) (Math.random() * 99) + 1;
                encontrado = false;
                for (int j = 0; j <= i; j++) {
                    if (numAleatorio == carton[j]) {
                        encontrado = true;
                        break;
                    }
                }
                //guardo mis numeros aleatorios no repetidos
                if (!encontrado) {
                    carton[i] = numAleatorio;
                    salir = true;
                }
            }
        }
        for (int cartonCompleto : carton) {
            System.out.print("\t" + cartonCompleto);
        }
        //crear bingo 10 numeros aleatorios entre el 1 y 99
        System.out.println();
        System.out.println("Los números del bingo son:");
        int[] bingo = new int[99];


        for (int i = 0; i < bingo.length && !bingoCantado; i++) {
            boolean repetido = false;

            do {
                repetido=false;
                numAleatorio = (int) (Math.random() * 99) + 1;
                for (int j = 0; j < 99; j++) {
                    if (numAleatorio == bingo[j]) {
                        repetido=true;
                        break;
                    } //final if de duplicado encontrado
                }// final for qeu busca en el [] de mi bingo
            } while (repetido);

            bingo[i] = numAleatorio; //para guardar mi numero aleatorio en mi [] de bingo si no esta repetido
            recorrido++;

            //¿cuantos intentos han sido necesarios para cantar línea y cuántos para bingo?
            for (int k = 0; k < carton.length && !bingoCantado; k++) {
                if (carton[k] == numAleatorio) {
                    numLinea++;
                    numBingo++;
                }
                if (numLinea == 5 && !lineaCantada ) {
                    intentosLinea = recorrido;
                    lineaCantada=true;
                }
                if (numBingo == 10) {
                    intentosBingo = recorrido;
                    bingoCantado = true;
                                    }
            }

        }

        for (int bingoFinal : bingo) {
            System.out.print("\t" + bingoFinal);
        }

        System.out.println();
        if (apuestaIntentos==intentosBingo){
            apuesta=apuesta*10;
            System.out.println("Ha ganado:"+apuesta);
        }
        else{
            System.out.println("Has perdido lo jugado");
        }

        System.out.println("El número de intentos para línea ha sido:"+intentosLinea);

        System.out.println("El número de intentos para bingo ha sido:"+intentosBingo);

    }
}