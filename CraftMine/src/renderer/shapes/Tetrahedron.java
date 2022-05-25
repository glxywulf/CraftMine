package renderer.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Tetrahedron {
    private MyPolygon[] polygons;
    private Color color;

    public Tetrahedron(Color c, MyPolygon... p){
        this.color = c;
        this.polygons = p;
        this.setPolygonColor();
    }

    public Tetrahedron(MyPolygon... p){
        this.color = Color.WHITE;
        this.polygons = p;
    }

    public void render(Graphics g){
        for(MyPolygon poly : this.polygons){
            poly.render(g);
        }
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
        for(MyPolygon p : this.polygons){
            p.rotate(CW, xDegrees, yDegrees, zDegrees);
        }
        this.sortPolygons();
    }

    private void sortPolygons(){
        MyPolygon.sortPoligons(this.polygons);
    }

    private void setPolygonColor(){
        for(MyPolygon poly : this.polygons){
            poly.setColor(this.color);
        }
    }
}
