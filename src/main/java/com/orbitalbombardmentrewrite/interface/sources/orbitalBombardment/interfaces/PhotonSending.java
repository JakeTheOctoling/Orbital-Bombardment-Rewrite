package orbitalBombardment.interfaces;

import cpw.mods.fml.common.network.PacketDispatcher;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import orbitalBombardment.lib.OBConstants;

/* JADX INFO: loaded from: PhotonSending.class */
public class PhotonSending extends PhotonConsuming {
    public int outputRate;
    public int listSize;
    public int scaledOutput;
    private int tickCount = 0;
    public float rotate = -3.141f;

    public List<PhotonRecieving> getNearbyPhotonRecievingEntities() {
        int radius = OBConstants.PhotonSendingRadius;
        List<PhotonRecieving> entities = new ArrayList<>();
        int xC = this.l;
        int yC = this.m;
        int zC = this.n;
        for (int x = (radius / 2) * (-1); x <= radius / 2; x++) {
            for (int y = (radius / 2) * (-1); y <= radius / 2; y++) {
                for (int z = (radius / 2) * (-1); z <= radius / 2; z++) {
                    if ((this.k.r(xC + x, yC + y, zC + z) instanceof PhotonRecieving) && entities.size() <= 3) {
                        entities.add((PhotonRecieving) this.k.r(xC + x, yC + y, zC + z));
                    }
                }
            }
        }
        return entities;
    }

    public void sendPhotonsTo(PhotonRecieving entity, int power) {
        PhotonRecieving photonRecievingEntity = (PhotonRecieving) this.k.r(entity.l, entity.m, entity.n);
        if (photonRecievingEntity != null) {
            photonRecievingEntity.recievePhotons(power);
        }
    }

    public void h() {
        this.rotate += 0.01f;
        if (this.rotate >= 3.141f) {
            this.rotate = -3.141f;
        }
        if (!this.k.I) {
            List<PhotonRecieving> entitiesForPowerRecieving = getNearbyPhotonRecievingEntities();
            int scaledPowerOutput = 0;
            int howMany = entitiesForPowerRecieving.size();
            if (howMany != 0) {
                scaledPowerOutput = getCurrentCharge() / howMany;
            } else {
                this.scaledOutput = getCurrentCharge();
            }
            if (entitiesForPowerRecieving.size() > 0 && getCurrentCharge() > 0) {
                for (PhotonRecieving entity : entitiesForPowerRecieving) {
                    sendPhotonsTo(entity, scaledPowerOutput);
                }
            }
            setScaledOutput(scaledPowerOutput);
            setOutputRate(scaledPowerOutput * howMany);
            setListSize(howMany);
            if (this.tickCount == 10) {
                sendChangeToClient7();
                sendChangeToClient9();
                sendChangeToClient11();
                this.tickCount = 0;
            } else {
                this.tickCount++;
            }
            setCurrentCharge(getCurrentCharge() - (scaledPowerOutput * howMany));
        }
    }

    public int getOutputRate() {
        return this.outputRate;
    }

    public void setOutputRate(int outputRate) {
        this.outputRate = outputRate;
    }

    public int getListSize() {
        return this.listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getScaledOutput() {
        return this.scaledOutput;
    }

    public void setScaledOutput(int scaledOutput) {
        this.scaledOutput = scaledOutput;
    }

    public void sendChangeToClient7() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(7);
            outputStream.writeInt(this.l);
            outputStream.writeInt(this.m);
            outputStream.writeInt(this.n);
            outputStream.writeInt(getOutputRate());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ea packet = new ea();
        packet.a = "OB";
        packet.c = bos.toByteArray();
        packet.b = bos.size();
        PacketDispatcher.sendPacketToAllPlayers(packet);
    }

    public void sendChangeToClient9() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(9);
            outputStream.writeInt(this.l);
            outputStream.writeInt(this.m);
            outputStream.writeInt(this.n);
            outputStream.writeInt(getScaledOutput());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ea packet = new ea();
        packet.a = "OB";
        packet.c = bos.toByteArray();
        packet.b = bos.size();
        PacketDispatcher.sendPacketToAllPlayers(packet);
    }

    public void sendChangeToClient11() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(11);
            outputStream.writeInt(this.l);
            outputStream.writeInt(this.m);
            outputStream.writeInt(this.n);
            outputStream.writeInt(getListSize());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ea packet = new ea();
        packet.a = "OB";
        packet.c = bos.toByteArray();
        packet.b = bos.size();
        PacketDispatcher.sendPacketToAllPlayers(packet);
    }
}
