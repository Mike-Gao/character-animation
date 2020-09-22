package comp557.a1;

import mintools.parameters.DoubleParameter;

public class RotaryJoint extends GraphNode {
    Double x, y, z, tx, ty, tz;
    DoubleParameter angle;
    public RotaryJoint(String name, Double x, Double y, Double z, Double tx, Double ty, Double tz) {
        super(name);
        dofs.add(angle = new DoubleParameter("angle", 0, -180, 180));
        this.x = x;
        this.y = y;
        this.z = z;
        this.tx = tx;
        this.ty = ty;
        this.tz = tz;
    }
}
