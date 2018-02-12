package pa03;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This represents the model of an animation in which circular shapes move on a board.
 * It allow for several different kinds of CircleShapes to be drawn.
 * The init method adds circles to the
 */
public class DrawingModel {
	private CircleShape[] circles;
	private AngelCircle[] AngelCircle;
	private LyannaCircle[] LyannaCircle;
	private RichardCircle[] RichardCircle;
	private Karrina[] Karrina;
	private int numCircles=0;
	private int numAngelCircle=0;
	private double speed = 0.02;


	/**
	create a model of a board that can simulate up to n moving circles
	*/
	public DrawingModel(int n){
		circles = new CircleShape[n];
		AngelCircle = new AngelCircle[n];
		LyannaCircle = new LyannaCircle[n];
		RichardCircle = new RichardCircle[n];
		Karrina = new Karrina[n];
		this.init();
	}

	/**
	  initialize the model so that it contain some shapes
	*/
	private void init(){
		CircleShape c;
		for(int i=0; i< circles.length/5; i++){
			// we go to circles.length/2 as we add 2 different kinds of circles
			// each time through this loop.. with 5 classes you'll divide by 5
			// WHEN YOU ADD ANOTHER SUBCLASS OF CIRCLESHAPE YOU NEED TO
			// CREATE IT AND ADD IT TO MODEL
			c = new CircleShape();
			this.add(c);

			c = new AngelCircle();
      this.add(c);

			c = new LyannaCircle();
			this.add(c);

			c = new RichardCircle();
			this.add(c);

			c = new Karrina();
			this.add(c);
		}
	}

	/**
	  add a CircleShape to the model, and update the number of circles in the DrawingModel
		@param c the CircleShape to add to the model
	*/
	private void add(CircleShape c){
		circles[numCircles]=c;
		numCircles++;
	}

	private void add(AngelCircle c){
		circles[numAngelCircle]=c;
		numAngelCircle++;
	}

	private void add(LyannaCircle c){
		circles[numLyannaCircle]=c;
		numLyannaCircle++;
	}

	private void add(RichardCircle c){
		circles[numRichardCircle]=c;
		numRichardCircle++;
	}

	private void add(Karrina c){
		circles[numKarrina]=c;
		numKarrina++;
	}

	/**
		draw the model on the screen
		@param g the Graphics object used to draw the objects in the model
	*/
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.drawRect(0,0,500,500);

		for(int i=0; i<numCircles; i++){
			CircleShape c = circles[i];
			c.draw(g);
		}

		for(int i=0; i<numAngelCircle; i++){
			AngelCircle a = AngelCircle[i];
			a.draw(g);
		}

		for(int i=0; i<numLyannaCircle; i++){
			LyannaCircle a = LyannaCircle[i];
			a.draw(g);
		}

		for(int i=0; i<numRichardCircle; i++){
			RichardCircle a = RichardCircle[i];
			a.draw(g);
		}

		for(int i=0; i<numKarrina; i++){
			Karrina a = Karrina[i];
			a.draw(g);
		}
	}

	/**
		update the state for each of the circles in the model
	*/
	public void update(){
		for(int i=0; i<numCircles; i++){
			circles[i].update(speed);
		}
		for(int i=0; i<numAngelCircle; i++){
			AngelCircle[i].update(speed);
		}
		for(int i=0; i<numLyannaCircle; i++){
			LyannaCircle[i].update(speed);
		}
		for(int i=0; i<numRichardCircle; i++){
			RichardCircle[i].update(speed);
		}
		for(int i=0; i<numKarrina; i++){
			Karrina[i].update(speed);
		}
	}
}
