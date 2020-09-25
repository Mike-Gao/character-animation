package comp557.a1;

import javax.swing.JTextField;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import mintools.parameters.BooleanParameter;

public class CharacterMaker {

	static public String name = "/dev/null - Mike Gao AND 260915701";
	
	// TODO: Objective 8: change default of load from file to true once you start working with xml
	static BooleanParameter loadFromFile = new BooleanParameter( "Load from file (otherwise by procedure)", false );
	static JTextField baseFileName = new JTextField("data/a1data/character");
	
	/**
	 * Creates a character, either procedurally, or by loading from an xml file
	 * @return root node
	 */
	static public GraphNode create() {
		
		if ( loadFromFile.getValue() ) {
			// TODO: Objectives 6: create your character in the character.xml file 
			return CharacterFromXML.load( baseFileName.getText() + ".xml");
		} else {
			// TODO: Objective 3,4,5,6: test DAG nodes by creating a small DAG in the CharacterMaker.create() method 
						
			// Use this for testing, but ultimately it will be more interesting
			// to create your character with an xml description (see example).
			
			// Here we just return null, which will not be very interesting, so write
			// some code to create a test or partial character and return the root node.

			FreeJoint root = new FreeJoint("test");
			root.add(new RotaryJoint("ap", null, null, null, 2.0, 2.0, 0.0));
			var sp = new SphericalJoint("sph", -2.0, 2.0, 0.0);
			root.add(sp);
			var cube = new Geometry("cube1", null, null, new Vector3d(0,0,0), new Vector3f(0f, 0.5f, 1f));
			sp.add(cube);
			return new FreeJoint("test");
		}
	}
}
