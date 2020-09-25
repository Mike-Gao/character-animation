package comp557.a1;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import comp557.a1.geom.Cube;
import comp557.a1.geom.Quad;
import comp557.a1.geom.Sphere;
import mintools.parameters.DoubleParameter;

import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class Geometry extends GraphNode {
    Vector3d position, rotation, scaling;
    Vector3f color;
    String type;
    public Geometry(String name, String type, Vector3d position, Vector3d rotation, Vector3d scaling, Vector3f color) {
        super(name);
        this.position = position;
        this.color = color;
        this.scaling = scaling;
        this.rotation = rotation;
        this.type = type;
        if (position==null)
            this.position = new Vector3d(0,0,0);
        if (color==null)
            this.color = new Vector3f(1,1,1);
        if (scaling==null)
            this.scaling = new Vector3d(1,1,1);
        if (rotation==null)
            this.rotation = new Vector3d(0,0,0);
    }
    @Override
    public void display(GLAutoDrawable drawable, BasicPipeline pipeline ) {
        pipeline.push();
        GL4 gl = drawable.getGL().getGL4();
        gl.glUniform3f(pipeline.kdID, this.color.x, this.color.y, this.color.z);
        // TODO: Objective 3: Freejoint, transformations must be applied before drawing children
        if (type.equals("box")) {
            Cube.draw(drawable, pipeline);
        } else if (type.equals("spherical")) {
            Sphere.draw(drawable, pipeline);
        } else if (type.equals("quad")) {
            Quad.draw(drawable, pipeline);
        }
        pipeline.translate(position.x, position.y, position.z);
        pipeline.rotate(Math.toRadians(rotation.x), 1, 0, 0);
        pipeline.rotate(Math.toRadians(rotation.y), 0, 1, 0);
        pipeline.rotate(Math.toRadians(rotation.z), 0, 0, 1);
        super.display( drawable, pipeline );
        pipeline.pop();
    }

}
