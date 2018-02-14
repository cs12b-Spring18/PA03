package pa03team17;

import java.awt.*;
import java.awt.event.*;


/**
 * RichardCircle are light green circles which constantly changes its horizontal and vertical radius
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class RichardCircle extends CircleShape{

  private double vr=1.0;    //adding a new instance variable
  public int num = 0;

	/**
	 * create a radius changing circle and set the color to light green
	 */
  public RichardCircle(){
    super();
		this.color = new java.awt.Color(88,214,141,150); // light green
  }       //changes the color


  public void draw(Graphics g){
    int x = num;
    int y = 500-num;

    if ((num/2)%2 == 0){
      x = num%500;
      y = 500 - num%500;
    }else{
      x = 500 - num%500;
      y = num%500;
    }

    int u = (int)(250-0.5*x);
    int v = (int)(250-0.5*y);
    int a = (int)(350-0.5*x);
    int b = (int)(350-0.5*y);
    int w = (int)(0.5*x);
    int h = (int)(0.5*y);
    g.setColor( color );
    g.fillOval( u,v,w,h );

    g.setColor( color );
    g.fillOval( u,v,h,w );

    g.setColor( color );
    g.fillOval( v,u,w,h );

    g.setColor( color );
    g.fillOval( v,u,h,w );

    g.setColor( color );
    g.fillOval( b,a,w,h );

    g.setColor( color );
    g.fillOval( a,b,h,w );

    g.setColor( color );
    g.fillOval( a,b,w,h );

    g.setColor( color );
    g.fillOval( b,a,h,w );
  }


	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.
    num++;
		this.radius += dt*vr;  //changed raduis based on dt and vr

    if  (this.radius <10) this.vr *= -1;
    else if (this.radius > 50) this.vr *= -1;
		super.update(dt);  //calls the parent one
  }




}
