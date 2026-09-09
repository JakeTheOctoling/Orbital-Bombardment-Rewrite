package orbitalBombardment.lib;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: ModInfo.class */
public class ModInfo {
    public static final String ID = "OB";
    public static final String NAME = "Orbital Bombardment";
    public static final String VERSION = "1.1.1";
    public static final String CHANNEL = "OB";
    public static final String PROXY_LOCATION = "orbitalBombardment.proxies";
    public static long buildDateCal;

    public ModInfo() {
        new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        buildDateCal = new GregorianCalendar(2014, 1, 29).getTimeInMillis();
    }
}
