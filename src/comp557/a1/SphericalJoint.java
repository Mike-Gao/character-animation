package comp557.a1;

import javax.vecmath.Vector3d;

import com.jogamp.opengl.GLAutoDrawable;
import mintools.parameters.DoubleParameter;

public class SphericalJoint extends GraphNode {
    private DoubleParameter rx,ry,rz;
    private Double tx,ty,tz;
    public SphericalJoint(String name, Double tx, Double ty, Double tz) {
        super(name);
        dofs.add(rx = new DoubleParameter("x", 0, -180,180) );
        dofs.add(ry = new DoubleParameter("y", 0, -180, 180));
        dofs.add(rz = new DoubleParameter("z", 0, -180, 180));
        this.tx = tx;
        this.ty = ty;
        this.tz = tz;
    }
    @Override
    public void display(GLAutoDrawable drawable, BasicPipeline pipeline) {
        pipeline.push();
        pipeline.translate(tx, ty, tz);
        pipeline.rotate(Math.toRadians(rx.getValue()), 1, 0, 0);
        pipeline.rotate(Math.toRadians(ry.getValue()), 0, 1, 0);
        pipeline.rotate(Math.toRadians(rz.getValue()), 0, 0, 1);
        super.display(drawable, pipeline);
        pipeline.pop();
    }
}
