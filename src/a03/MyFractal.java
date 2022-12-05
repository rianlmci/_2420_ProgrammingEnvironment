package a03;

import static a03.StdDraw.*;

public class MyFractal {
    /**
     * Draws a spooky pumpkin with a face on it!
     * @param x horizontal coordinate on coordinate plane for the image to be placed at
     * @param y vertical coordinate on coordinate plane for the image to be placed at
     * @param size scales the image
     */
    public static void drawMyShape(double x, double y, double size){
        //stem of pumpkin
        StdDraw.setPenColor(GREEN);
        StdDraw.filledRectangle(x,y + (0.25*size),(0.25*size),(1.2*size));
        //gourd of pumpkin
        StdDraw.setPenColor(ORANGE);
        StdDraw.filledCircle(x,y,size);
        //face of pumpkin
        //TODO: Margret, comment line below out because image file will be missing! Basic image will still draw w/o it!
        StdDraw.picture(x,y,"/images/pumpkinFace.png",(2*size),(2*size));

    }

    /**
     * Creates a fractal pattern with scary pumpkins!
     * @param x horizontal coordinate on coordinate plane for the image to be placed at
     * @param y vertical coordinate on coordinate plane for the image to be placed at
     * @param size scales the image
     * @param n level of complexity for the fractal.
     */
    public static void drawMyFractal(double x, double y, double size, int n){
        //base case
        if (n == 0){return;}
        drawMyShape(x,y,size);
        //generate new size and positions for smaller shapes
        drawMyFractal(x + (2.5 * size),y,size/2,n-1);
        drawMyFractal(x,y - (2.5 * size),size/2,n-1);
        drawMyFractal(x + (2.5 * size),y - (2.5 * size),size/2,n-1);

    }
    /**
     * Test client.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        StdDraw.clear(BLACK);
        drawMyFractal(0.17,0.77,0.15,2);
    }
}
