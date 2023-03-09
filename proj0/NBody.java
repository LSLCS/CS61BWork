public class NBody {
    public static double readRadius(String file) {
        In in = new In(file);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int number = in.readInt();
        Planet[] allPlanets = new Planet[number];
        in.readDouble();
        for (int i = 0; i < number; i++) {
            allPlanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);;
        String filename = args[2];
        Double radius = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);
        int numberPlanet = allPlanets.length;

        StdDraw.setScale(-1*radius, radius);
        StdDraw.clear();

        StdDraw.enableDoubleBuffering();

        double time = 0;
        while (time != T) {
            double[] xForces = new double[numberPlanet];
            double[] yForces = new double[numberPlanet];
            for (int i = 0; i < numberPlanet; i++) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            for (int i = 0; i < numberPlanet; i++) {
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet i : allPlanets) { i.draw(); }
		    StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        System.out.println(numberPlanet);
        System.out.println(String.format("%.2e",radius));
        for (int i = 0; i < numberPlanet; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %13s\n",
            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }

        

    }
}
