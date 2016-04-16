package models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MyShape {
	protected int diameter, width, height, x, y;
	protected final int PAD = 10;
	protected boolean visible = true;
	protected int direction;
	protected final int RIGHT = 1, LEFT = -1;
	protected int upDown;
	protected final int UP = -1, DOWN = 1;
	protected boolean debug = true;
	protected Rectangle r;
	protected Component c;
	protected String currentImageLocation;
	protected ImageIcon currentImage;
	
	public MyShape(Component c, int height, int width, int x, int y) {
		this.r = new Rectangle(height, width, x, y);
		setX(x);
		setY(y);
		
		
	}
	
	/** Draws this shape in the specified graphics context.
	*/
	public void draw(Graphics g) {
		if (visible) {
			currentImage.paintIcon(this.c, g, x, y);
		}
	}
	/**
	 * Don't know if we need this
	 * @return
	 */
	public ImageIcon getCurrentImage() {
			return this.currentImage;
	}
	
	/**
	 * Change image
	 * @param imageLocation
	 */
	public void setCurrentImage(String imageLocation) {
	
		this.currentImageLocation  = imageLocation;
		this.currentImage = new ImageIcon(currentImageLocation);
	}

	/** X mutator.
	*/
	public void setX(int upperX) {
		x = upperX;
	}

	/** Y mutator.
	*/
	public void setY(int upperY) {
		y = upperY;
	}

	public void setDirection(int dir) {
		if (dir > 0)
			direction = RIGHT;
		else
			direction = LEFT;
	}

	public void setUpDown(int ud) {
		if (ud > 0)
			upDown = DOWN;
		else
			upDown = UP;
	}

	public void changeDirection() {
		direction *= -1;
	}

	/** X accessor.
	*/
	public int getX() {
		return x;
	}

	public boolean getVisible() {
		return visible;
	}

	/** Y accessor.
	*/
	public int getY() {
		return y;
	}

	public int getDirection() {
		return direction;
	}

	public int getUpDown() {
		return upDown;
	}

	public int distance(MyShape c) {
		int deltaX = c.x - x, deltaY = c.y - y;
		return (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

	public Rectangle getRectangle() {
		return this.r;
	}

	public void setVisible(boolean visibility) {
		visible = visibility;
	}	
	
	/**
	 * The touches method determines if this object touches or overlaps the
	 * input object c by determining if the midpoint of input shape is less than
	 * or equal to a distance of the overlap away from the midpoint of this
	 * object
	 * @return true when both deltaX and deltaY are within the overlap
	 */
	public boolean touches(MyShape c) {
		int deltaX = Math.abs((c.x + c.width / 2) - (x + width / 2)),
				deltaY = Math.abs((c.y + c.height / 2) - (y + height / 2)), 
				overlapX = c.width / 2 + width / 2, 
				overlapY = c.height / 2 + height / 2; // this would simply be
															// height if both were
															// the same size
			if (deltaX >= overlapX)
				return false;
			if (deltaY >= overlapY)
				return false;
			return true;
		}
	
	public boolean isInsideHitbox(Rectangle other_rectangle) {
		if (r.intersects(other_rectangle)) {
			return true;
		} else {
			return false;
		}
		
	}

}
