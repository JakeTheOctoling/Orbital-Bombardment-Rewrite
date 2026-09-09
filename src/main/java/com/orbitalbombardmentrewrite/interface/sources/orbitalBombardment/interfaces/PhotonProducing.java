package orbitalBombardment.interfaces;

import cpw.mods.fml.common.network.PacketDispatcher;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: PhotonProducing.class */
public class PhotonProducing extends asp {
    public int powerIncoming;
    public int scaledOutput;
    int chargeRate = 0;
    int currentCharge = 0;
    public long time = 0;
    private int tickCount = 0;
    public float rotate = -3.141f;

    public List<PhotonConsuming> getSurroundingPhotonConsumers() {
        List<PhotonConsuming> surroundingConsumers = new ArrayList<>();
        try {
            if (this.k.r(this.l + 1, this.m, this.n) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l + 1, this.m, this.n));
            }
            if (this.k.r(this.l - 1, this.m, this.n) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l - 1, this.m, this.n));
            }
            if (this.k.r(this.l, this.m + 1, this.n) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l, this.m + 1, this.n));
            }
            if (this.k.r(this.l, this.m - 1, this.n) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l, this.m - 1, this.n));
            }
            if (this.k.r(this.l, this.m, this.n + 1) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l, this.m, this.n + 1));
            }
            if (this.k.r(this.l, this.m, this.n - 1) instanceof PhotonConsuming) {
                surroundingConsumers.add((PhotonConsuming) this.k.r(this.l, this.m, this.n - 1));
            }
        } catch (Exception exception) {
            System.out.println("ORBITAL BOMBARDMENT::Cannot cast entity into PhotonConsuming");
            exception.printStackTrace();
        }
        return surroundingConsumers;
    }

    public void h() {
        int scaledPowerOutput;
        if (getPowerIncoming() > 0) {
            this.rotate += 1.0E-4f * getPowerIncoming();
        }
        if (this.rotate >= 3.141f) {
            this.rotate = -3.141f;
        }
        if (!this.k.I) {
            List<PhotonConsuming> surroundingPhotonConsumers = getSurroundingPhotonConsumers();
            addCharge(getChargeRate());
            int howMany = surroundingPhotonConsumers.size();
            if (howMany == 0) {
                howMany = 1;
                scaledPowerOutput = getCurrentCharge() / 1;
            } else {
                scaledPowerOutput = getCurrentCharge() / howMany;
            }
            if (this.tickCount == 10) {
                sendChangeToClient13();
                sendChangeToClient15();
                this.tickCount = 0;
            } else {
                this.tickCount++;
            }
            setScaledOutput(scaledPowerOutput);
            setPowerIncoming(getCurrentCharge());
            if (scaledPowerOutput > 0) {
                for (PhotonConsuming entity : surroundingPhotonConsumers) {
                    try {
                        if (entity.getCurrentCharge() < entity.getMaxCharge()) {
                            entity.addCharge(scaledPowerOutput);
                        }
                        scaledPowerOutput = getCurrentCharge() / howMany;
                        entity.currentCharge += scaledPowerOutput;
                    } catch (Exception e) {
                    }
                }
                removeCharge(getCurrentCharge());
            }
        }
        this.time = this.k.J();
        this.time %= 24000;
    }

    public void addCharge(int incomingCharge) {
        this.currentCharge += incomingCharge;
    }

    public void removeCharge(int outgoingCharge) {
        this.currentCharge -= outgoingCharge;
    }

    public int getChargeRate() {
        return this.chargeRate;
    }

    public void setChargeRate(int chargeRate) {
        this.chargeRate = chargeRate;
    }

    public int getCurrentCharge() {
        return this.currentCharge;
    }

    public void setCurrentCharge(int currentCharge) {
        this.currentCharge = currentCharge;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getPowerIncoming() {
        return this.powerIncoming;
    }

    public void setPowerIncoming(int powerIncoming) {
        this.powerIncoming = powerIncoming;
    }

    public int getScaledOutput() {
        return this.scaledOutput;
    }

    public void setScaledOutput(int scaledOutput) {
        this.scaledOutput = scaledOutput;
    }

    public void sendChangeToClient13() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(13);
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

    public void sendChangeToClient15() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(15);
            outputStream.writeInt(this.l);
            outputStream.writeInt(this.m);
            outputStream.writeInt(this.n);
            outputStream.writeInt(getPowerIncoming());
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
