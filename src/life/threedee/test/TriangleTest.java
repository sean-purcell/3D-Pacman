package life.threedee.test;

import life.threedee.Point;
import life.threedee.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

    Triangle t;

    @Before
    public void setUp() throws Exception{
        t = new Triangle(new Point(0,0,0),new Point(0,1,0),new Point(1,0,0));
    }

    @After
    public void tearDown() throws Exception{
        t = null;
    }

    @Test
    public void test(){

    }
}
