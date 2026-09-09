package com.orbitalbombardmentrewrite.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import orbitalBombardment.OrbitalBombardment;
import orbitalBombardment.blocks.ChargeBlockTileEntity;
import orbitalBombardment.blocks.SateliteTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: ChargeBlockGui.class */
public class ChargeBlockGui extends awe {
    bjo texture = new bjo("OB".toLowerCase(), "textures/gui/gui.png");
    public final int xSize = 200;
    public final int ySize = 120;
    uf entity2;

    public ChargeBlockGui(uf entity) {
        this.entity2 = entity;
    }

    public void a(int x, int y, float f1) {
        e();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        atv.w().J().a(this.texture);
        int posX = (this.g - 200) / 2;
        int posY = (this.h - 120) / 2;
        b(posX, posY, 0, 0, 200, 120);
        super.a(x, y, f1);
        abw world = this.entity2.q;
        int xC = OrbitalBombardment.instance.lastChargerX;
        int yC = OrbitalBombardment.instance.lastChargerY;
        int zC = OrbitalBombardment.instance.lastChargerZ;
        ChargeBlockTileEntity entity = world.r(xC, yC, zC);
        if (entity.hasSatelite) {
            this.i.add(new aut(0, posX + 38, posY + 60, 100, 20, "Launch Satelite"));
            this.o.a("Photon Charge: " + entity.getCurrentCharge() + " PU", posX + 30, posY + 35, -1);
            return;
        }
        this.i.removeAll(this.i);
        if (entity.isCharging()) {
        }
        if (!entity.isCharging()) {
        }
        this.o.a("Photon Charge: " + entity.getCurrentCharge() + " PU", posX + 30, posY + 30, -1);
        if (entity.amountOfGuns == null) {
            this.o.a("# Designators: 0", posX + 30, posY + 40, -1);
        } else {
            this.o.a("# Designators: " + entity.amountOfGuns.size(), posX + 30, posY + 40, -1);
        }
        this.o.a("Satelite uses left: " + entity.shotsLeft, posX + 30, posY + 50, -1);
    }

    public boolean f() {
        return false;
    }

    public void a(aut button) {
        switch (button.g) {
            case 0:
                abw world = this.entity2.q;
                int xC = OrbitalBombardment.instance.lastChargerX;
                int yC = OrbitalBombardment.instance.lastChargerY + 1;
                int zC = OrbitalBombardment.instance.lastChargerZ;
                ChargeBlockTileEntity entity = world.r(xC, yC - 1, zC);
                SateliteTileEntity sat = world.r(xC, yC, zC);
                if (entity.hasSatelite && entity.getCurrentCharge() > 25000 && !sat.shouldLaunch) {
                    bdi mp = (bdi) this.entity2;
                    sendChangeToServer18(xC, yC - 1, zC, entity.shotsLeft + 150, mp);
                    sat.shouldLaunch = true;
                    entity.hasSateliteLaunched = true;
                    entity.hasSatelite = false;
                } else if (entity.hasSatelite) {
                    this.entity2.a("Cannot launch satelite. Need 25000PU to launch.");
                    entity.hasSatelite = false;
                }
                break;
        }
    }

    public void sendChangeToServer18(int xCoord, int yCoord, int zCoord, int power, bdi mp) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(18);
            outputStream.writeInt(xCoord);
            outputStream.writeInt(yCoord);
            outputStream.writeInt(zCoord);
            outputStream.writeInt(power);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ea packet = new ea();
        packet.a = "OB";
        packet.c = bos.toByteArray();
        packet.b = bos.size();
        mp.a.c(packet);
    }
}
