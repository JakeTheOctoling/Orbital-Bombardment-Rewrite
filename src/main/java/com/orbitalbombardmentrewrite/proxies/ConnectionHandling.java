package com.orbitalbombardmentrewrite.proxies;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import net.minecraft.server.MinecraftServer;
import orbitalBombardment.lib.ModInfo;

/* JADX INFO: loaded from: ConnectionHandling.class */
public class ConnectionHandling implements IConnectionHandler {
    public boolean checkUpdate;

    public void playerLoggedIn(Player player, ez netHandler, cm manager) {
        Calendar today = new GregorianCalendar(new Date().getYear(), new Date().getMonth() - 1, new Date().getDay());
        long milliToday = today.getTimeInMillis();
        long milliBuild = ModInfo.buildDateCal;
        if (milliToday > milliBuild) {
            this.checkUpdate = true;
        } else {
            this.checkUpdate = false;
        }
        if (this.checkUpdate) {
            netHandler.getPlayer().a(cv.d("[" + a.m + "ORBITAL BOMBARDMENT 1.1.1: " + a.v + "] The build you are using is more than a month old and may contain bugs that were fixed in newer versions. Please check SourceForge for new updates!!"));
        }
    }

    public String connectionReceived(jy netHandler, cm manager) {
        return null;
    }

    public void connectionOpened(ez netClientHandler, String server, int port, cm manager) {
    }

    public void connectionOpened(ez netClientHandler, MinecraftServer server, cm manager) {
    }

    public void connectionClosed(cm manager) {
    }

    public void clientLoggedIn(ez clientHandler, cm manager, ep login) {
    }
}
