package org.ni.rpg;

import org.ni.rpg.entity.Frame;

/**
 * Created by nazmul on 9/28/2018.
 */
public class Main {
    public static void main(String [] args)
    {
        Frame frame = new Frame();
        frame.drawMiddle("Hello World");
        System.out.println(frame.getFrameForPrint());
        frame.drawBorder();
        System.out.println(frame.getFrameForPrint());
    }
}
