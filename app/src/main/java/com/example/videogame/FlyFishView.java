package com.example.videogame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class FlyFishView extends View {

    //Fish.................................................................
    private Bitmap Fish[] =new Bitmap[2];
    private  int fishx=10;
    private  int fishy;
    private int fishspeed;
    private int canvasWidth, canvasHeight;
    // ball..........................................................
    private   int yellowx,yellowy,Yellowspeed=11;
    private Paint yellowpaint =new Paint();

    private   int greenx,greeny,greenspeed=20;
    private Paint greenpaint =new Paint();

    private   int redx,redy,redspeed=30;
    private Paint redpaint =new Paint();

    // score........................................
    private int score , lifeoffish;
    private Paint scorepoint=new Paint();
//touch...................................................

    private boolean touch=false;
    private Bitmap backeroudImage;


    private Bitmap life[]=new Bitmap[2];





    public FlyFishView(Context context) {
        super(context);

        // Fish..............................................................................................
        Fish[0]= BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
        Fish[1]= BitmapFactory.decodeResource(getResources(),R.drawable.fish2);
        backeroudImage= BitmapFactory.decodeResource(getResources(),R.drawable.background);
        //score..............................................................................................
        scorepoint.setColor(Color.WHITE);
        scorepoint.setTextSize(70);
        scorepoint.setTypeface(Typeface.DEFAULT_BOLD);
        scorepoint.setAntiAlias(true);
        //Yellow and Green ball.............................  .................................................


        yellowpaint.setColor(Color.YELLOW);
        yellowpaint.setAntiAlias(false);

        greenpaint.setColor(Color.GREEN);
        greenpaint.setAntiAlias(false);


        redpaint.setColor(Color.RED);
        redpaint.setAntiAlias(false);


//Life..............................................................................
        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);
        fishy=550;

        score=0;
        lifeoffish=3;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth =  canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backeroudImage,0,0,null);

// fish..............Events...............................

        int minFishy =Fish[0].getHeight();
        int maxFishy =canvasHeight - Fish[0].getHeight() * 3;
        fishy =fishy + fishspeed;

        if (fishy < minFishy){
            fishy = minFishy;

        }


        if(fishy > maxFishy){
            fishy = maxFishy;
        }

        fishspeed= fishspeed + 2;

        // touch..........................................................
        if(touch){

            canvas.drawBitmap(Fish[1],fishx,fishy,null);
            touch=false;
        }else {
            canvas.drawBitmap(Fish[0],fishx,fishy,null);


        }

//ball........................... events...............................................
//yellow....................
        yellowx =yellowx - Yellowspeed;
        if (hitballcheck(yellowx,yellowy)){

            score=score+10;
            yellowx= yellowx -100;

        }

        if(yellowx<0){
            yellowx =canvasWidth+21;
            yellowy=(int)Math.floor(Math.random()*(maxFishy - minFishy))+ minFishy;
        }
        canvas.drawCircle(yellowx,yellowy,25,yellowpaint);

        //green..........

        greenx =greenx-greenspeed;
        if (hitballcheck(greenx,greeny)){

            score=score+20;
            greenx= greenx - 100;

        }

        if(greenx<0){
            greenx =canvasWidth + 21;
            greeny=(int)Math.floor(Math.random()*(maxFishy - minFishy))+minFishy;
        }
        canvas.drawCircle(greenx,greeny,25,greenpaint);
        //red............................


        redx = redx - redspeed;
        if (hitballcheck(redx,redy)){

            redx=redx  - 100;
            lifeoffish--;

            if(lifeoffish==0){
                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();


                Intent move=new Intent(getContext(),GameOver.class);
                move.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                move.putExtra("score",score);

                getContext().startActivity(move);


            }

        }

        if(redx<0){
            redx =canvasWidth+21;
            redy=(int)Math.floor(Math.random()*(maxFishy - minFishy))+minFishy;
        }
        canvas.drawCircle(redx,redy,30,redpaint);

// score and life..................................................................


        if(score>=100){


            Toast.makeText(getContext(), "Takecare", Toast.LENGTH_SHORT).show();


            Intent mov=new Intent(getContext(),NewLevel.class);
            mov.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            mov.putExtra("score",score);

            getContext().startActivity(mov);

            greenspeed=greenspeed+8;
            Yellowspeed=Yellowspeed+8;
            redspeed=redspeed+9;
            fishspeed=fishspeed+4;




        }



















        canvas.drawText("Score:"+score,20,60,scorepoint);



        for(int i=0; i <3; i++){

            int x=(int)(580 + life[0].getWidth()* 1.5 * i);
            int y=30;

            if(i<lifeoffish){
                canvas.drawBitmap(life[0],x,y,null);

            }else {
                canvas.drawBitmap(life[1],x,y,null);
            }

        }






    }

    //hit ball....................................
    public boolean hitballcheck(int x,int y){


        if (fishx < x && x<(fishx+Fish[0].getWidth())&& fishy < y && y<(fishy+Fish[0].getHeight()) ){


            return  true;


        }

        return false;

    }


//touch............................................................................

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()== MotionEvent.ACTION_DOWN){


            touch = true;
            fishspeed=-22;

        }
        return true;

    }
}
