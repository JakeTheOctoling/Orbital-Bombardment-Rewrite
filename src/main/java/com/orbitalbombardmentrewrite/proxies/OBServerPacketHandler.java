package com.orbitalbombardmentrewrite.proxies;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import orbitalBombardment.blocks.ChargeBlockTileEntity;
import orbitalBombardment.entities.MeteorEntity;
import orbitalBombardment.lib.OBConstants;

/* JADX INFO: loaded from: OBServerPacketHandler.class */
public class OBServerPacketHandler implements IPacketHandler {
    int function;

    public void onPacketData(cm manager, ea packet, Player player) {
        if (packet.a.equals("OB")) {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.c));
            uf sender = (uf) player;
            try {
                this.function = inputStream.readInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (this.function == 2) {
                    int x = inputStream.readInt();
                    int y = inputStream.readInt();
                    int z = inputStream.readInt();
                    int charge = inputStream.readInt();
                    jv playerMP = (jv) player;
                    try {
                        List e2 = playerMP.q.a(og.class, asx.a(x - (charge / 3), y - (charge / 3), z - (charge / 3), x + (charge / 3), y + (charge / 3), z + (charge / 3)));
                        if (e2.size() > 0) {
                            for (int i = 0; i <= e2.size() - 1; i++) {
                                Random random = new Random();
                                og em = (og) e2.get(i);
                                em.g(0.5f);
                                em.y = charge / 5;
                                em.x = random.nextGaussian() * 5.0d;
                                em.z = random.nextGaussian() * 5.0d;
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (charge <= 10) {
                        playerMP.q.a(playerMP, "ob:explode", 0.2f, 5.0f);
                    }
                    if (charge > 10 && charge <= 40) {
                        playerMP.q.a(playerMP, "ob:explode", 0.3f, 1.5f);
                    }
                    if (charge > 40) {
                        playerMP.q.a(playerMP, "ob:explode", 0.4f, 0.8f);
                    }
                    playerMP.q.a((nn) null, x, y, z, charge, true);
                }
                if (this.function == 5 && packet != null) {
                    final int fx = inputStream.readInt();
                    final int fy = inputStream.readInt();
                    final int fz = inputStream.readInt();
                    final Random random2 = new Random();
                    final jv playerMP2 = (jv) player;
                    Thread buildThread = new Thread() { // from class: com.orbitalbombardmentrewrite.proxies.OBServerPacketHandler.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Thread.sleep(random2.nextInt(2000));
                                playerMP2.q.a(playerMP2, "ob:reentry", 5.0f, 1.0f);
                                playerMP2.q.a(playerMP2, "ob:booming", 8.0f, 2.0f);
                                playerMP2.q.d(new MeteorEntity(playerMP2.q, fx, fy, fz));
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                    };
                    buildThread.start();
                }
                if (this.function == 9) {
                    int fx2 = inputStream.readInt();
                    int fy2 = inputStream.readInt();
                    int fz2 = inputStream.readInt();
                    jv playerMP3 = (jv) player;
                    playerMP3.q.d(new sp(playerMP3.q, fx2, fy2, fz2));
                }
                if (this.function == 12) {
                    synchronized (sender) {
                        int par4 = inputStream.readInt();
                        int par5 = inputStream.readInt();
                        int par6 = inputStream.readInt();
                        jv playerMP4 = (jv) player;
                        abw par3World = playerMP4.q;
                        inputStream.readInt();
                        int next = par5 + 1;
                        par3World.a(playerMP4, "ob:digging", 0.7f, 0.8f);
                        do {
                            next--;
                            try {
                                int id = par3World.a(par4, next, par6);
                                aqz found = aqz.s[id];
                                ye itemBlock = new ye(found);
                                new Random();
                                ss droppedItem = new ss(par3World, par4, par5, par6, itemBlock);
                                Random ran = new Random();
                                droppedItem.x = ran.nextGaussian() / 10.0d;
                                droppedItem.y = 0.8d;
                                droppedItem.z = ran.nextGaussian() / 10.0d;
                                par3World.d(droppedItem);
                                par3World.i(par4, next, par6);
                                Thread.sleep(5L);
                            } catch (NullPointerException e4) {
                            } catch (ConcurrentModificationException e5) {
                            } catch (Exception e6) {
                            }
                            if (par3World.a(par4, next - 1, par6) == aqz.E.cF || par3World.a(par4, next - 1, par6) == aqz.H.cF || par3World.a(par4, next - 1, par6) == aqz.I.cF || par3World.a(par4, next - 1, par6) == aqz.F.cF) {
                                break;
                            }
                        } while (par3World.a(par4, next - 1, par6) != aqz.G.cF);
                        par3World.i(par4, par5 + 1, par6);
                    }
                }
                if (this.function == 15) {
                    int fx3 = inputStream.readInt();
                    int fy3 = inputStream.readInt();
                    int fz3 = inputStream.readInt();
                    int charge2 = inputStream.readInt();
                    ChargeBlockTileEntity chargeblock = ((jv) player).q.r(fx3, fy3, fz3);
                    chargeblock.currentCharge -= charge2;
                    chargeblock.shotsLeft--;
                }
                if (this.function == 18) {
                    int fx4 = inputStream.readInt();
                    int fy4 = inputStream.readInt();
                    int fz4 = inputStream.readInt();
                    int charge3 = inputStream.readInt();
                    jv playerMP5 = (jv) player;
                    playerMP5.q.a(playerMP5, "ob:satelliteLaunch", 1.0f, 1.0f);
                    ChargeBlockTileEntity chargeblock2 = playerMP5.q.r(fx4, fy4, fz4);
                    chargeblock2.shotsLeft += charge3;
                    chargeblock2.currentCharge -= OBConstants.SateliteLaunchPUCost;
                    sendChangeToClient(fx4, fy4, fz4, charge3);
                }
                if (this.function == 21) {
                    int fx5 = inputStream.readInt();
                    int fy5 = inputStream.readInt();
                    int fz5 = inputStream.readInt();
                    inputStream.readInt();
                    jv playerMP6 = (jv) player;
                    playerMP6.q.s(fx5, fy5, fz5);
                    playerMP6.q.i(fx5, fy5, fz5);
                }
                if (this.function == 24) {
                    jv playerMP7 = (jv) player;
                    playerMP7.q.a(playerMP7, "ob:start", 1.0f, 1.0f);
                    playerMP7.q.a(playerMP7, "ob:middle", 1.0f, 0.7f);
                }
            } catch (Exception e7) {
            }
        }
    }

    public void sendChangeToClient(int xCoord, int yCoord, int zCoord, int chargeLevel) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(5);
            outputStream.writeInt(xCoord);
            outputStream.writeInt(yCoord);
            outputStream.writeInt(zCoord);
            outputStream.writeInt(chargeLevel);
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
