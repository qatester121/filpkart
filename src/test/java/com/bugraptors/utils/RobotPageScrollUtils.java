package com.bugraptors.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotPageScrollUtils {
    public static void scrollDown(int scrollCount) {
        Robot robot;
        try {
            while (scrollCount > 0) {
                robot = new Robot();
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                scrollCount--;
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void scrollUp(int scrollCount) {
        Robot robot;
        try {
            while (scrollCount > 0) {
                robot = new Robot();
                robot.keyPress(KeyEvent.VK_PAGE_UP);
                robot.keyRelease(KeyEvent.VK_PAGE_UP);
                scrollCount--;
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
