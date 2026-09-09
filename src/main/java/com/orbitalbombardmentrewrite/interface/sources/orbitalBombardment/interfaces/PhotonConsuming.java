package orbitalBombardment.interfaces;

/* JADX INFO: loaded from: PhotonConsuming.class */
public class PhotonConsuming extends asp {
    public int currentCharge = 0;
    public int maxCharge = 0;

    public void addCharge(int incomingCharge) {
        this.currentCharge += incomingCharge;
    }

    public void removeCharge(int outgoingCharge) {
        this.currentCharge -= outgoingCharge;
    }

    public int getCurrentCharge() {
        return this.currentCharge;
    }

    public void setCurrentCharge(int currentCharge) {
        this.currentCharge = currentCharge;
    }

    public int getMaxCharge() {
        return this.maxCharge;
    }

    public void setMaxCharge(int maxCharge) {
        this.maxCharge = maxCharge;
    }
}
