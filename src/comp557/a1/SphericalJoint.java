package comp557.a1;

import javax.vecmath.Vector3d;
import mintools.parameters.DoubleParameter;

public class SphericalJoint extends GraphNode {
    private DoubleParameter x,y,z;
    private Double tx,ty,tz;
    public SphericalJoint(String name, Double tx, Double ty, Double tz) {
        super(name);
        dofs.add(x = new DoubleParameter("x", 0, -180,180) );
        dofs.add(y = new DoubleParameter("y", 0, -180, 180));
        dofs.add(z = new DoubleParameter("z", 0, -180, 180));
        this.tx = tx;
        this.ty = ty;
        this.tz = tz;
    }
}
