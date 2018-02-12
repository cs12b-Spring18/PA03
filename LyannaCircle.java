package pa03;
import java.awt.Color;
import java.awt.Graphics;

/**
 * LyannaCircles are light blue circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class LyannaCircle extends CircleShape{

  private double vr=2.0;
  private double sr=1.0;

	/**
	 * create a radius changing circle and set the color to light blue
	 */
  public LyannaCircle(){
    super();
		this.color = new java.awt.Color(172,214,241,255);
  }

  public String toString(){
    return "LyannaCircle" + super.toString();
  }

	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
   public void draw( Graphics g ) {
       int u = (int)(x-radius);
       int v = (int)(y-radius);
       int w = (int)(2*radius);
       int h = w;
       Color pink = new Color(240,128,128);
       g.setColor( color );
       g.fillOval( u,v,w,h );
       g.setColor( pink);
       g.drawOval(u,v,w,h );
  }

  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.

    // refer to the variables in the orginial file
    this.radius += dt*vr;
    this.vx += dt*vr;
    this.vy += dt*sr;

    // update. the blue circles will act like jellyfish, vanish and becomes bigger
    if (this.radius<3) this.vr+=1;
    else if (this.radius >3)this.vr-=1;

    if  (this.vx <5) this.vr *= 1;
    else if (this.vx>5) this.vr *=-1;
    if (this.vy > 5) this.sr *= 1;
    else if (this.vy<5) this.sr *=-1;
    super.update(dt);

  }


}
