package pa03a;

/**
 * RadiusChangingCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class Karrina extends CircleShape{

  private double vr=1.0;    //adding a new instance variable
  private double right = CircleShape.boardWidth + 15;
  private double bottom = CircleShape.boardHeight +70;


	/**
	 * create a radius changing circle and set the color to yellow
	 */

  public Karrina(){
    //super();
		this.color = new java.awt.Color(255,0,255,255); // transparent blue
  }

  public void keepOnBoard(){
    if (this.x < this.radius) {
     // it went off the left edge! do something!
      this.vx = -this.vx;
     this.x = this.radius;
   }else if (this.x > right + this.radius) {
      // it went off the right edge! do something!
      this.vx = -this.vx;
      this.x = right + this.radius;
    }

    if (this.y < this.radius){
      // it went above the top edge!
       this.vy = -this.vy;
      this.y = this.radius;
    } else if (this.y > bottom-this.radius) {
      // it went below the bottom edge!
       this.vy = -this.vy;
      this.y = bottom-this.radius;
    }
  }

  //}
/*
    int u = (int)(x-radius);
    int v = (int)(y-radius);
    int w = (int)(2*radius);
    int h = w;
    g.setColor( color );
    g.fillOval( u,v,w,h );
  //  g.setColor( Color.BLACK );
    g.setColor( Color.BLACK);
    g.drawOval(u,v,w,h );
     /*
     if (this.x < this.radius) {    // > should be <
      // it went off the left edge! do something!
       this.vx = -this.vx;
      this.x = this.radius;

			}else if (this.x > CircleShape.boardWidth-this.radius) {
				// it went off the right edge! do something!
        this.vx = -this.vx;
				this.x = CircleShape.boardWidth-this.radius;
			}

			if (this.y < this.radius){
				// it went above the top edge!
        this.vy = -this.vy;
				this.y = this.radius;

			} else if (this.y > CircleShape.boardHeight-this.radius) {
				// it went below the bottom edge!
        this.vy = -this.vy;
				this.y = CircleShape.boardHeight-this.radius;
			}
      */

      public void update(double dt){    //have double dt inside ()
        // change the properties of the CircleShape after dt seconds have elapsed.

       this.radius += dt*vr;  //changed raduis based on dt and vr

        if  (this.radius <10) this.vr *= -1;
        else if (this.radius > 50) this.vr *= -1;
       super.update(dt);  //calls the parent one
      }
  }


//  }       //changes the color

	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
