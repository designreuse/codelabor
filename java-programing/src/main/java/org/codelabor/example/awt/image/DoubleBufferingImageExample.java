package org.codelabor.example.awt.image;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBufferingImageExample extends Frame implements KeyListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1059171960530085836L;
	
	private Graphics bufferGraphics;
	private Image bufferImage;
	private Image image;
	private int x, y, mx, my;
	private static int IMAGE_WIDTH = 32;
	private static int IMAGE_HEIGHT = 32;
	private static int FRAME_WIDTH = 500;
	private static int FRAME_HEIGHT = 500;

	public DoubleBufferingImageExample() throws HeadlessException {
		super("buffer image example");
		image = Toolkit.getDefaultToolkit().getImage("./src/main/java/ksmiletris.png");
		x = 225;
		y = 225;
		mx = 0;
		my = 0;
		
		Thread thread = new Thread(this);
		thread.start();
		
		addKeyListener(this);
		setBounds(200, 200, FRAME_WIDTH, FRAME_HEIGHT);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public void paint(Graphics graphics) {
		if (bufferImage != null) {
			graphics.drawImage(bufferImage, 0, 0, this);
		}
	}
	
	public void update(Graphics graphics) {
		Dimension dimension = getSize();
		if (bufferGraphics == null) {
			bufferImage = createImage(dimension.width, dimension.height);
			bufferGraphics = bufferImage.getGraphics();
		}
		
		bufferGraphics.setColor(getBackground());
		bufferGraphics.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		bufferGraphics.drawImage(image, x, y, x+IMAGE_WIDTH, y+IMAGE_HEIGHT, 
				this);
		paint(graphics);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DoubleBufferingImageExample();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			mx = 0;
			my = -10;
			break;
		case KeyEvent.VK_DOWN:
			mx = 0;
			my = 10;
			break;
		case KeyEvent.VK_LEFT:
			mx = -10;
			my = 0;
			break;
		case KeyEvent.VK_RIGHT:
			mx = 10;
			my = 0;
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
		
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		while (true) {
			x += mx;
			y += my;
			
			if (x <= -IMAGE_WIDTH) x = FRAME_WIDTH;
			else if (x >= FRAME_WIDTH) x = 0;
			if (y <= -IMAGE_HEIGHT) y = FRAME_HEIGHT;
			else if (y >= FRAME_WIDTH) y = 0;
			
			try {
				Thread.sleep(100);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}