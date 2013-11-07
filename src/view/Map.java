package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Cell;

public class Map extends JPanel{
	private static final long serialVersionUID = 3885570269374432604L;

	private BufferedImage map;
	public final static int CELL_SIZE = 16;
	public final static int MAP_PIXEL_WIDTH = 464;
	public final static int MAP_PIXEL_HEIGHT = 576;

	public Map() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(map == null){
	           map = new  BufferedImage(MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT, BufferedImage.TYPE_INT_RGB);
	           Graphics2D d2 = (Graphics2D) map.createGraphics();
	           d2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	           d2.setColor(Color.BLACK);
	           d2.fillRect(0, 0, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
	    }
		super.paintComponent(g);
		g.drawImage(map, 0, 0, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT, null);		
	}

	public void paintMap(Cell[][] map, int width, int height) {
		Graphics2D d2 = (Graphics2D) this.map.getGraphics();
        d2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		for(int cellHInd = 0; cellHInd < height; cellHInd++){
			for(int cellWInd = 0; cellWInd < width; cellWInd++){
				switch(map[cellHInd][cellWInd].getType()){
				case WALL:{
			        d2.setColor(Color.GRAY);
			        d2.fillRect(map[cellHInd][cellWInd].getY() * CELL_SIZE,
			        			map[cellHInd][cellWInd].getX() * CELL_SIZE, 
			        			CELL_SIZE, CELL_SIZE);
			        repaint();
			        break;
				}
				case APPLE:{
					d2.setColor(Color.GREEN);
			        d2.fillOval(map[cellHInd][cellWInd].getY() * CELL_SIZE,
			        			map[cellHInd][cellWInd].getX() * CELL_SIZE,
			        			CELL_SIZE, CELL_SIZE);
			        repaint();
			        break;
				}
				case CHERRY:{
					d2.setColor(Color.RED);
			        d2.fillOval(map[cellHInd][cellWInd].getY() * CELL_SIZE,
			        			map[cellHInd][cellWInd].getX() * CELL_SIZE, 
			        			CELL_SIZE, CELL_SIZE);
			        repaint();
			        break;
				}
				case FLOOR:{
					d2.setColor(Color.BLACK);
			        d2.fillRect(map[cellHInd][cellWInd].getY() * CELL_SIZE,
			        			map[cellHInd][cellWInd].getX() * CELL_SIZE,
			        			CELL_SIZE, CELL_SIZE);
			        repaint();
			        break;
				}
				default: JOptionPane.showMessageDialog(null, "Ошибка рендеринга, не известный тип текстуры");
					break;
				}
			}
		}
	}

	public BufferedImage getMap() {
		return map;
	}

	public void setMap(BufferedImage map) {
		this.map = map;
	}
}
