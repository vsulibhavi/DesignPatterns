package StruturalDesignPatternDemo;

interface Shape{

    public void draw();
    public void resize(int percentage);

}

interface IDrawApi {

    public void draw();

}

class DrawCircleApi1 implements IDrawApi {

    @Override
    public void draw() {

        System.out.println("Drawing Circle using api 1");
    }
}

class DrawCircleApi2 implements IDrawApi {

    @Override
    public void draw() {

        System.out.println("Drawing Circle using api 2");
    }
}

abstract class AbstractShape implements  Shape{

    IDrawApi iDrawCApi;

    AbstractShape(IDrawApi iDrawCircleApi){

        this.iDrawCApi = iDrawCircleApi;
    }





}

class CircleShape extends AbstractShape{

    int x,y,radius;


    CircleShape(int x,int y,int radius, IDrawApi iDrawCircleApi){

        super(iDrawCircleApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {

        iDrawCApi.draw();
    }

    @Override
    public void resize(int percentage) {

        radius *= 1.0 + percentage/(float)100;

    }
}


public class BridgePatternDemo {

   public static void main(String[] args) {

       Shape shape1 = new CircleShape(10, 20, 100, new DrawCircleApi1());
        shape1.draw();
        shape1.resize(50);

   }
}
