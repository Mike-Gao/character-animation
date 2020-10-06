#version 400

uniform vec3 kd;
uniform vec3 ks;
uniform float shininess;
uniform vec3 fillLightDir;
uniform vec3 viewDir;
uniform vec3 keyLightDir;
uniform vec3 backLightDir;
uniform vec3 backLightIntensity;
uniform vec3 keyLightIntensity;
uniform vec3 fillLightIntensity;
in vec3 normalForFP;

out vec4 fragColor;

// TODO: Objective 7, GLSL lighting

void main(void) {
   //fragColor = vec4( normalForFP, 1 );
   vec3 ld = kd * fillLightIntensity * max(0, dot(normalForFP, fillLightDir))
            + kd * backLightIntensity * max(0, dot(normalForFP, backLightDir))
            + kd * keyLightIntensity * max(0, dot(normalForFP, keyLightDir));

   vec3 ls = ks * fillLightIntensity * pow(max(0, dot(normalForFP, normalize(viewDir+fillLightDir))), shininess);
            + ks * backLightIntensity * pow(max(0, dot(normalForFP, normalize(viewDir+backLightDir))), shininess);
            + ks * keyLightIntensity * pow(max(0, dot(normalForFP, normalize(viewDir+keyLightDir))), shininess);
   fragColor = vec4( ld + ls, 1 );
}