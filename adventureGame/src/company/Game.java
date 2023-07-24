package company;

import java.io.BufferedReader;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("macera oyununa hoşgeldiniz");
        System.out.println("lütfen bir isim giriniz");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println(player.getName()+" Hosgeldiniz");
        System.out.println("lütfen bir karakter seçiniz ?");
        player.selectChar();

        while (true){
            player.printInfo();
            Location location=null;
            System.out.println();
            System.out.println("şuanda güvenli bölgedesiniz");
            System.out.println();

            System.out.println("1 - güvenli ev");
            System.out.println("2 - Toolstore =  silah ve zırh alabilirsiniz");
            System.out.println("3 - Mağara --> ödül <yemek> Mağaraya gir, dikkatli ol zombi cıkabilir");
            System.out.println("4 - Orman --> ödül <odun> Orman gir, dikkatli ol vampir cıkabilir");
            System.out.println("5 - Nehir --> ödül <su> Nehir gir, dikkatli ol ayı cıkabilir");
            System.out.println("0 - çıkış yap");
            System.out.println("--- lütfen gitmek istediniz bölgeyi seçiniz   -----");
            int selectLoc=input.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location =new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    location =new SafeHouse(player);

            }
            if (location == null){
                System.out.println("bu karanlık sisli adadan cabuk kaçtın");
                break;
            }

            if (!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }
        }
    }
}
