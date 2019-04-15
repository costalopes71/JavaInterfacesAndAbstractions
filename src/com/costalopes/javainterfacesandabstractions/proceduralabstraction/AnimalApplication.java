package com.costalopes.javainterfacesandabstractions.proceduralabstraction;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class AnimalApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Animal");
		
		Group root = new Group();
		Canvas canvas = new Canvas(700, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawAnimals(gc);
		root.getChildren().add(canvas);
		stage.setScene(new Scene(root));
		stage.show();
		
		stage.setX(300);
		stage.setY(-900);
		
	}

	private void drawAnimals(GraphicsContext gc) {
		
		Animal animal = new Animal();
		animal.draw(gc);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
