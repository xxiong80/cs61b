public class NBody{
	public static double readRadius(String fName){
		In in = new In(fName);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	public static Planet[] readPlanets(String fName){
		In in = new In(fName);
		int numPlanets = in.readInt();
		Planet[] planets = new Planet[5];
		double radius = in.readDouble();
		for(int i = 0; i < numPlanets; i++){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String imgName = in.readString();
			planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgName);
		}
		return planets;
	}

	public static void main(String[] args){
			double T = Double.valueOf(args[0]);
			double dt = Double.valueOf(args[1]);
			String filename = args[2];
			Planet[] planets = readPlanets(filename);
			double radius = readRadius(filename);

			StdDraw.setScale(-1 * radius, radius);
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(Planet pl : planets){
				pl.draw();
			}
			StdDraw.show();
			StdDraw.enableDoubleBuffering();

			double t = 0.0;
			while(t <= T){
				double[] xForces = new double[planets.length];
				double[] yForces = new double[planets.length];
				for(int i = 0; i < planets.length; i++){
					xForces[i] = planets[i].calcNetForceExertedByX(planets);
					yForces[i] = planets[i].calcNetForceExertedByY(planets);
				}
				for(int i = 0; i < planets.length; i++){
					planets[i].update(dt, xForces[i], yForces[i]);
				}
				StdDraw.picture(0, 0, "images/starfield.jpg");
				for(Planet pl : planets){
					pl.draw();
				}
				StdDraw.show();
				StdDraw.pause(10);
				t += dt;
			}
			StdOut.printf("%d\n", planets.length);
			StdOut.printf("%.2e\n", radius);
			for (int i = 0; i < planets.length; i++) {
				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
			}
	}
}