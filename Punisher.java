package KritznerFilip;
import robocode.*;

public class Punisher extends JuniorRobot
{

	public void dodgeBullet() {
		int	hitByBulletBearing_ = hitByBulletBearing;		
		
		if(hitByBulletBearing_ > 180 || hitByBulletBearing_ < 90){
			ahead(50);
		}
		else if(hitByBulletBearing_ > 90 || hitByBulletBearing_ < 180){
			turnLeft(90);
			ahead(50);
		}
		else if(hitByBulletBearing_ > 180 || hitByBulletBearing_ < 270) {
			ahead(50);
		}
		else if(hitByBulletBearing_ > 270 || hitByBulletBearing_ < 360) {
			turnRight(90);
			ahead(50);
		}
	}
	
	public void attack() {
		int scannedAngle_ = scannedAngle;
		int scannedDistance_ = scannedDistance;		
		int otherRobots = others;

		turnGunTo(scannedAngle_ );
	
		if(scannedDistance_ < 150){
			if(others < 12){
				fire(3);
			}
			else{
				fire(1);
			}
		}
		
		if(scannedDistance_ > 150){
		fire(1);
		}
	}
	
	public void run() {
		setColors(black, black, black, black, black);

		while(true) {
			ahead(20);
			turnGunRight(360);
			back(20);
		}
	}

	public void onScannedRobot() {
		attack();
	}

	public void onHitByBullet() {
		dodgeBullet();
	}
	
	public void onHitWall() {
		int hitWallAngle_ = hitWallAngle;		

		if(hitWallAngle_ > 90){
			turnLeft(180);
			ahead(100);
		}
		if(hitWallAngle_ < 90){
			turnRight(180);
			ahead(100);
		}
	}	
	
	public void onHitRobot() {
			bearGunTo(scannedBearing);
			fire(1);
	}
}
