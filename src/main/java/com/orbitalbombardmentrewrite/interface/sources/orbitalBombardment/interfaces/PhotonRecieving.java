package orbitalBombardment.interfaces;

/* JADX INFO: loaded from: PhotonRecieving.class */
public class PhotonRecieving extends PhotonProducing {
    public void recievePhotons(int power) {
        this.currentCharge += power;
    }
}
