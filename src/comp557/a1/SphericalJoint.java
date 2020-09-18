package comp557.a1;

import javax.vecmath.Tuple3d;
import mintools.parameters.DoubleParameter;

public class SphericalJoint extends GraphNode {
    DoubleParameter x,y,z;
    Tuple3d position;
    public SphericalJoint(String name, Tuple3d position) {
        super(name);
        dofs.add(x = new DoubleParameter("x", 0, -18,180) );
        dofs.add(y = new DoubleParameter("y", 0, -180, 180));
        dofs.add(z = new DoubleParameter("z", 0, -180, 180));
        this.position = position;
    }
}
