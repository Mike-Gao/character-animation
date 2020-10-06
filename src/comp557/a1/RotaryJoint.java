package comp557.a1;

import com.jogamp.opengl.GLAutoDrawable;
import mintools.parameters.DoubleParameter;

public class RotaryJoint extends GraphNode {
    Double rx, ry, rz, tx, ty, tz;
    DoubleParameter angle;
    public RotaryJoint(String name, Double tx, Double ty, Double tz, Double rx, Double ry, Double rz, Double angMin, Double angMax) {
        super(name);
        dofs.add(angle = new DoubleParameter("angle", (angMin+angMax)/2, angMin, angMax));
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
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
