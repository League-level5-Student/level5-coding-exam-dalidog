package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	static int numRobots = 0;
	static String colorofShapes = "";
	static int numSides = 0;
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		numRobots = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		colorofShapes = JOptionPane.showInputDialog("Which color would you like the shapes to be? (1) for red, (2) for blue, (3) for green");
		numSides = Integer.parseInt(JOptionPane.showInputDialog("How many sides will each shape have?"));
		
ArrayList <Thread> threadArray = new ArrayList<Thread>();
ArrayList <Robot> robotArray = new ArrayList<Robot>();
int x = 25;
int y = 25;
for(int z = 0; z<numRobots; z++) {
	x+=100;
	y+=100;
	robotArray.add(new Robot(x,y));
	robotArray.get(z).penDown();
	if(colorofShapes.equals("1")) {
		robotArray.get(z).setPenColor(Color.RED);
	}else if(colorofShapes.contentEquals("2")) {
		robotArray.get(z).setPenColor(Color.BLUE);
	}else {
		robotArray.get(z).setPenColor(Color.GREEN);
	}
	robotArray.get(z).show();
	
	Robot r = robotArray.get(z);
	threadArray.add(new Thread(()->{
		for(int j = 0; j<numSides; j++) {
			r.move(300/numSides);
			r.turn(360/numSides);
		}
	}));
}
			
		
for(int k = 0; k<threadArray.size(); k++) {
			threadArray.get(k).start();
}
		
		
	}
}
