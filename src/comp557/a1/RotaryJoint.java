package comp557.a1;

import com.jogamp.opengl.GLAutoDrawable;
import mintools.parameters.DoubleParameter;

public class RotaryJoint extends GraphNode {
    Double rx, ry, rz, tx, ty, tz;
    DoubleParameter angle;
    public RotaryJoint(String name, Double x, Double y, Double z, Double tx, Double ty, Double tz) {
        super(name);
        dofs.add(angle = new DoubleParameter("angle", 0, -180, 180));
        if (x == null) {
            this.rx = 0.0;
        }
        if (y == null) {
            this.ry = 0.0;
        }
        if (z == null) {
            this.ry = 1.0;
        }
        this.rx = x;
        this.ry = y;
        this.rz = z;
        this.tx = tx;
        this.ty = ty;
        this.tz = tz;
    }
    @Override
    public void display (GLAutoDrawable drawable, BasicPipeline pipeline) {
        pipeline.push();
        pipeline.translate(tx,ty,tz);
        pipeline.rotate(Math.toRadians(angle.getValue()),rx,ry,rz);
        super.display(drawable,pipeline);
        pipeline.pop();
    }
}
