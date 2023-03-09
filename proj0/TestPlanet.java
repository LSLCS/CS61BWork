import javax.sound.sampled.SourceDataLine;

public class TestPlanet {
    public static void main(String[] args) {
        Planet samh = new Planet(1,0,0,0,10,null);
        Planet aegir = new Planet(3,3,0,0,5,null);
        Planet rocinante = new Planet(5, -3,0,0,50,null);
        checkEquals(samh.calcForceExertedBy(rocinante),1.334e-9,"calcForceExertedBy",0.01);
        checkEquals(samh.calcForceExertedBy(aegir), 2.565e-10,"calcForceExertedBy",0.01);
        checkEquals(samh.calcForceExertedByX(aegir), 1.423e-10,"calcForceExertedByX",0.01);
        checkEquals(samh.calcForceExertedByY(aegir), 2.1345e-10,"calcForceExertedByY",0.01);
    } 

    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

}