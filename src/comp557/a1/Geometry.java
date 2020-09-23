package comp557.a1;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import mintools.parameters.DoubleParameter;

import javax.vecmath.Vector3d;

public class Geometry extends GraphNode {
    Vector3d position, rotation, scaling, color;
    public Geometry(String name, Vector3d position, Vector3d rotation, Vector3d scaling, Vector3d color) {
        super(name);
        this.position = position;
        this.color = color;
        this.scaling = scaling;
        this.rotation = rotation;
        if(position==null)
            this.position = new Vector3d(0,0,0);
        if (color==null)
            this.color = new Vector3d(255,0,0);
        if (scaling==null)
            this.scaling = new Vector3d(1,1,1);
        if (rotation==null)
            this.rotation = new Vector3d(0,0,0);
    }
    @Override
    public void display(GLAutoDrawable drawable, BasicPipeline pipeline ) {
        pipeline.push();
        GL4 gl = drawable.getGL().getGL4();
        // TODO: Objective 3: Freejoint, transformations must be applied before drawing children
        pipeline.translate(position.x, position.y, position.z);
        pipeline.rotate(Math.toRadians(rotation.x), 1, 0, 0);
        pipeline.rotate(Math.toRadians(rotation.y), 0, 1, 0);
        pipeline.rotate(Math.toRadians(rotation.z), 0, 0, 1);
        super.display( drawable, pipeline );
        pipeline.pop();
    }

}
