package comp557.a1;

import javax.vecmath.Tuple3d;
import mintools.parameters.DoubleParameter;

public class RotaryJoint extends GraphNode {

    DoubleParameter angle;
    Tuple3d axis;
    Tuple3d position;
    public RotaryJoint(String name, Tuple3d axis, Tuple3d position) {
        super(name);
        dofs.add(angle = new DoubleParameter("angle", 0, -180, 180));
        this.axis = axis;
        this.position = position;
    }
}
