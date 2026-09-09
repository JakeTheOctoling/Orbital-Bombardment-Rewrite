package orbitalBombardment.lib;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

/* JADX INFO: loaded from: OBSoundManager.class */
public class OBSoundManager {
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event) {
        event.manager.a("OB".toLowerCase() + ":explode.ogg");
        event.manager.a("OB".toLowerCase() + ":middle.wav");
        event.manager.a("OB".toLowerCase() + ":start.ogg");
        event.manager.a("OB".toLowerCase() + ":startCharging.ogg");
        event.manager.a("OB".toLowerCase() + ":helios.ogg");
        event.manager.a("OB".toLowerCase() + ":booming.ogg");
        event.manager.a("OB".toLowerCase() + ":reentry.ogg");
        event.manager.a("OB".toLowerCase() + ":digging.ogg");
        event.manager.a("OB".toLowerCase() + ":defenderLock.ogg");
        event.manager.a("OB".toLowerCase() + ":satelliteLaunch.ogg");
    }
}
