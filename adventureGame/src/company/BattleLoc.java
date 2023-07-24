package company;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location  {


    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
 private Scanner input=new Scanner(System.in);
    public BattleLoc(Player player, String name, Obstacle obstacle, String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("şuanda buradasınız " + this.getName());
        System.out.println("Dikkatli ol burada "+obsNumber +" tane "+ this.getObstacle().getName()+ " yaşıyor !");
        System.out.println("<S>avaş veya <K>aç");

        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S")&&combat(obsNumber)){
            System.out.println("Savaş Başladı");

        System.out.println(this.getName()+ " tüm düşmanları yendiniz  ! ");
        return true;
            }
        if (this.getPlayer().getHealthy()<=0){
            System.out.println();
            System.out.println("öldünüz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){

        for (int i =1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
         playerStats();
         obstacleStats(i);
        while (this.getPlayer().getHealthy()>0 && this.getObstacle().getHealth()>0){
            System.out.print("<V>ur veya <K>aç");
            String selectCombat= input.nextLine().toUpperCase();

            if (selectCombat.equals("V")){
                System.out.println("siz vurdunuz");
                this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
            afterHit();
            if (this.getObstacle().getHealth()>0){
                System.out.println();
                System.out.println("canavar size vurdu !!" );
                int obstagleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                if (obstagleDamage<0){
                    obstagleDamage=0;
                }
                this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstagleDamage);
                afterHit();

            }
            }
            else{
                return false;
            }
        }
        if (this.getObstacle().getHealth()<this.getPlayer().getHealthy()){
            System.out.println(" win warn enemy  !");
            System.out.println(this.getObstacle().getAward()+"earn to money  ");
            int money =this.getPlayer().getMoney()+this.getObstacle().getAward();
            getPlayer().setMoney(money);
            System.out.println("güncel paranız "+getPlayer().getMoney());
        }
        else{
            return false;
        }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("canınız : "+this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName()+" canı : "+this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats() {

            System.out.println("Oyuncu Değerleri");
            System.out.println("--------------------");
            System.out.println("Sağlık : " + this.getPlayer().getHealthy());
            System.out.println("Damage : " + this.getPlayer().getTotalDamage());
            System.out.println("Para : " + this.getPlayer().getMoney());
            System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
            System.out.println("zırh : " + this.getPlayer().getInventory().getArmor().getName());
            System.out.println("block : " + this.getPlayer().getInventory().getArmor().getBlock());
        }
        public void obstacleStats (int i) {
            System.out.println(i+" . "+this.getObstacle().getName() + " değerleri ");
            System.out.println(" ----------------- ");
            System.out.println(" saglık : " + this.getObstacle().getHealth());
            System.out.println(" hasar  : " + this.getObstacle().getDamage());
            System.out.println(" Para : " + this.getObstacle().getAward());
        }
        public int randomObstacleNumber () {
            Random random = new Random();
            return random.nextInt(this.getMaxObstacle()) + 1;
        }


        public Obstacle getObstacle () {
            return obstacle;
        }

        public void setObstacle (Obstacle obstacle){
            this.obstacle = obstacle;
        }

        public String getAward () {
            return award;
        }

        public void setAward (String award){
            this.award = award;
        }
    }

