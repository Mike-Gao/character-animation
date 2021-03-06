package comp557.a1;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import comp557.a1.geom.Cube;
import comp557.a1.geom.Quad;
import comp557.a1.geom.Sphere;
import mintools.parameters.DoubleParameter;

import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class Geometry extends GraphNode {
    Tuple3d position, rotation, scaling;
    Tuple3f color;
    String type;
    float shininess = 1f;
    public Geometry(String name, String type, Tuple3d position, Tuple3d rotation, Tuple3d scaling, Tuple3f color, float shininess) {
        super(name);
        this.position = position;
        this.color = color;
        this.scaling = scaling;
        this.rotation = rotation;
        this.type = type;
        this.shininess = shininess;
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
        pipeline.setGlKd(gl, color.x, color.y, color.z);
        pipeline.setGlShininess(gl, shininess);
        // TODO: Objective 3: Freejoint, transformations must be applied before drawing children

        pipeline.translate(position.x, position.y, position.z);
        pipeline.scale(scaling.x, scaling.y, scaling.z);
        if (type.equals("box")) {
            Cube.draw(drawable, pipeline);
        } else if (type.equals("sphere")) {
            Sphere.draw(drawable, pipeline);
        } else if (type.equals("quad")) {
            Quad.draw(drawable, pipeline);
        }

        pipeline.rotate(Math.toRadians(rotation.x), 1, 0, 0);
        pipeline.rotate(Math.toRadians(rotation.y), 0, 1, 0);
        pipeline.rotate(Math.toRadians(rotation.z), 0, 0, 1);
        super.display( drawable, pipeline );
        pipeline.pop();
    }

}
