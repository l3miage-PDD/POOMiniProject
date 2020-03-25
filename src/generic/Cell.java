package generic;
import gui.Rectangle;

                ;
import java.awt.*;

public class Cell {
    private static final Color CELLS_DRAW_COLOR= Color.CYAN;
    private static final Color CELLS_FILL_COLOR= Color.BLUE;
    private static int cellsSize;
    private Point centre;
    private boolean alive;

    public Cell(Point c){
        Point p = new Point(c.x*cellsSize,c.y*cellsSize);
        this.centre=p;
        this.alive=false;
    }

    public Cell(int x,int y){
        Point p = new Point(x*cellsSize,y*cellsSize);
        this.centre=p;
        this.alive=false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void live(){
        this.alive=true;
    }

    public void die(){
        this.alive=false;
    }

    public Rectangle getRepresentation(){
        Rectangle r= new Rectangle(centre.x+cellsSize/2,centre.y+cellsSize/2,CELLS_DRAW_COLOR,CELLS_FILL_COLOR,cellsSize);
        return r;
    }

    public static void setCellsSize(int cellsSize) {
        Cell.cellsSize = cellsSize;
    }
}
