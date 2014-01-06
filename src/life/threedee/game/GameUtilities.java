package life.threedee.game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameUtilities{
	public static final int SC_WIDTH = 720;
	public static final int SC_HEIGHT = 540;
	public static final int R_INC = 4;
	
	public static final int PX_METER = 20;
	
	public static final int PX_WALL_BORDER = 2;
	
	// Wall height in tiles - changeable
	public static final int WALL_HEIGHT = 2;
	
	// Floor width in tiles - should not be changed
	public static final int FLOOR_WIDTH = 2;
	
	// meters per tile.  we can modify this if we need to.  use this in all calculations necessary so scaling is smooth
	public static final float MPT = 1.0f;
	
	public static final Color BLANK = new Color(0, 0, 0, 0);

	//The color of the wall borders.  In case we ever want to change it.
	public static final Color W_BLUE = Color.BLUE;

    public static final boolean t = true, f = false;

    public static final boolean[] no = {f, f, f, f}, up = {t, f, f, f}, le = {f, t, f, f}, dn = {f, f, t, f}, ri = {f, f, f, t}, ud = {t, f, t, f}, rl = {f, t, f, t}, ul = {t, t, f, f}, dl = {f, t, t, f}, dr = {f, f, t, t}, ur = {t, f, f, t}, nu = {f, t, t, t}, nl = {t, f, t, t}, nd = {t, t, f, t}, nr = {t, t, t, f}, al = {t, t, t, t};

    public static final boolean[][][] intersections = mirror(new boolean[][][]
            {{no, no, no, no, no, no, no, no, no, no, no, no, no, no, rl, no, no, no, no, no, no, no, no, no, no, no, no, no, no, no, no},
             {no, dr, ud, ud, ud, nl, ud, ud, ur, no, no, no, no, no, rl, no, no, no, no, no, dr, ud, ud, ur, no, no, dr, ud, ud, ur, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, rl, no, no, rl, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, dl, ud, ud, nd, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, rl, no},
             {no, nu, ud, ud, ud, al, ud, ud, nr, ud, ud, ud, ud, ud, al, ud, ud, ud, ud, ud, al, ud, ud, nl, ud, ud, ul, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, no, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, no, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, rl, no, no, no, no, no, rl, no},
             {no, rl, no, no, no, nu, ud, ud, ur, no, no, dl, ud, ud, nl, ud, ud, nr, ud, ud, nd, no, no, nu, ud, ud, nr, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, rl, no, no, rl, no, no, rl, no, no, rl, no},
             {no, rl, no, no, no, rl, no, no, rl, no, no, rl, no, no, no, no, no, rl, no, no, rl, no, no, rl, no, no, rl, no, no, rl, no},
             {no, dl, ud, ud, ud, nd, no, no, dl, ud, ud, nd, no, no, no, no, no, rl, no, no, dl, ud, ud, nd, no, no, dl, ud, ud, nd, no},
             {no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no, no, no, no, no, rl, no}});

    private static boolean[][][] mirror(boolean[][][] intersections){
        boolean[][][] toReturn = new boolean[intersections.length * 2][intersections[0].length][intersections[0][0].length];
        System.arraycopy(intersections, 0, toReturn, 0, intersections.length);
        for (int i = intersections.length; i < toReturn.length; i++){
            for (int j = 0; j < toReturn[0].length; j++){
                for (int k = 0; k < toReturn[0][0].length; k++){
                    toReturn[i][j][k] = intersections[toReturn.length - i - 1][j][(k + (k % 2) * 2) % 4];
                }
            }
        }
        return toReturn;
    }

	public static boolean equals(double a, double b) {
		return Math.abs(a - b) < 1e-15;
	}
	
	public static BufferedImage loadImage(String ref) {
		try {
			return ImageIO.read(GameUtilities.class.getResourceAsStream("/" + ref));
		} catch (Exception e) {

			try {
				System.out.println("Get as stream didnt work");
				return ImageIO.read(new File("./" + ref));
			} catch (IOException e1) {
				e.printStackTrace();
				e1.printStackTrace();
				return null;
			}
		}
	}
}
