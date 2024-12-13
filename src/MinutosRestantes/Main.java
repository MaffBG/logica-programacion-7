package MinutosRestantes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Días de la semana en formato numérico, empezando en 0 (lunes = 0, ..., viernes = 4)
        String[] dias = {"lunes", "martes", "miércoles", "jueves", "viernes"};
        
        // Variables para almacenar la entrada del usuario
        String dia;
        int hora, minutos;
        
        // Dìa de la semana
        while (true) {
            System.out.print("Introduce un día de la semana (lunes a viernes): ");
            dia = scanner.nextLine().toLowerCase();
            
            boolean diaValido = false;
            for (String d : dias) {
                if (dia.equals(d)) {
                    diaValido = true;
                    break;
                }
            }
            
            if (diaValido) break;
            else System.out.println("Este día no es válido, por favor ingresa un día de lunes a viernes.");
        }

      // Horario
        while (true) {
            System.out.print("Introduce la hora (0-23): ");
            hora = scanner.nextInt();
            System.out.print("Introduce los minutos (0-59): ");
            minutos = scanner.nextInt();
            
            if (hora >= 0 && hora < 24 && minutos >= 0 && minutos < 60) break;
            else System.out.println("Hora o minutos no válidos, por favor intenta de nuevo.");
        }
        
        // Minutos restantes para el fin de semana
        int diaIndex = -1;
        for (int i = 0; i < dias.length; i++) {
            if (dias[i].equals(dia)) {
                diaIndex = i;
                break;
            }
        }

       
        int minutosFinal = (4 * 24 * 60) + (15 * 60); // viernes 15:00 = 4 días completos + 15 horas en minutos
        int minutosActual = (diaIndex * 24 * 60) + (hora * 60) + minutos;
        int minutosFaltantes = minutosFinal - minutosActual;
        System.out.println("De acuerdo a la informaciòn que haz proporcionado, faltan " + minutosFaltantes + " minutos para el fin de semana.");
        
        scanner.close();
    }
}
