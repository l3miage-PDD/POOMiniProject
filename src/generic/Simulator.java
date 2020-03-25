package generic;

import gui.*;
import java.awt.*;

public class Simulator implements Simulable {
    public final static int WINDOW_WIDTH = 800;
    public final static Color WINDOW_COLOR = Color.WHITE;

    GUISimulator gui;
    Grid grid;

    public Simulator(Grid grid){
        this.grid = grid;
        gui = new GUISimulator(WINDOW_WIDTH, WINDOW_WIDTH, WINDOW_COLOR, this);
    }

    public void setGrid(Grid grid){

    }

    @Override
    public void next() {

    }

    @Override
    public void restart() {

    }
}