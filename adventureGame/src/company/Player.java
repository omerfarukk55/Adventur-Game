package company;

import java.util.Scanner;

public class Player  {
    private Scanner input = new Scanner(System.in);
    private int damage;
    private int healthy;
    private int originalHealthy;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name) {
        this.name=name;
        this.inventory= new Inventory();
    }
  public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
  }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getOriginalHealthy() {
        return originalHealthy;
    }

    public void setOriginalHealthy(int originalHealthy) {
        this.originalHealthy = originalHealthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void  selectChar(){

        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        for(GameChar gameChar:charList){
            System.out.println("ID :"+gameChar.getId()+"\tkarakter: "+gameChar.getName()+",\thasar: "+gameChar.getDamage()+",\tsaglık: "+gameChar.getHealth()+"\tmoney: "+gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("lütfen karakter ID seçiniz?");
        int  selectChar=input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
       System.out.println("karakteriniz : "+this.getCharName()+
                " hasar : "+this.getDamage()
                +" saglık : " +this.getHealthy()
                +" Para: " +this.getMoney());

        }
        public void selectLoc(){

        }
     public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setOriginalHealthy(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
     }
    public void printInfo(){
        System.out.println("silahınız : "+this.getInventory().getWeapon().getName()+
                " zırhınız "+this.getInventory().getArmor().getName()+
                " bloklama "+this.getInventory().getArmor().getBlock()+
                " hasar : "+this.getTotalDamage()
                +" saglık : " +this.getHealthy()
                +" Para : " +this.getMoney());
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    }

