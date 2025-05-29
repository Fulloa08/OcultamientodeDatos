import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TodaysDateTest {


    static class TodaysDateTester extends TodaysDate {
        public int getYear() {
            return this.year;
        }
    }

    @Test
    void testPrintDateAndTimeSalidaContienePalabrasClave() {
        TodaysDate fecha = new TodaysDate();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirigir salida

        fecha.printDateAndTime();

        String salida = outContent.toString();
        assertTrue(salida.contains("Time:"));
        assertTrue(salida.contains("Date:"));
    }

    @Test
    void testDiaEnRangoValido() {
        TodaysDate fecha = new TodaysDate();
        fecha.printDateAndTime();

        assertTrue(fecha.day >= 1 && fecha.day <= 31);
    }

    @Test
    void testHoraEnFormatoValido() {
        TodaysDate fecha = new TodaysDate();
        fecha.printDateAndTime();

        String[] partesHora = fecha.time.split(":");
        assertEquals(3, partesHora.length);

        int hora = Integer.parseInt(partesHora[0]);
        int minutos = Integer.parseInt(partesHora[1]);
        int segundos = Integer.parseInt(partesHora[2]);

        assertTrue(hora >= 0 && hora <= 23);
        assertTrue(minutos >= 0 && minutos <= 59);
        assertTrue(segundos >= 0 && segundos <= 59);
    }

    @Test
    void testAnioValido() {
        TodaysDateTester fecha = new TodaysDateTester();
        fecha.printDateAndTime();

        assertTrue(fecha.getYear() >= 1900);
    }
}
