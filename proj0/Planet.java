public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double square_distance = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
		return Math.sqrt(square_distance);
	}

	public double calcForceExertedBy(Planet p){
		double force = G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] planets){
		double xforces = 0;
		for(Planet p : planets){
			if(!this.equals(p))
				xforces += calcForceExertedByX(p);
		}
		return xforces;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double yforces = 0;
		for(Planet p : planets){
			if(!this.equals(p))
				yforces += calcForceExertedByY(p);
		}
		return yforces;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = xxPos + xxVel * dt;
		this.yyPos = yyPos + yyVel * dt;
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+ this.imgFileName);
	}
}

