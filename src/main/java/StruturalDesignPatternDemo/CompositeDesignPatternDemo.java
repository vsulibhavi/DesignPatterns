package StruturalDesignPatternDemo;

import java.util.ArrayList;
import java.util.List;

interface Graphic {

    public void print();
}

class CompositeGraphic implements Graphic{

    List<Graphic> graphicList = new ArrayList<Graphic>();

    public void add(Graphic graphic){

        graphicList.add(graphic);
    }

    public void delete(Graphic graphic)
    {
        graphicList.remove(graphic);

    }

    @Override
    public void print() {

        graphicList.forEach(graphic -> {graphic.print();});

    }
}

class Eclipse implements Graphic{

    @Override
    public void print() {
        System.out.println("Eclipse");
    }
}

public class CompositeDesignPatternDemo {

    public static void main(String[] args){

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(new Eclipse());
        compositeGraphic.add(new Eclipse());
        compositeGraphic.add(new Eclipse());

        compositeGraphic.print();
    }

}
