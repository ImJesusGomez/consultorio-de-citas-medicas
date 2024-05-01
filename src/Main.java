import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    // Importamos la clase bufferedReader para ingresar los datos
    public static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws ParseException {

        // Instaciamos la clase calendario para trabajar con ella
        Calendar calendario = Calendar.getInstance();

        // Instaciamos la clase Date para trabajar con ella
        Date fechaCita;
        Date horaCita;

        // Definimos el formato
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        // Le pedimos al usuario que ingrese la fecha de la cita
        System.out.println("------ Bienvenido al Consultorio Tony Tony Chopper ------");
        try{
            System.out.println("Ingrese su nombre por favor: ");
            String nombrePaciente = teclado.readLine();
            System.out.println("Ingresa la fecha de la cita con el siguiente formato (dd-MM-yyyy)");
            fechaCita = formatoFecha.parse(teclado.readLine());
            System.out.println("Ingresa la hora de la cita con el siguiente formato (HH:mm)");
            horaCita = formatoHora.parse(teclado.readLine());

            // Hacemos validaciones para saber si la fecha ingresada es válida

            // Definimos las horas en las que esta abierto el consultorio
            Date horaMinima = formatoHora.parse("08:00");
            Date horaMaxima = formatoHora.parse("18:00");

            // Comprobamos si la cita está en un horario válido
            if(horaCita.before(horaMinima) || horaCita.after(horaMaxima)){
                System.out.println("Hora inválida");
            } else{
                // Declaramos las fechas en las que hay cita
                Date[] citasAgendadas = {formatoFecha.parse("05-09-2022"), formatoFecha.parse("10-09-2022"), formatoFecha.parse("12-09-2022"),
                        formatoFecha.parse("18-09-2022"), formatoFecha.parse("20-09-2022"), formatoFecha.parse("23-09-2022"),
                        formatoFecha.parse("25-09-2022"), formatoFecha.parse("27-09-2022"), formatoFecha.parse("28-09-2022"),
                        formatoFecha.parse("29-09-2022"), };

                // Comprobamos si la fecha de la cita es disponible
                boolean disponibilidad =  false;
                for (Date citaAgendada: citasAgendadas) {
                    if(citaAgendada.equals(fechaCita)){
                        disponibilidad = false;
                        break;
                    } else{
                        disponibilidad = true;
                    }
                }

                System.out.println("-------------------------------------------------------------------------------------------------");
                // En caso de que la fecha sea válida
                if(disponibilidad){
                    System.out.println("Estimado: " + nombrePaciente + " su cita ha sido agendada exitosamente! FECHA: " + formatoFecha.format(fechaCita) + " " + formatoHora.format(horaCita) + "hrs");
                // En caso de que la fecha no sea válida le mostramos al usuario la lista de citas agendadas para que pueda reagendar su cita
                } else{
                    System.out.println("Estimado: " + nombrePaciente + " la fecha de su cita no está disponible");
                    System.out.println("Lista de Citas Agendadas en el consultorio: ");
                    for (Date citaAgendada: citasAgendadas) {
                        System.out.println("Fecha: " + formatoFecha.format(citaAgendada));
                    }
                }
            }
        } catch (ParseException e){
            System.out.println("Formato de fecha no admitido");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Gracias por confiar en el Consultorio Tony Tony Chopper");
        System.out.println("-------------------------------------------------------------------------------------------------");




    }
}