package pa03team17;

import java.awt.Color;

import java.awt.Graphics;

public class AngelCircle extends CircleShape{

  private double vr=2.0;
  private Color borderColor;



	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public AngelCircle(){

		this.color = new Color(255,160,122,100); // transparent blue
    this.borderColor = new Color(255,160,122,100);
  }



  public void draw( Graphics g ) {
      int u = (int)(radius*2);
      int v = (int)(radius*2);
      int w = (int)x;
      int h = w;
      g.setColor( color );
      g.fillOval(u,v,w,h );
      g.setColor( borderColor );
      g.drawOval(u,v,w,h);
  }

  public void keepOnBoard(){
    if (this.x < this.radius) {
      // it went off the left edge! do something!
      this.vx = -this.vx;
      this.x = this.radius;

    }else if (this.x > (this.radius/2)) {
      // it went off the right edge! do something!
      this.vx = -this.vx;
      this.x = AngelCircle.boardWidth-this.radius;
    }

    if (this.y < this.radius){
      // it went above the top edge!
      this.vy = this.vx;
      this.y = this.radius;

    } else if (this.y > CircleShape.boardHeight-this.radius) {
      // it went below the bottom edge!
      this.vy = -this.vx;
      this.y = (AngelCircle.boardHeight-250)-this.radius;
    }
  }

	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.

		this.radius += dt*vr;

    if  (this.radius <5) this.vr *= -1;
    else if (this.radius > 60) this.vr *= -1;
		super.update(dt);

  }




}
