package utils.impl;

import utils.Delay;

//Delay - a class for holding output messages
public class DelayImpl implements Delay {
    @Override
    public void delay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
