package job;

public class Brand {
    private String brand;
    private String country;
    private String language;

    public Brand(String brand, String country, String language){
        this.brand = brand;
        this.country = country;
        this.language = language;
        }

    public String getBrand() {return brand;}
    public String getCountry() {return country;}
    public String getLanguage() {return language;}

    @Override
    public String toString() {
        return "Brand [brand= " + brand + ", country= " + country + ", language= " + language + "]";
    }
}
    






package job;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Создание класса Laptop
public class Laptop {
// Создание поля на основе другого класса
    private List<Brand> brands;
// Создание полей
    private String model;
    private float diagonal;
    private String screenResolution;
    private boolean dvdRom;
    private int hardDisk;
    private String operativeMemory;
    private String operatingSystem;
    private String color;
// Создание пустого конструктора для работы с методами
    public Laptop() {
    }
// Создание конструктора для создания экземпляров класса
    public Laptop(String model, float diagonal, String screenResolution, boolean dvdRom, int hardDisk,
            String operativeMemory, String operatingSystem, String color) {
        this.brands = new ArrayList<>();
        this.model = model;
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.dvdRom = dvdRom;
        this.hardDisk = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
// Создание методов get\set Для работы с private полями
    public String getModel() {return model;}
    public float getDiagonal() {return diagonal;}
    public String getScreenResolution() {return screenResolution;}
    public boolean isDvdRom() {return dvdRom;}
    public int getHardDisk() {return hardDisk;}
    public String getOperativeMemory() {return operativeMemory;}
    public String getOperatingSystem() {return operatingSystem;}
    public String getColor() {return color;}
// Создание метода для создания экземпляра другого класса,
// для того что бы работать с этими экземпляррами в данном классе
    public void addBrand(Brand brand) {
        brands.add(brand);
    }
// создание метода фильтрации ноутбуков по критериям
    public List<Laptop> filter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Здрасвуйте, Укажите каие параметры для ноут бука вы бы хотели иметь." +
                "\nУкажите размер жёсткого диска в гб\nВналичии : 300,500,600,700,1000");
        String enterHardDisk = scan.nextLine();
        int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
        System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : 4, 8, 16 ");
        String enterOperativeMemory = scan.nextLine();
        System.out.println("Укажите операционную систему\nВналичии : Linux, ios, Windows");
        String enterOperatingSystem = scan.nextLine();
        System.out.println("Укажите цвет ноутбука\nВналичии : black, white");
        String enterColor = scan.nextLine();

        List<Laptop> listLaptop = new ArrayList<>();
        for (Laptop tempLaptop : laptop) {
            if (intParseEnterHardDisk == tempLaptop.hardDisk) {
                if (enterOperativeMemory.equals(tempLaptop.operativeMemory)) {
                    if (enterOperatingSystem.equals(tempLaptop.operatingSystem)) {
                        if (enterColor.equals(tempLaptop.color)) {
                            listLaptop.add(tempLaptop);
                        }
                    }
                }
            }
        }
        return listLaptop;
    }

// создание метода фильтрации ноутбуков по выборочной критериям
    public Set<Laptop> newFilter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println("Здрасвуйте, Укажите номер или номера критериев фильрации ноутбуков," + 
        "\n1. Size hard disk\n2. Size operatyvi memory\n3. Operating system\n4. Color");
        String userRequest = scan.nextLine();
            
        for (int i = 0; i < userRequest.length(); i++) {
            if(1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите размер жёсткого диска в гб\nВналичии : 300,500,600,700,1000");
                String enterHardDisk = scan.nextLine();
                int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
                for (Laptop tempLaptop : laptop) {
                    if (intParseEnterHardDisk != tempLaptop.hardDisk){ 
                        listLaptop.remove(tempLaptop);
                    }
                }          
            }
            
            if(2 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : 4, 8, 16 ");
                String enterOperativeMemory = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperativeMemory.equals(tempLaptop.operativeMemory)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }   

            if(3 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите операционную систему\nВналичии : Linux, ios, Windows");
                String enterOperatingSystem = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperatingSystem.equals(tempLaptop.operatingSystem) == false)) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        
            if(4 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите цвет ноутбука\nВналичии : black, white");
                String enterColor = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterColor.equals(tempLaptop.color)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        return listLaptop;
    }

