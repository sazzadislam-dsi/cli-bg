package org.ni.rpg;

import org.ni.rpg.entity.Frame;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by nazmul on 9/28/2018.
 */
public class Main {
    public static void main(String [] args) throws FrameSizeOutOfBound {
        System.out.println("----------------------");
        Frame helloWorld = new Frame(20,20);
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        helloWorld.drawMiddle("Hello World");
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        helloWorld.drawBorder();
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        helloWorld.drawBorder('.','.');
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        Character[][] ch = { {'x','x'},{'x','x','x','x'} };
        helloWorld.clean();
        helloWorld.drawMiddle(ch);
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        helloWorld.clean();
        helloWorld.drawAtPosition(1,1,ch);
        System.out.println(helloWorld.getFrameForPrint());
        System.out.println("----------------------");
        helloWorld.clean();
        helloWorld.drawMiddle("Hello World");
        helloWorld.drawBorder('.','.');
        Frame greeting = new Frame(10,10);
        greeting.drawMiddle("Greeting");
        greeting.drawBorder('.','.');
        Frame main = new Frame(30,30);
        Stream<Frame> stringStream = Stream.of(helloWorld,greeting);
        main.drawMiddle(stringStream.toArray(Frame[]::new));
        System.out.println(main.getFrameForPrint());
        System.out.println("----------------------");


    }
}
