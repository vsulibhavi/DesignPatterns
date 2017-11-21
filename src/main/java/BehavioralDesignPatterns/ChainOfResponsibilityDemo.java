package BehavioralDesignPatterns;

abstract class PurchasingPower
{
    public static final Integer BASE = 10000;
    PurchasingPower successor;

    public void setSuccessor(PurchasingPower  successor){

        this.successor = successor;
    }

    public  abstract Double getEligible();

    public abstract String getRole();


    public void processRequest(int amount){

        if(amount < this.getEligible()){

            System.out.println(this.getRole() + "approves is below the eligible amount " + this.getEligible() +"hence approves");


        }else if(successor != null)
            successor.processRequest(amount);

    }



}

class EmployeePurchasingPower extends PurchasingPower{

    @Override
    public Double getEligible() {
        return BASE * 1.0;
    }

    @Override
    public String getRole() {
        return "Employee";
    }

}

 class ManagerPurchasingPower extends PurchasingPower{

    @Override
    public Double getEligible() {
        return BASE * 1.3;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

}

class ExecutivePurchasingPower  extends PurchasingPower{

    @Override
    public Double getEligible() {
        return BASE * 1.6;
    }

    @Override
    public String getRole() {
        return "Executive";
    }

}


public class ChainOfResponsibilityDemo {


    public static void main(String[] args) {

        PurchasingPower employeePurchasingPower = new EmployeePurchasingPower();
        ManagerPurchasingPower managerPurchasingPower = new ManagerPurchasingPower();
        ExecutivePurchasingPower executivePurchasingPower = new ExecutivePurchasingPower();


        employeePurchasingPower.setSuccessor(managerPurchasingPower);
        managerPurchasingPower.setSuccessor(executivePurchasingPower);


        employeePurchasingPower.processRequest(15000);



    }

}