// метод toString, выводит на экран данные объекта
    @Override
    public String toString() {
        return "\nLaptop  ->  " + model + "\nbrands = " + brands + ",\ndiagonal = " + diagonal + ",\nscreenResolution = "
                + screenResolution
                + ",\ndvdRom = " + dvdRom + ",\nhardDisk = " + hardDisk + ",\noperativeMemory = " + operativeMemory
                + ",\noperatingSystem = " + operatingSystem + ",\ncolor = " + color + "\n";
    }

}







package job;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
// Создание объектов класса Laptop
        Laptop hp_pailion_g6 = new Laptop("hp_pailion_g6", 16, "4k", 
        true, 500, "16", "Windows", "black"); 
        Brand brandHp = new Brand("HP", "U.S.A.", "AmericaLanguage");
        hp_pailion_g6.addBrand(brandHp); 
        Laptop hp_galaxy_x64 = new Laptop("hp_galaxy_x64", 14, "FullHD", 
        true, 500, "8", "Windows", "white");
        hp_galaxy_x64.addBrand(brandHp);
        Laptop samsung_a52 = new Laptop("samsung_a52", 18, "FullHD", 
        true, 300, "8", "Windows", "black");
        Brand brandSamsung = new Brand("Samsung", "Korea", "KoreaLanguage");
        samsung_a52.addBrand(brandSamsung);
        Laptop samsung_m31s = new Laptop("samsung_m31s", 16, "4k", 
        false, 1000, "16", "Linux", "black");
        samsung_m31s.addBrand(brandSamsung);
        Laptop lenovo_gtx76 = new Laptop("lenovo_gtx76", 16, "FullHD", 
        true, 700, "8", "Windows", "white");
        Brand brandLenovo = new Brand("Lenovo", "China", "ChinaLanguage");
        lenovo_gtx76.addBrand(brandLenovo);
        Laptop macbook_14pro = new Laptop("macbook_14pro", 17, "4k", 
        false, 1000, "8", "ios", "white");
        Brand brandMacbook = new Brand("Apple", "U.S.A.", "AmericaLanguage");
        macbook_14pro.addBrand(brandMacbook);
        Laptop asus_x515 = new Laptop("asus_x515", 17, "FullHD", 
        true, 300, "4", "Windows", "black");
        Brand brandAsus = new Brand("Asus", "taiwan", "ChinaLanguage");
        asus_x515.addBrand(brandAsus);
        Laptop acer_air5 = new Laptop("acer_air5", 19, "FullHD", 
        true, 600, "8", "Windows", "black");
        Brand brandAcer = new Brand("Acer", "taiwan", "ChinaLanguage");
        acer_air5.addBrand(brandAcer);
        Laptop acer_air6 = new Laptop("acer_air6" ,18, "4k", 
        false, 500, "16", "Windows", "black");
        acer_air6.addBrand(brandAcer);
        Laptop acer_a313 = new Laptop("acer_a313", 16, "FullHD", 
        true, 500, "8", "Windows", "black");
        acer_a313.addBrand(brandAcer);
// Создание множества
        Set <Laptop> laptop = new HashSet<>();
        laptop.add(hp_pailion_g6);      
        laptop.add(hp_galaxy_x64);
        laptop.add(samsung_a52);
        laptop.add(samsung_m31s);
        laptop.add(lenovo_gtx76);
        laptop.add(macbook_14pro);
        laptop.add(asus_x515);
        laptop.add(acer_air5);
        laptop.add(acer_air6);
        laptop.add(acer_a313);
// создание нового объекта вызова методов
        Laptop FilterLaptop = new Laptop();
// вызов метода фильтрации по определеннеым параметрам
        // System.out.println("по вашему запросу найдено: " + FilterLaptop.filter(laptop));

// вызод метода фильтрации по заданным пользователем критериям
        System.out.println(FilterLaptop.newFilter(laptop));
    }
}
