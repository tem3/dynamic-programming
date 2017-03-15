package cracking;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class RobotInAGrid {
	
	public enum Status{
		OPEN, BLOCKED;
	}
	
	JFrame grid;
	ActionListener buttonListener;
	int numRows, numCols;
	Status[][] gridArray;
	JButton[][] buttonArray;
	Color defaultColor;
	public RobotInAGrid(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		gridArray = new Status[numRows][numCols];
		createGrid(numRows, numCols);
		defaultColor = grid.getBackground();
	}
	
	public String findPath(int row, int col) {
		String[][] paths = new String[row][col];
		String path;
		if(row==numRows-1 && col== numCols-1) {
			return "";
		}
		if(row < numRows-1 && gridArray[row+1][col]==Status.OPEN) {
			path = findPath(row+1, col);
			if(path != null) {
				return "d"+path;
			}
		} 
		if(col < numCols-1 && gridArray[row][col+1]==Status.OPEN) {
			path = findPath(row, col+1);
			if(path != null) {
				return "r"+path;
			}
		}
		return null;
	}
	
	
	public void showPath(String path){
		int row = 0;
		int col = 0;
		JButton b = buttonArray[0][0];
		b.setBackground(Color.green);
		for(int i = 0; i < path.length(); i++) {
			if(path.charAt(i)=='d') {
				row++;
			} else {
				col++;
			}
			buttonArray[row][col].setBackground(Color.green);	
		}
	}
	public void reset(){
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				buttonArray[row][col].setBackground(defaultColor);
				gridArray[row][col] = Status.OPEN;
			}
		}
	}
	public void createButtons(){
		buttonListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JButton pushed = (JButton)e.getSource();
				int row = (int) pushed.getClientProperty("row");
				int col = (int) pushed.getClientProperty("col");
				if(gridArray[row][col] == Status.OPEN) {
					pushed.setBackground(Color.GRAY);
					gridArray[row][col] = Status.BLOCKED;
				} else {
					pushed.setBackground(defaultColor);
					gridArray[row][col] = Status.OPEN;
				}

			}
		};
		
		ActionListener startButtonListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JButton startButton = buttonArray[0][0];
				if(((String)startButton.getClientProperty("status")).equals("start")) {
					String path = findPath(0,0);
					showPath(path);
					startButton.setText("reset");
					startButton.putClientProperty("status", "reset");
				} else {
					reset();
					startButton.setText("start");
					startButton.putClientProperty("status", "start");
				}
				
				
			}
		};
		buttonArray = new JButton[numRows][numCols];
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				JButton b = new JButton();
				buttonArray[row][col] = b;
				System.out.println(row+" "+col);
				b.putClientProperty("row", row);
				b.putClientProperty("col", col);
				if(row==0 && col==0) {
					b.setText("start");
					b.putClientProperty("status", "start");
					b.addActionListener(startButtonListener);
				} else {
					b.addActionListener(buttonListener);
				}
				grid.add(b);
				gridArray[row][col] = Status.OPEN;
			}
		}
		
	}
	
	public void createRandomGrid(int numRows, int numCols) {
		this.grid = new JFrame();
		grid.setLayout(new GridLayout(numRows,numCols));
		createButtons();
		grid.setSize(600,600);
		grid.setVisible(true);
	}
	public void createGrid(int numRows, int numCols){
		this.grid = new JFrame();
		grid.setLayout(new GridLayout(numRows,numCols));
		createButtons();
		grid.setSize(600,600);
		grid.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotInAGrid r = new RobotInAGrid(25,25);
		
	
		
	}

}
