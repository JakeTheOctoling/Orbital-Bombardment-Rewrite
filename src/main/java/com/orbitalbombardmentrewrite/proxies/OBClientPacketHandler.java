package com.orbitalbombardmentrewrite.proxies;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import orbitalBombardment.blocks.ChargeBlockTileEntity;
import orbitalBombardment.blocks.ExtenderTileEntity;
import orbitalBombardment.interfaces.PhotonRecieving;
import orbitalBombardment.interfaces.PhotonSending;

/* JADX INFO: loaded from: OBClientPacketHandler.class */
public class OBClientPacketHandler implements IPacketHandler {
    int x;
    int y;
    int z;
    int charge;
    int function;

    public void onPacketData(cm manager, ea packet, Player player) {
        if (packet.a.equals("OB")) {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.c));
            try {
                this.function = inputStream.readInt();
                this.x = inputStream.readInt();
                this.y = inputStream.readInt();
                this.z = inputStream.readInt();
                this.charge = inputStream.readInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (this.function == 1) {
                    bdi playerMP = (bdi) player;
                    ChargeBlockTileEntity te = playerMP.q.r(this.x, this.y, this.z);
                    if (te != null && (te instanceof ChargeBlockTileEntity)) {
                        te.currentCharge = this.charge;
                    }
                }
                if (this.function == 3) {
                    bdi playerMP3 = (bdi) player;
                    ExtenderTileEntity ext = playerMP3.q.r(this.x, this.y, this.z);
                    if (ext instanceof ExtenderTileEntity) {
                        ext.currentCharge = this.charge;
                    }
                }
                if (this.function == 5) {
                    bdi playerMP5 = (bdi) player;
                    ChargeBlockTileEntity ext2 = playerMP5.q.r(this.x, this.y, this.z);
                    if (ext2 instanceof ChargeBlockTileEntity) {
                        ext2.shotsLeft = this.charge;
                    }
                }
                if (this.function == 7) {
                    bdi playerMP6 = (bdi) player;
                    PhotonSending ext3 = playerMP6.q.r(this.x, this.y, this.z);
                    if (ext3 instanceof PhotonSending) {
                        ext3.setOutputRate(this.charge);
                    }
                }
                if (this.function == 9) {
                    bdi playerMP7 = (bdi) player;
                    PhotonSending ext4 = playerMP7.q.r(this.x, this.y, this.z);
                    if (ext4 instanceof PhotonSending) {
                        ext4.setScaledOutput(this.charge);
                    }
                }
                if (this.function == 11) {
                    bdi playerMP8 = (bdi) player;
                    PhotonSending ext5 = playerMP8.q.r(this.x, this.y, this.z);
                    if (ext5 instanceof PhotonSending) {
                        ext5.setListSize(this.charge);
                    }
                }
                if (this.function == 13) {
                    bdi playerMP9 = (bdi) player;
                    PhotonRecieving ext6 = playerMP9.q.r(this.x, this.y, this.z);
                    if (ext6 instanceof PhotonRecieving) {
                        ext6.setScaledOutput(this.charge);
                    }
                }
                if (this.function == 15) {
                    bdi playerMP10 = (bdi) player;
                    PhotonRecieving ext7 = playerMP10.q.r(this.x, this.y, this.z);
                    if (ext7 instanceof PhotonRecieving) {
                        ext7.setPowerIncoming(this.charge);
                    }
                }
                if (this.function == 17) {
                    bdi playerMP11 = (bdi) player;
                    PhotonRecieving ext8 = playerMP11.q.r(this.x, this.y, this.z);
                    if (ext8 instanceof PhotonRecieving) {
                        ext8.setCurrentCharge(this.charge);
                    }
                }
                if (this.function == 19) {
                    bdi playerMP12 = (bdi) player;
                    playerMP12.q.a(this.x, this.y, this.z, "ob:defenderLock", 1.0f, 1.0f);
                }
            } catch (Exception e2) {
            }
        }
    }
}
