int uph = (int) random(100, 400);
int lph = 400-uph-40;
int pipeX = 250;
int X = 15;
int Y = 300;
int gravity = 1;
void setup(){
size(350, 600);
}

void draw(){
pipeX = pipeX -2;
Y = Y+3;
background(255, 255, 255);
fill(255, 242, 90);
ellipse(X, Y, 20, 20);
fill(73, 242, 80);
rect(pipeX, 0, 40, uph);
if(pipeX == -40){
pipeX = 350;
uph = (int) random(100, 400);
}
fill(73, 242, 80);
rect(pipeX, 600, 40, -lph);
if(pipeX == -40){
pipeX=350;
lph = (int) random(100, 400);
}
}

void mousePressed(){
Y = Y-80;
}