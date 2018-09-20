float uph = random(100, 400);
float lph = 1000;
float pipeX = 250;
float X = 15;
float Y = 300;
float YVelocity = 0;
float gravity = .2;
float gap = 150;
float score = 0;
void setup(){
size(350, 600);
}

void draw(){
YVelocity += gravity;
pipeX = pipeX -2;
Y = Y+YVelocity;
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
rect(pipeX, uph+gap, 40, lph);
if(pipeX == -40){
pipeX=350;
lph = (int) random(100, 400);}

rect(0, 580, 1000000000, 20);

fill(0, 0, 0);
text(score, 290, 30);

if(pipeX==0){
score = score+1;
}
}

void intersect(){
gravity=1000;
}

void mousePressed(){
YVelocity = -6.7;
}