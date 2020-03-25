package generic;

import gui.GUISimulator;
import gui.Simulable;

import java.awt.*;
import java.util.Random;

public class Grid implements Simulable {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 800;
    private static final Color WINDOW_COLOR = Color.WHITE;
    private GUISimulator gui;
    private Cell[][] grille;
    private int gridWidth;
    private int nbInitCells;

    public Grid(int width, int nbInitCells) {
        this.gridWidth = width;
        this.nbInitCells = nbInitCells;
        grille = new Cell[this.gridWidth][this.gridWidth];
        gui = new GUISimulator(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_COLOR);
        gui.setSimulable(this);
        initGrille();

    }

    private void initGrille() {
        int i = 0;
        while (i != this.gridWidth) {
            int j = 0;
            while (j != this.gridWidth) {
                grille[i][j].setCellsSize(100);
                grille[i][j] = new Cell(i, j);
                ;
                j++;
            }
            i++;
        }
        int k = 0;
        while (k != nbInitCells) {
            Random rand = new Random();
            int l = rand.nextInt(gridWidth);
            int m = rand.nextInt(gridWidth);
            if (!(grille[l][m].isAlive())) {
                grille[l][m].live();
                k++;
            }
        }
    }

    @Override
    public void next() {
        computeNextGrid();
        restart();
    }

    @Override
    public void restart() {
        gui.reset();
        draw();
    }

    protected void draw() {
        int i = 0;
        while (i != this.gridWidth) {
            int j = 0;
            while (j != this.gridWidth) {
                if (grille[i][j].isAlive()) {
                    gui.addGraphicalElement(grille[i][j].getRepresentation());
                }
                j++;
            }
            i++;
        }
    }

    public int getNbNeighboursAlive(int i, int j) {
        int nbNeighbours = 0;
        if (grille[i][j].isAlive()) {
            nbNeighbours =-1;
        }
        int k = -1;
        while (k != 2) {
            int l = -1;
            while (l != 2) {
                int x = i + k;
                int y = j + l;
                if (x >= gridWidth) {
                    x = 0;
                }
                if (x < 0) {
                    x = gridWidth - 1;
                }
                if (y >= gridWidth) {
                    y = 0;
                }
                if (y < 0) {
                    y = gridWidth - 1;
                }
                if (grille[x][y].isAlive()) {
                    nbNeighbours++;
                }
                l++;
            }
            k++;
        }
        return nbNeighbours;
    }

    public void computeNextGrid(){
        int i = 0;
        int temp=0;
        while(i != gridWidth && temp==0){
            int j = 0;
            while(j != gridWidth && temp==0){
                System.out.println(getNbNeighboursAlive(i,j));
                if(grille[i][j].isAlive() && getNbNeighboursAlive(i,j) != 2 && getNbNeighboursAlive(i,j)!=3){
                    grille[i][j].die();
                    temp++;
                }else if( !(grille[i][j].isAlive()) && getNbNeighboursAlive(i,j) == 3) {
                    grille[i][j].live();
                    temp++;
                }
                j++;
            }
            i++;
        }
    }
}
