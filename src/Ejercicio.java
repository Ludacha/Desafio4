import java.text.DecimalFormat;

public class Ejercicio {
    public static void main(String[] args) {
        // Valor de x en el que queremos estimar ln(x)
        double x = 2.5;

        // Punto de expansión
        double a = 1.0;

        // Calcular la aproximación usando la serie de Taylor hasta el cuarto orden
        double taylorApproximation = taylorSeriesApproximation(x, a);

        // Calcular el valor verdadero de ln(x)
        double trueValue = Math.log(x);

        // Calcular el error relativo porcentual
        double errorRelativePercentage = calculateRelativeError(trueValue, taylorApproximation);

        // Formatear el resultado para mostrarlo con dos decimales
        DecimalFormat df = new DecimalFormat("#.##");

        // Mostrar resultados
        System.out.println("Aproximación de ln(" + x + ") usando la serie de Taylor (4º orden): " + df.format(taylorApproximation));
        System.out.println("Valor verdadero de ln(" + x + "): " + df.format(trueValue));
        System.out.println("Error relativo porcentual: " + df.format(errorRelativePercentage) + "%");
    }

    // Método para calcular la aproximación usando la serie de Taylor hasta el cuarto orden
    public static double taylorSeriesApproximation(double x, double a) {
        double term1 = (x - a);
        double term2 = (Math.pow(x - a, 2)) / 2;
        double term3 = (Math.pow(x - a, 3)) / 3;
        double term4 = (Math.pow(x - a, 4)) / 4;

        return term1 - term2 + term3 - term4;
    }

    // Método para calcular el error relativo porcentual
    public static double calculateRelativeError(double trueValue, double approxValue) {
        return Math.abs((trueValue - approxValue) / trueValue) * 100;

    }
}
