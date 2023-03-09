public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double distance;
        distance = Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double force;
        double distance = this.calcDistance(p);
        force = G * this.mass * p.mass / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double force;
        force = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
        return force;
    }

    public double calcForceExertedByY(Planet p) {
        double force;
        force = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
        return force;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double force = 0;
        for (Planet i : p) {
            if (!this.equals(i)) {
                force += this.calcForceExertedByX(i);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double force = 0;
        for (Planet i : p) {
            if (!this.equals(i)) {
                force += this.calcForceExertedByY(i);
            }
        }
        return force;
    }

    public void update (double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + dt * ax; 
        this.yyVel = this.yyVel + dt * ay; 
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);

    }

    // public String toString() {
    //     String s = "";
    //     Map<String, Integer> map = new TreeMap<>();
    //     map.put(0, "xxPos");
    //     map.put(1, "yyPos");
    //     map.put(2, "xxVel");
    //     map.put(3, "yyVel");
    //     map.put(4, "mass");

    //     for (int i = 0; i < 5; i++) {
    //         String var = treeMap.get(i);
    //         s += String.format("%.4e",this.var + " ");
    //     }
    //     return xxPos + " " + yyPos +  " " + xxVel +  " " + yyVel +  " " + mass +  " " + imgFileName;
    // }
}
