public class Main {

    public static double R = 6371;

    public static void main(String[] args) {
	// write your code here
        // day 1 25n 15w
        //day 2 23n 20w
        //day 3 21n 24w
        //day 4 20n 27w
        //day 5 19n 35w
        //day 6 21n 46w
        //day 7 23n 56w
        //day 8 25n 65w
        //day 9 28n 70w
        //day 10 32n 73w
        //day 11 34n 74w
        //day 12 36n 74w
        //day 13 39n 74w

        double p1 = partialDistance(25,-15,23,-20);
        double p2 = partialDistance(23,-20,21,-24);
        double p3 = partialDistance(21,-24,20,-27);
        double p4 = partialDistance(20,-27,19,-35);
        double p5 = partialDistance(19,-35,21,-46);
        double p6 = partialDistance(21,-46,23,-56);
        double p7 = partialDistance(23,-56,25,-65);
        double p8 = partialDistance(25,-65,28,-70);
        double p9 = partialDistance(28,-70,32,-73);
        double p10 = partialDistance(32,-73,34,-74);
        double p11 = partialDistance(34,-74,36,-74);
        double p12 = partialDistance(36,-74,39,-74);

        double totalDistance = p1 + p2 + p3 + p4 + p5 + p6 + p7
                + p8 + p9 + p10 + p11 + p12;
        System.out.println("The hurricane travelled " + totalDistance + " kilometers over the 13 days.");

    }

    public static double degToRad(double deg) {
        return (deg * Math.PI) / 180;
    }

    public static double delta(double rad1, double rad2) {
        return rad1 - rad2;
    }


    public static double a(double x1, double y1, double x2, double y2) {
        double deltaPhi = delta(x1, x2);
        double deltaLambda = delta(y1, y2);
        double A = (Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2)) + (Math.cos(x1) * Math.cos(x2)) *
                (Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2));
        return A;
    }

    public static double c(double A) {
        double C = 2 * Math.atan2(Math.sqrt(A),Math.sqrt(1-A));
        return C;
    }

    public static double d(double C) {
        double D = R * C;
        return D;
    }

    public static double partialDistance(double x1, double y1, double x2, double y2) {
        double radx1 = degToRad(x1);
        double rady1 = degToRad(y1);
        double radx2 = degToRad(x2);
        double rady2 = degToRad(y2);
        double A = a(radx1, rady1, radx2, rady2);
        double C = c(A);
        double D = d(C);
        return D;
    }
}
