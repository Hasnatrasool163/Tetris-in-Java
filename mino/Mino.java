package mino;

import tetris.GamePanel;
import tetris.KeyHandler;
import tetris.PlayManager;

import java.awt.*;

public class Mino {

    public Block b []  = new Block[4];
    public Block tempB[] = new Block[4];

    int autoDropCounter = 0;

    public int direction = 1;
    boolean leftCollision,rightCollision,bottomCollision;
    public boolean active = true;

    // variables to create time gap b/w last and  new mino
    public boolean deactivating;
    int deactivateCounter =0;





    public void create(Color c){
        b[0]= new Block(c);
        b[1]= new Block(c);
        b[2]= new Block(c);
        b[3]= new Block(c);
        tempB[0]= new Block(c);
        tempB[1]= new Block(c);
        tempB[2]= new Block(c);
        tempB[3]= new Block(c);

    }

    public void setXY(int x, int y){

    }

    public void updateXY(int direction){

        checkRotationCollision();


        if (leftCollision == false && rightCollision == false && bottomCollision == false){
         this.direction=direction;

         // to store the orignal positon if collsion happens and we need to cancel
        // that why used temp array to store
         b[0].x = tempB[0].x;
         b[0].y = tempB[0].y;
         b[1].x = tempB[1].x;
         b[1].y = tempB[1].y;
         b[2].x = tempB[2].x;
         b[2].y = tempB[2].y;
         b[3].x = tempB[3].x;
         b[3].y = tempB[3].y;                                                             }

    }

    public void getDirection1(){

    }public void getDirection2(){

    }public void getDirection3(){

    }public void getDirection4(){
    }
    public void checkMovementCollision(){

            leftCollision =false;
            rightCollision =false;
            bottomCollision =false;

            // check static block collision
        checkStaticBlockCollision();

            // check frame collision
            // left wall

        for (int i=0 ; i< b.length ; i++){
            if (b[i].x == PlayManager.left_x){
                leftCollision = true;
            }
        }

        // right wall

        for (int i=0 ; i< b.length ; i++){
            if (b[i].x + Block.SIZE == PlayManager.right_x){
                rightCollision = true;
            }
        }
        // bottom
        for (int i=0 ; i< b.length ; i++){
            if (b[i].y  + Block.SIZE == PlayManager.bottom_y){
                bottomCollision = true;
            }
        }

    }
    public void checkRotationCollision(){

        leftCollision =false;
        rightCollision =false;
        bottomCollision =false;

        // check static block collision
        checkStaticBlockCollision();

        // check frame collision
        // left wall

        for (int i=0 ; i< b.length ; i++){
            if (tempB[i].x < PlayManager.left_x){ // left x is greater than temp .x
                leftCollision = true;
            }
        }

        // right wall

        for (int i=0 ; i< b.length ; i++){
            if (tempB[i].x + Block.SIZE > PlayManager.right_x){ // right x is smaller than temp .x
                rightCollision = true;
            }
        }
        // bottom
        for (int i=0 ; i< b.length ; i++){
            if (tempB[i].y  + Block.SIZE > PlayManager.bottom_y){ // bottom y is smaller than temp .y
                bottomCollision = true;
            }
        }

    }

    private void checkStaticBlockCollision(){

        for (int i =0 ; i< PlayManager.staticBlocks.size() ;i++){
            // get each blocks x and y
            int targetX = PlayManager.staticBlocks.get(i).x;
            int targetY = PlayManager.staticBlocks.get(i).y;


        // check down

        for (int j =0 ; j < b.length ; j++){
            if(b[j].y + Block.SIZE == targetY && b[j].x == targetX){
                bottomCollision = true;
            }

        }
        // left
        for (int j =0 ; j<b.length ; j++){
            if(b[j].x - Block.SIZE ==  targetX && b[j].y == targetY){
                leftCollision = true;
            }
        }
        for (int j =0 ; j<b.length ; j++){
            if(b[j].x + Block.SIZE ==  targetX && b[j].y == targetY){
                rightCollision = true;
            }
        }
        }
    }
    public void update(){



        if (deactivating ){
            deactivating();
        }
        // lets control the mino

        if(KeyHandler.upPressed){
            // this is bit tricky because it does rotation

            switch (direction){
                // if current direction is 1 then this order below
                case 1:
                    getDirection2(); break; // mino rotates every times w key is pressed
                case 2:
                    getDirection3();break;
                case 3:
                    getDirection4();break;
                case 4:
                    getDirection1();break;

            }

            KeyHandler.upPressed = false;
            GamePanel.se.play(3,false);

        }

        checkMovementCollision();

        if(KeyHandler.downPressed) {

            if(bottomCollision == false)
            {
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;

                // when move down reset the auto drop counter
            autoDropCounter =0;
// reset
            KeyHandler.downPressed =false;
            }
                                    }
        if(KeyHandler.leftPressed){

            if (leftCollision ==false ){


             b[0].x -= Block.SIZE;
             b[1].x -= Block.SIZE;
             b[2].x -= Block.SIZE;
             b[3].x -= Block.SIZE;

            KeyHandler.leftPressed =false;}
        }
        if(KeyHandler.rightPressed) {

            if (rightCollision == false) {


                b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;

                KeyHandler.rightPressed = false;
            }
        }

        if (bottomCollision){
            if(deactivating == false){
                GamePanel.se.play(4,false);
            }
            deactivating = true;
        }
        else{


        autoDropCounter ++;
        if(autoDropCounter == PlayManager.dropInterval){
            // mino goes doww
            b[0].y +=Block.SIZE;
            b[1].y +=Block.SIZE;
            b[2].y +=Block.SIZE;
            b[3].y +=Block.SIZE;
            autoDropCounter =0;

                                                    }
        }
    }

    private void deactivating() {

        deactivateCounter ++;
        // wait 45 frame until disActive
        if(deactivateCounter ==45){

            deactivateCounter =0;
            checkMovementCollision(); // check if bottom is still hitting

            // if the bottom is still hitting after 45 frame , deactive the mino
            if(bottomCollision){
                active = false;
            }
        }
    }

    public void draw(Graphics2D g2){
           int margin =2;
           g2.setColor(b[0].c);
           g2.fillRect(b[0].x+margin,b[0].y+margin,Block.SIZE-(margin*2), Block.SIZE-(margin*2));
           g2.fillRect(b[1].x+margin,b[1].y+margin,Block.SIZE-(margin*2), Block.SIZE-(margin*2));
           g2.fillRect(b[2].x+margin,b[2].y+margin,Block.SIZE-(margin*2), Block.SIZE-(margin*2));
           g2.fillRect(b[3].x+margin,b[3].y+margin,Block.SIZE-(margin*2), Block.SIZE-(margin*2));
    }
}
