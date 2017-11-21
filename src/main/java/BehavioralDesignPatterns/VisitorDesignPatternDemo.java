package BehavioralDesignPatterns;

interface Expression{


    public void accept(IExpressionPrinter expressionPrinter);
}

class Literal implements Expression{

    Literal(double value){

        this.value = value;

    }

    double value;

    public void accept(IExpressionPrinter expressionPrinter){

        expressionPrinter.visit(this);
    }

}

class Addition implements Expression{

    public Expression left;
    public Expression right;

    Addition(Expression left,Expression right){

        this.right = right;
        this.left = left;
    }


    @Override
    public void accept(IExpressionPrinter expressionPrinter) {

        expressionPrinter.visit(this);
    }
}
interface IExpressionPrinter{

    public void visit(Addition additionExpression);
    public void visit(Literal literalExpression);

}

class ExpressionPrinter implements IExpressionPrinter{

    StringBuilder sb;

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public void visit(Literal expr){

        sb.append(expr.value);
    }

    public void visit(Addition expr){

        sb.append("(");
        expr.left.accept(this);
        sb.append("+");
        expr.right.accept(this);
        sb.append(")");

    }

    public void print(){

        System.out.println(sb.toString());
    }

}



public class VisitorDesignPatternDemo {

    public static void main(String[] args) {


        Addition add = new Addition(new Addition(new Literal(3), new Literal((4))), new Literal(5));
        ExpressionPrinter expressionPrinter = new ExpressionPrinter();
        expressionPrinter.setSb(new StringBuilder());
        expressionPrinter.visit(add);
        expressionPrinter.print();
    }

}
