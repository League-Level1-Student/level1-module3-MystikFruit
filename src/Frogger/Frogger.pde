int X = 200;
int Y = 390;
void setup(){
size(400, 400);
}

void draw(){
background(255, 255, 255);
fill(36, 234, 73);
ellipse(X, Y, 15, 15);
if(X<10){
X = 10;
} else if(X>390){
X = 390; 
} else if(Y<10){
Y = 10;
} else if(Y>390){
Y = 390;
}
}

void keyPressed(){
 if(key == CODED){
            if(keyCode == UP){
              Y -= 10;
            }
            else if(keyCode == DOWN){
              Y += 10;
            }
            else if(keyCode == RIGHT){
              X += 10;
            }
            else if(keyCode == LEFT){
              X -= 10;
            }
      } 
}

class car{
void display(){
  fill(139, 135, 136);
  rect(200, 10, 20, 10);
}
}