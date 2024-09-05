import java.text.DecimalFormat;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Parámetros del canal
        double B = 20.0; // Ancho del canal en metros
        double H = 0.3;  // Profundidad del canal en metros
        double n = 0.03; // Coeficiente de rugosidad
        double S = 0.0003; // Pendiente

        // Errores relativos en n y S
        double deltaN = n * 0.10; // ±10% de n
        double deltaS = S * 0.10; // ±10% de S

        // Calcular el flujo Q con los valores centrales
        double Q = calculateFlow(B, H, n, S);

        // Calcular el error relativo porcentual
        double errorN = calculateErrorWithRespectToN(B, H, n, S, deltaN);
        double errorS = calculateErrorWithRespectToS(B, H, n, S, deltaS);

        // Formatear resultados
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Flujo Q con n = " + n + " y S = " + S + ": " + df.format(Q) + " m³/s");
        System.out.println("Error relativo porcentual debido a n: " + df.format(errorN) + "%");
        System.out.println("Error relativo porcentual debido a S: " + df.format(errorS) + "%");

        // Determinar cuál variable tiene mayor impacto
        if (errorN > errorS) {
            System.out.println("El coeficiente de rugosidad n tiene mayor impacto en la precisión del flujo.");
        } else {
            System.out.println("La pendiente S tiene mayor impacto en la precisión del flujo.");
        }
    }

    // Método para calcular el flujo Q usando la fórmula de Manning
    public static double calculateFlow(double B, double H, double n, double S) {
        return (Math.pow((B * H), 5.0 / 3.0) / (n * Math.pow(B + (2 * H), 2.0 / 3.0))) * Math.sqrt(S);
    }

    // Método para calcular el error relativo porcentual debido al coeficiente de rugosidad n
    public static double calculateErrorWithRespectToN(double B, double H, double n, double S, double deltaN) {
        double Q = calculateFlow(B, H, n, S);
        double Q_with_errorN = calculateFlow(B, H, n + deltaN, S);
        return Math.abs((Q_with_errorN - Q) / Q) * 100;
    }

    // Método para calcular el error relativo porcentual debido a la pendiente S
    public static double calculateErrorWithRespectToS(double B, double H, double n, double S, double deltaS) {
        double Q = calculateFlow(B, H, n, S);
        double Q_with_errorS = calculateFlow(B, H, n, S + deltaS);
        return Math.abs((Q_with_errorS - Q) / Q) * 100;
    }
}
