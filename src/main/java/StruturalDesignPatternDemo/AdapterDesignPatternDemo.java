package StruturalDesignPatternDemo;


interface TwoHoleSwitchAdapter {


   public void run();

}

interface ThreePinDevice{

    public void highVoltageRun();

}

class ThreePinMixer implements ThreePinDevice {


    public void highVoltageRun(){


        System.out.println("rrrr rrrrrr rrrrr rrrr");
    }

}

interface TwoPinDevice {

    public void lowVoltRun();
}

class TwoPinTv implements TwoPinDevice {

    @Override
    public void lowVoltRun(){

        System.out.println("sony tv");

    }


}

class TwoHoleSwitchAdapterThreePinAdaptee implements TwoHoleSwitchAdapter {


    ThreePinDevice threePinDevice;
    TwoHoleSwitchAdapterThreePinAdaptee(ThreePinDevice threePinDevice){

        this.threePinDevice = threePinDevice;
    }

    @Override
    public void run() {

        threePinDevice.highVoltageRun();

    }
}

class TwoHoleSwitchAdapterTwoPinAdaptee implements TwoHoleSwitchAdapter {

    TwoPinDevice twoPinDevice;

    TwoHoleSwitchAdapterTwoPinAdaptee(TwoPinDevice twoPinDevice){

        this.twoPinDevice  = twoPinDevice;
    }


    @Override
    public void run() {

        twoPinDevice.lowVoltRun();
    }
}

public class AdapterDesignPatternDemo {

    public static void main(String[] args){

        TwoPinDevice twoPinDevice = new TwoPinTv();
        ThreePinDevice threePinDevice = new ThreePinMixer();

        TwoHoleSwitchAdapter[] twoHoleSwitchAdapters = new TwoHoleSwitchAdapter[]{
                new TwoHoleSwitchAdapterThreePinAdaptee(threePinDevice),new TwoHoleSwitchAdapterTwoPinAdaptee(twoPinDevice)};


        for (TwoHoleSwitchAdapter twoHoleSwitchAdapter:
             twoHoleSwitchAdapters) {

            twoHoleSwitchAdapter.run();
        }

    }
}
