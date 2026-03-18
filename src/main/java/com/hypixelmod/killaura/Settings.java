package com.hypixelmod.killaura;

import org.lwjgl.input.Keyboard;

public class Settings {
    public static boolean killauraEnabled = false;
    public static boolean autoblock = false;
    public static double reach = 3.8;
    public static int cps = 12;
    public static int toggleKey = Keyboard.KEY_R;

    public static void toggle() {
        killauraEnabled = !killauraEnabled;
    }
}
