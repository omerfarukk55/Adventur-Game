package company;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    public ToolStore(Player p) {
        super(p, "magaza");
    }
   private Scanner input=new Scanner(System.in);
    @Override
    public boolean onLocation() {
        System.out.println("------------- magazaya hoşgeldiniz  -----------------------");
        boolean showMenu=true;
        while (showMenu){
           System.out.println(" 1 - silahlar ");
           System.out.println(" 2 - zırhlar ");
           System.out.println(" 0 - cıkış yap");
           int selectCase = input.nextInt();
           while(selectCase<1 && 3<selectCase){
               System.out.println("gecersiz değer, tekrar giriniz : ");
               selectCase = input.nextInt();
           }
           switch (selectCase){

               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 0:
                   System.out.println("bir daha bekleriz");
                   showMenu=false;
                   break;

           }
       }
return true;
    }
    public void printWeapon(){
        System.out.println("--------- Silahlar ----------");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+""+w.getName()+ "<para : "+w.getPrice()+", hasar : "+w.getDamage()+">");
        }
        System.out.println("0 ile cıkış işlemi yapılır");


    }
    public void buyWeapon(){
        System.out.println("bir silah seciniz");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID <0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("gecersiz değer tekrar giriniz");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID!=0){
            Weapon selectedWeapon = Weapon.getWeaponByIdObj(selectWeaponID);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("yeterli bakiyeniz bulunmamaktadır !");

                }else {
                    // satın alma işlemi burada gercekleşiyor
                    System.out.println(selectedWeapon.getName() + "silahı satın aldınız !");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("kalan paranız "+this.getPlayer().getMoney());
                    System.out.println(this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println();
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("-------- Zırhlar ---------");
        for (Armor A:Armor.armors()){
            System.out.println(A.getId()+" - "+A.getName()+" " +
                    "<para "+A.getPrice()+" , Hasar : "+A.getBlock() + ">");
        }
        System.out.println("0 ile cıkış yap . ");
    }
    public void buyArmor(){
        System.out.println("bir kalkan seç");
        int selectId=input.nextInt();
        while (selectId<0||selectId>3){
            System.out.println("geçersiz sayı girdiniz tekrar girin.");
            selectId=input.nextInt();
        }
        if (selectId!=0){
            Armor selectArmor=Armor.getArmorByIdObj(selectId);
            if (selectArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println("satın alamazsınız");
            }else{
                System.out.println(selectArmor.getName()+"   zırhını satın aldınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectArmor.getPrice());
                System.out.println(this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectArmor);
                System.out.println("kalan para :"+this.getPlayer().getMoney());
            }
        }

    }

}
