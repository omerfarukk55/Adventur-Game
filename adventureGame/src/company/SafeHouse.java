package company;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player p) {
        super(p, "Güvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("güvenli evdesiniz !");
        System.out.println("canınız yenileniyor !");
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealthy());
        return true;
    }
}
