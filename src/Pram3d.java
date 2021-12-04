public class Pram3d {

    public static final double Part = 100;

    public static void main(String[] args) {

        // Вл.класс
        Func f1 = new XY();
        System.out.println(findInt(f1, 1, 3, 1, 3, Part));

        // Ан. класс
        Func f2 = new Func() {
            @Override
            public double f(double x, double y) {
                return (x * x + x) * (2 * y + 1);
            }
        };
        System.out.println(findInt(f2, 3, 4, 7, 10, Part));




        //Ссылка ст. метод
        exp obj = new exp();
        Func f3 = obj::exp;
        System.out.println(findInt(f3, 0.01, 2, 0.5, 4, Part));

        //Ссылка на метод
        Func f4 = X2::pow;
        System.out.println(findInt(f4, 1, 3, 1, 2, Part));

        // Лямбда
        Func f5;
        f5 = (x, y) -> (x * y * Math.sin(x * y));
        System.out.println(findInt(f5, 0, 1, 0, 1, Part));

    }

    public static double findInt(Func func, double left, double right, double front, double back, double Part) {
        double S = 0;
        double sh = (right - left) / Part;
        double dl = (back - front) / Part;
        for (int j = 0; j < Part; j++) {
            S += sh * dl*func.f(sh * j + left, dl * j +front);
        }
        return S;
    }


    private static class XY implements Func {
        @Override
        public double f(double x, double y) {
            return x * y;
        }
    }


    private static class exp {
        double exp(double x, double y) {
            return Math.exp(-x * y);
        }
    }

    private static class X2 {
        static double pow(double x, double y) {
            return (Math.pow(x, 2) + Math.pow(y, 3));

        }
    }
}



