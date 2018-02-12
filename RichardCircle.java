package pa03;
import java.awt.*;

/**
 * RadiusChangingCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class RichardCircle extends CircleShape{

  private double vr=1.0;
  private int frameNumber;

	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public RadiusChangingCircle(){
    super();
		this.color = new java.awt.Color(0,0,255,100); // transparent blue
  }

  public void draw(Graphics g){
    int x = frameNumber;
    int y = 500-frameNumber;

    if ((frameNumber/2)%2 == 0){
      x = frameNumber%500;
      y = 500 - frameNumber%500;
    }else{
      x = 500 - frameNumber%500;
      y = frameNumber%500;
    }

    int u = (int)(250-0.5*x);
    int v = (int)(250-0.5*y);
    int w = x;
    int h = y;
    g.setColor( Color.GREEN );
    g.fillOval( u,v,w,h );
    g.setColor( Color.GREEN );
    g.drawOval( u,v,w,h );
  }
	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.


		this.radius += dt*vr;

    if  (this.radius <10) this.vr *= -1;
    else if (this.radius > 50) this.vr *= -1;
		super.update(dt);
  }




}
