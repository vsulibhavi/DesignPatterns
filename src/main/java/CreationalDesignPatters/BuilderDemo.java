package CreationalDesignPatters;

interface ICar{



}


class Car implements ICar{

    boolean isAuto;
    int noofwheels;
    int tuters;

     Car(boolean isAuto,int noofwheels,int tuters) {

         this.isAuto = isAuto;
         this.noofwheels = noofwheels;
         this.tuters = tuters;
     }

    @Override
    public String toString() {

         return (isAuto + "" + noofwheels +""+ tuters);

     }


    static class Builder{


        boolean isAuto;
        int noofwheels;
        int tuters;

       public Builder(){


        }

        public Car.Builder withWheels(int wheels){

            this.noofwheels = 4;
            return  this;
        }

        public Car.Builder isAuto(boolean isAuto){

            this.isAuto = isAuto;
            return  this;
        }

        public Car.Builder witNoOfTutors(int tuters){

            this.tuters = tuters;
            return  this;
        }

        public ICar build(){

           return new Car(isAuto,noofwheels,tuters);
        }

    }




}


public class BuilderDemo {



    public static void main(String[] args){

    ICar car =   new  Car.Builder().withWheels(4).witNoOfTutors(4).isAuto(true).build();

    System.out.println(car);

    }

}
