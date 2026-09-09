package orbitalBombardment.lib;

import cpw.mods.fml.common.FMLLog;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: LogHelper.class */
public class LogHelper {
    private static Logger logger = Logger.getLogger(ModInfo.NAME);

    public static void init() {
        logger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {
        logger.log(logLevel, message);
    }
}
