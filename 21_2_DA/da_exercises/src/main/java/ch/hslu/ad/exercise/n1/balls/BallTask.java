package ch.hslu.ad.exercise.n1.balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallTask implements Runnable{
    @Override
    public void run() {
        var random = new Random();
        List<String> colors = new ArrayList<String>(){
            {
                add("red");
                add("black");
                add("blue");
                add("yellow");
                add("green");
                add("magenta");
            }
        };

        var ball = new Circle(
                random.nextInt(60) + 40,
                random.nextInt(400),
                90,
                colors.get(random.nextInt(colors.size()))
        );
        ball.makeVisible();

        var speed = random.nextInt(30) + 10;

        while (ball.getY() < Canvas.getCanvas().getHeight()){
            ball.slowMoveVertical(1);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ball.makeInvisible();
    }
}
