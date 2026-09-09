package orbitalBombardment.lib;

import orbitalBombardment.blocks.Blocks;
import orbitalBombardment.items.Items;

/* JADX INFO: loaded from: OrbBombRecipes.class */
public class OrbBombRecipes {
    public static void init() {
        aaf.a().a(new ye(Items.lenseItem, 1), new Object[]{" D ", " E ", " D ", 'D', yc.p, 'E', yc.bJ});
        aaf.a().a(new ye(Items.photonCondenserItem, 1), new Object[]{"ILI", "IRI", "ILI", 'I', yc.q, 'R', yc.bd, 'L', Items.lenseItem});
        aaf.a().a(new ye(Items.designatorLow, 1), new Object[]{"RIR", "IDI", "RIR", 'I', yc.q, 'R', yc.aE, 'D', yc.p});
        aaf.a().a(new ye(Items.designatorMed, 1), new Object[]{"RGR", "LDL", "RGR", 'G', yc.r, 'R', yc.aE, 'D', yc.p, 'L', Items.designatorLow});
        aaf.a().a(new ye(Items.designatorHigh, 1), new Object[]{"RGR", "LDL", "RGR", 'G', yc.r, 'R', yc.aE, 'D', yc.bJ, 'L', Items.designatorMed});
        aaf.a().a(new ye(Items.laserGunLowItem, 1), new Object[]{"EIE", "LCI", "EBI", 'E', yc.aE, 'L', Items.lenseItem, 'C', Items.photonCondenserItem, 'I', yc.q, 'B', Items.designatorLow});
        aaf.a().a(new ye(Items.laserGunMedItem, 1), new Object[]{"EIE", "LCI", "EBI", 'E', yc.aE, 'L', Items.lenseItem, 'C', Items.photonCondenserItem, 'I', yc.q, 'B', Items.designatorMed});
        aaf.a().a(new ye(Items.laserGunHighItem, 1), new Object[]{"EIE", "LCI", "EBI", 'E', yc.aE, 'L', Items.lenseItem, 'C', Items.photonCondenserItem, 'I', yc.q, 'B', Items.designatorHigh});
        aaf.a().a(new ye(Items.photonCapacitor, 1), new Object[]{"GSG", "SES", "GSG", 'G', yc.r, 'S', aqz.R, '!', yc.bp});
        aaf.a().a(new ye(Blocks.photonInverter, 1), new Object[]{"LLL", "GCG", "OOO", 'L', Items.lenseItem, 'G', aqz.am, 'O', yc.q, 'C', Items.photonCondenserItem});
        aaf.a().a(new ye(Blocks.photonInverterAdv, 1), new Object[]{"LCL", "SSS", "III", 'L', Items.lenseItem, 'S', Blocks.photonInverter, 'I', yc.q, 'C', Items.photonCondenserItem});
        aaf.a().a(new ye(Blocks.satelite, 1), new Object[]{"ICI", "CEC", "ICI", 'C', Items.photonCondenserItem, 'E', Items.photonCapacitor, 'I', yc.q});
        aaf.a().a(new ye(Blocks.extender, 1), new Object[]{"ILI", "LRL", "ILI", 'L', Items.photonCapacitor, 'R', Items.photonCondenserItem, 'I', yc.q});
        aaf.a().a(new ye(Blocks.launchSatelite, 1), new Object[]{"I I", "GRG", "LGL", 'L', Items.photonCapacitor, 'R', Items.photonCondenserItem, 'I', yc.q, 'G', yc.r});
        aaf.a().a(new ye(Blocks.photonAccelerator, 1), new Object[]{"IRI", "IRI", "ILI", 'L', Items.photonCapacitor, 'R', Items.photonCondenserItem, 'I', yc.q, 'G', yc.r});
        aaf.a().a(new ye(Blocks.photonDecelerator, 1), new Object[]{"ILI", "ILI", "IGI", 'L', Items.lenseItem, 'R', Items.photonCondenserItem, 'I', yc.q, 'G', yc.r});
        aaf.a().a(new ye(Blocks.defender, 1), new Object[]{"ILI", "ILI", "RIR", 'L', Items.lenseItem, 'R', Items.photonCondenserItem, 'I', yc.q, 'G', yc.r});
    }
}
