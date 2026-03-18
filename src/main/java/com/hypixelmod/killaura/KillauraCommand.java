package com.hypixelmod.killaura;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KillauraCommand {

    @SubscribeEvent
    public void onChatMessage(ClientChatEvent event) {
        String msg = event.message;

        if (msg.startsWith(".killaura ")) {
            event.setCanceled(true);
            String[] args = msg.split(" ");
            if (args.length < 2) return;

            String sub = args[1].toLowerCase();
            switch (sub) {
                case "on": Settings.killauraEnabled = true; break;
                case "off": Settings.killauraEnabled = false; break;
                case "autoblock": 
                    if (args.length > 2) Settings.autoblock = args[2].equalsIgnoreCase("on");
                    break;
                case "setcps":
                    if (args.length > 2) Settings.cps = Integer.parseInt(args[2]);
                    break;
                case "setreach":
                    if (args.length > 2) Settings.reach = Double.parseDouble(args[2]);
                    break;
                case "help":
                    sendMsg(".killaura on/off, setreach, setcps, autoblock on/off");
                    return;
            }
            sendMsg("Updated: " + sub);
        }
    }

    private void sendMsg(String text) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[Mod] " + text));
    }
                                                          }
