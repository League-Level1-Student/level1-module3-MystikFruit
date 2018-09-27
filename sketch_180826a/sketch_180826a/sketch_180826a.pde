float uph = random(100, 400);
float lph = 999;
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
if (YVelocity == 0 && gravity == 0){
pipeX = 0;

} else {
pipeX = pipeX -2;
if(pipeX==0){
score = score+1;
}
}
Y = Y+YVelocity;
background(255, 255, 255);
fill(73, 242, 80);

rect(pipeX, 0, 40, uph);
if(pipeX == -40){
pipeX = 350;
uph = (int) random(100, 400);
lph = uph+gap;
}
fill(73, 242, 80);
rect(pipeX, uph+gap, 40, lph);
fill(255, 242, 90);
ellipse(X, Y, 20, 20);
fill(73, 242, 80);
rect(0, 580, 1000000000, 20);

fill(0, 0, 0);
text(score, 290, 30);



if (intersectsPipes() == true){
Y = 570;
gravity = 0;
YVelocity = 0;
pipeX = 0;
}
}

void intersect(){
gravity=1000;
}

void mousePressed(){
YVelocity = -6.7;
}
boolean intersectsPipes() {
  print("b: "+Y+" uph: "+uph+" lph: "+lph+"\n");
     if (Y-20 < uph && X > pipeX && X < (pipeX+40)){
          return true; }          
     else if (Y+20>lph && X > pipeX && X < (pipeX+40)) {
          return true; }
     else { return false; }
} 