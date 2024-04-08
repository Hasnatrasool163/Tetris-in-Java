package mino;

import java.awt.*;

public class Mino_L2 extends Mino{

    public Mino_L2(){
            create(Color.BLUE);

    }

    public void setXY(int x , int y){

        //     o
        //     o
        //  o  o

        b[0].x= x;
        b[0].y= y;
        b[1].x= b[0].x;
        b[1].y= b[0].y - Block.SIZE;
        b[2].x= b[0].x;
        b[2].y= b[0].y + Block.SIZE;
        b[3].x= b[0].x - Block.SIZE;
        b[3].y= b[0].y + Block.SIZE;

    }


    public void getDirection1(){ // default direction

        //     o
        //     o
        //  o  o
        // use 4 blocks

        tempB[0].x= b[0].x;
        tempB[0].y= b[0].y;
        tempB[1].x= b[0].x;
        tempB[1].y= b[0].y - Block.SIZE;
        tempB[2].x= b[0].x;
        tempB[2].y= b[0].y + Block.SIZE;
        tempB[3].x= b[0].x - Block.SIZE;
        tempB[3].y= b[0].y + Block.SIZE;

        updateXY(1);

    }public void getDirection2(){

        // o
        // o o o

        tempB[0].x= b[0].x;
        tempB[0].y= b[0].y;
        tempB[1].x= b[0].x + Block.SIZE;
        tempB[1].y= b[0].y ;
        tempB[2].x= b[0].x - Block.SIZE;
        tempB[2].y= b[0].y ;
        tempB[3].x= b[0].x - Block.SIZE;
        tempB[3].y= b[0].y - Block.SIZE;


        updateXY(2);


    }public void getDirection3(){

        // o o
        // o
        // o

        tempB[0].x= b[0].x;
        tempB[0].y= b[0].y;
        tempB[1].x= b[0].x ;
        tempB[1].y= b[0].y + Block.SIZE;
        tempB[2].x= b[0].x ;
        tempB[2].y= b[0].y - Block.SIZE;
        tempB[3].x= b[0].x + Block.SIZE;
        tempB[3].y= b[0].y - Block.SIZE;

        updateXY(3);

    }public void getDirection4(){


        // o  o  o
        //       o
       //

        tempB[0].x= b[0].x;
        tempB[0].y= b[0].y;
        tempB[1].x= b[0].x - Block.SIZE;
        tempB[1].y= b[0].y ;
        tempB[2].x= b[0].x + Block.SIZE;
        tempB[2].y= b[0].y ;
        tempB[3].x= b[0].x + Block.SIZE;
        tempB[3].y= b[0].y + Block.SIZE;

        updateXY(4);
    }

}
