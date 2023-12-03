package KZP.Lab4.Cholaniuk;

public class Equations {
    public double calculate(double x) throws CalcException {
        validateInput(x);

        double y;
        double rad = Math.toRadians(x);

        try {
            y = Math.sin(x - 9) / (x - Math.cos(2 * x));
            System.out.println(y);
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            throw new CalcException("Причина виліту: помилка в розрахунку формули");
        }
        return y;
    }

    private void validateInput(double x) throws CalcException {
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new CalcException("Причина виліту: некоректне введення X");
        }

        if (x - Math.cos(2 * x) == 0) {
            throw new CalcException("Причина виліту: ділення на нуль");
        }
    }
}