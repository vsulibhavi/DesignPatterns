package abstractFactory;

interface Cpu {

    public String getName();
}

interface Gpu{

    public String getName();
}

class IntelCpu implements Cpu {


    public String getName() {
        return "intelCpu";
    }
}

class AmdCpu implements Cpu {

    public String getName() {
        return "amdCpu";
    }
}
class IntelGpu implements Gpu{


    public String getName() {
        return "intelgpu";
    }
}
class AmdGpu implements Gpu{


    public String getName() {
        return "amdgpu";
    }
}

class IntelFactory extends AbstractFactory{

    @Override
    public Cpu getCpu() {
        return new IntelCpu();
    }

    @Override
    public Gpu getGpu() {
        return new IntelGpu();
    }
}

class AmdFactory extends AbstractFactory{

    @Override
    public Cpu getCpu() {
        return new AmdCpu();
    }

    @Override
    public Gpu getGpu() {
        return new AmdGpu();
    }
}
abstract class AbstractFactory {


    enum COMPANY {INTEL, AMD}

    public static AbstractFactory getFactory(COMPANY company) {

        switch (company) {

            case AMD:
                return new AmdFactory();


            case INTEL:
                return new IntelFactory();


        }

        return  null;
    }

    abstract Cpu getCpu();
    abstract Gpu getGpu();


}


public class Main
{
    public static void main(String[] args){

        AbstractFactory abstractFactory = AbstractFactory.getFactory(AbstractFactory.COMPANY.AMD);

       System.out.println(abstractFactory.getGpu().getName());
    }
}