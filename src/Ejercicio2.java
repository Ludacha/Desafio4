import java.text.DecimalFormat;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Valor en el que queremos estimar f(x)
        double x = 3.0;

        // Punto de expansión
        double a = 1.0;

        // Calcular la aproximación usando la serie de Taylor hasta el tercer orden
        double taylorApproximation = taylorSeriesApproximation(x, a);

        // Calcular el valor verdadero de f(x)
        double trueValue = trueFunction(x);

        // Calcular el error relativo porcentual
        double errorRelativePercentage = calculateRelativeError(trueValue, taylorApproximation);

        // Formatear el resultado para mostrarlo con dos decimales
        DecimalFormat df = new DecimalFormat("#.##");

        // Mostrar resultados
        System.out.println("Aproximación de f(" + x + ") usando la serie de Taylor (3º orden): " + df.format(taylorApproximation));
        System.out.println("Valor verdadero de f(" + x + "): " + df.format(trueValue));
        System.out.println("Error relativo porcentual: " + df.format(errorRelativePercentage) + "%");
    }

    // Método para calcular la aproximación usando la serie de Taylor hasta el tercer orden
    public static double taylorSeriesApproximation(double x, double a) {
        double term1 = -62;
        double term2 = 70 * (x - a);
        double term3 = (138 / 2) * Math.pow(x - a, 2);
        double term4 = (150 / 6) * Math.pow(x - a, 3);

        return term1 + term2 + term3 + term4;
    }

    // Método para calcular el valor verdadero de f(x)
    public static double trueFunction(double x) {
        return 25 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + 7 * x - 88;
    }

    // Método para calcular el error relativo porcentual
    public static double calculateRelativeError(double trueValue, double approxValue) {
        return Math.abs((trueValue - approxValue) / trueValue) * 100;
    }
}
