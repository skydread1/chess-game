package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import tools.ChessImageProvider;

import model.Coord;
import model.PieceHMI;

import controler.ChessGameControlers;


/**
 * @author Loic and Lucas
 * <p>
 * this class handles the GUI View including the board
 * initialization and the MouseZvent
 */
@SuppressWarnings("serial")
public class ChessGameGUI extends javax.swing.JFrame
		implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, PropertyChangeListener {

	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	private int xAdjustment;
	private int yAdjustment;
	private int xInit;
	private int yInit;
	private ChessGameControlers chessGameControler;
	private static Dimension size;

	/**
	 * @param name
	 * @param chessGameControler
	 * @param boardSize
	 */
	public ChessGameGUI(java.lang.String name, ChessGameControlers chessGameControler, java.awt.Dimension boardSize) {
		this.chessGameControler = chessGameControler;
		ChessGameGUI.size = boardSize;
		init();
	}

	/**
	 * @return the size of the ChessGameControler board
	 */
	public static Dimension getDim() {
		return size;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
        
        @SuppressWarnings("unchecked")
		List<PieceHMI> Liste_PiecesIHM =  (List<PieceHMI>) evt.getNewValue();
		// Add a chess board to the Layered Pane

		init();

		for (PieceHMI p : Liste_PiecesIHM) {
			for (Coord c : p.getList()) {
				JLabel piece = new JLabel(
						new ImageIcon(ChessImageProvider.getImageFile(p.getTypePiece(), p.getColor())));
				JPanel panel = (JPanel) chessBoard.getComponent(c.x + (c.y) * 8);
				panel.add(piece);
			}
		}
    }

	private void init() {
		Dimension boardSize = new Dimension(800, 800);

		// Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().removeAll();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// Add a chess board to the Layered Pane
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.white : Color.black);
			else
				square.setBackground(i % 2 == 0 ? Color.black : Color.white);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

		chessPiece = null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		if (c instanceof JPanel) {
			return;
		} else {
			Coord coordCase = null;
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);
			Point parentLocation = c.getParent().getLocation();
			this.xInit = e.getX();
			this.yInit = e.getY();
			xAdjustment = parentLocation.x - this.xInit;
			yAdjustment = parentLocation.y - this.yInit;
			chessPiece = (JLabel) c;
			chessPiece.setLocation(this.xInit + xAdjustment, this.yInit + yAdjustment);
			chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
			layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);

			List<Coord> casesDeplacementPossible = this.chessGameControler.whereCanYouGo(this.xInit, this.yInit);
			// List<Coord>
			// casesDeplacementPossible=this.chessGameControler.whereCanYouGo(0,6);
			Iterator<Coord> i = casesDeplacementPossible.iterator();
			while (i.hasNext()) {
				coordCase = i.next();
				JPanel panel = (JPanel) chessBoard.getComponent(coordCase.x + (coordCase.y) * 8);
				panel.setBackground(Color.orange);

			}

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (chessPiece == null)
			return;
		chessPiece.setVisible(false);

		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		if (this.chessGameControler.move(new Coord(this.xInit, this.yInit), new Coord(e.getX(), e.getY()))) {

			if (c instanceof JLabel) {
				Container parent = c.getParent();
				parent.remove(0);
				parent.add(chessPiece);
			} else {
				Container parent = (Container) c;
				parent.add(chessPiece);
			}
			chessPiece.setVisible(true);
		} else {
			System.out.println(this.chessGameControler.getMessage());
		}
	}

	// Move the chess piece around
	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null)
			return;
		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
