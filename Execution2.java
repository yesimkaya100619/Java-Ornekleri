
package execution2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Execution2 {
    public static int AX;
    public static int BX;
    public static int CX;
    public static int DX;
    public static int z;
    public static int s;
    public static int max = Integer.MAX_VALUE;
    static int indis1 = 0;
    static int a1 = 0;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String dosyaYolu;
        String line;
        //System.out.println("Dosya adini girin: ");
        dosyaYolu ="C:\\Users\\DELL\\OneDrive\\Belgeler\\NetBeansProjects\\Execution2\\src\\main\\java\\execution2\\dosya5.txt";
        List<String> liste = new ArrayList<>();

        File dosya = new File(dosyaYolu);
        try (BufferedReader dosyaReader = new BufferedReader(new FileReader(dosya))) {
            String satir;
            while ((satir = dosyaReader.readLine()) != null) {
                String[] parcalar = satir.split("[,\\s:]+");
                for (String parca : parcalar) {
                    liste.add(parca);
                }
            }
            dosyaReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi: " + e.getMessage());
        }

              int indis1 = 0;

        while (indis1 < liste.size()) {

            //  if (!liste.isEmpty()) {
            //  int indis = liste.indexOf(liste.get(0));
            if (liste.get(indis1).equals("HRK")) {
                HRKmetot(liste, indis1);
                indis1 += 3;
            } else if (liste.get(indis1).equals("TOP") || liste.get(indis1).equals("CIK") || liste.get(indis1).equals("CRP") || liste.get(indis1).equals("BOL")) {
                AritmetikMetot(liste, indis1);
                indis1 += 3;
            } else if (liste.get(indis1).equals("DB") || liste.get(indis1).equals("DK") || liste.get(indis1).equals("DBE") || liste.get(indis1).equals("DKE") || liste.get(indis1).equals("D")||liste.get(indis1).equals("DE")||liste.get(indis1).equals("DED")) {
                indis1 = DallanmaMetot(liste, indis1);

            } else if (liste.get(indis1).equals("VE") || liste.get(indis1).equals("VEY") || liste.get(indis1).equals("DEG")) {
                MantıkMetot(liste, indis1);
                indis1 += 3;
            } else if (liste.get(indis1).equals("YAZ")) {
                Yaz(liste, indis1);
                indis1 += 2;
                if (indis1 == liste.size() - 1) {
                    break;
                }
            } else if (liste.get(indis1).equals("ETIKET2") || liste.get(indis1).equals("ETIKET3") || liste.get(indis1).equals("ETIKET4") || liste.get(indis1).equals("ETIKET5") || liste.get(indis1).equals("ETIKET6") || liste.get(indis1).equals("ETIKET1") || liste.get(indis1).equals("ETIKET7") || liste.get(indis1).equals("ETIKET8") || liste.get(indis1).equals("ETIKET9") || liste.get(indis1).equals("ETIKET10")) {
                indis1++;
            } else if (liste.get(indis1).equals("OKU")) {
                Oku(liste, indis1);
                indis1 += 2;
            } else if (liste.get(indis1).equals("SON")) {
                break;
            } else {
                indis1++;
            }
        }
       
    }

    private static int Oku(List<String> liste, int indis1) {
        Scanner input = new Scanner(System.in);

        if (liste.get(indis1 + 1).equals("AX")) {
            System.out.print("Lütfen bir sayi giriniz:");
            int a1 = input.nextInt();
            AX = a1;
            return indis1 + 1;
        } else if (liste.get(indis1 + 1).equals("BX")) {
            System.out.print("Lütfen bir sayi giriniz:");
            int a1 = input.nextInt();
            BX = a1;
            return indis1 + 1;
        } else if (liste.get(indis1 + 1).equals("CX")) {
            System.out.print("Lütfen bir sayi giriniz:");
            int a1 = input.nextInt();
            CX = a1;
            return indis1++;
        } else if (liste.get(indis1 + 1).equals("DX")) {
            System.out.print("Lütfen bir sayi giriniz:");
            int a1 = input.nextInt();
            DX = a1;
            return indis1++;
        } else {
            System.out.println("Tanımsız değişken.");
        }
        return 0;
    }

    public static boolean getFlagValue(String flag) {
        switch (flag) {
            case "Z":
                return z == 1;
            case "S":
                return s == 1;
            default:
                return false;
        }
    }

    public static int AritmetikMetot(List<String> liste, int indis1) {

        if (liste.get(indis1).equals("TOP")) {
            if (liste.get(indis1 + 1).equals("AX")) {
                if (liste.get(indis1 + 2).equals("BX")) {
                    AX += BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    AX += CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    AX += DX;
                } else {
                    AX += Integer.parseInt(liste.get(indis1 + 2));
                }

            }

            if (liste.get(indis1 + 1).equals("BX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    BX += AX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    BX += CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    BX += DX;
                } else {
                    BX += Integer.parseInt(liste.get(indis1 + 2));
                }

            }

            if (liste.get(indis1 + 1).equals("CX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    CX += AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    CX += CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    CX += DX;
                } else {
                    CX += Integer.parseInt(liste.get(indis1 + 2));
                }

            }

            if (liste.get(indis1 + 1).equals("DX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    DX += AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    DX += BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    DX += CX;
                } else {
                    DX += Integer.parseInt(liste.get(indis1 + 2));
                }

            }
        }

        if (liste.get(indis1).equals("CIK")) {
            if (liste.get(indis1 + 1).equals("AX")) {
                if (liste.get(indis1 + 2).equals("BX")) {
                    AX -= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    AX -= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    AX -= DX;
                } else {
                    AX -= Integer.parseInt(liste.get(indis1 + 2));
                }
               
                if (AX > 0) {
                    s = 0;
                    z = 0;
                } else if (AX == 0) {
                    s = 0;
                    z = 1;
                } else {
                    s = 1;
                    z = 0;
                }
            }

            if (liste.get(indis1 + 1).equals("BX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    BX -= AX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    BX -= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    BX -= DX;
                } else {
                    BX -= Integer.parseInt(liste.get(indis1 + 2));
                }
                if (BX > 0) {
                    s = 0;
                    z = 0;
                } else if (BX == 0) {
                    s = 0;
                    z = 1;
                } else {
                    s = 1;
                    z = 0;
                }
            }

            if (liste.get(indis1 + 1).equals("CX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    CX -= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    CX -= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    CX -= DX;
                } else {
                    CX -= Integer.parseInt(liste.get(indis1 + 2));
                }
                if (CX > 0) {
                    s = 0;
                    z = 0;
                } else if (CX == 0) {
                    s = 0;
                    z = 1;
                } else {
                    s = 1;
                    z = 0;
                }
            }

            if (liste.get(indis1 + 1).equals("DX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    DX -= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    DX -= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    DX -= CX;
                } else {
                    DX -= Integer.parseInt(liste.get(indis1 + 2));
                }

                if (DX > 0) {
                    s = 0;
                    z = 0;
                } else if (DX == 0) {
                    s = 0;
                    z = 1;
                } else {
                    s = 1;
                    z = 0;
                }
            }
        }

        if (liste.get(indis1).equals("BOL")) {
            if (liste.get(indis1 + 1).equals("AX")) {
                if (liste.get(indis1 + 2).equals("BX")) {
                    AX /= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    AX /= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    AX /= DX;
                } else {
                    AX /= Integer.parseInt(liste.get(indis1 + 2));
                }
                
            }

            if (liste.get(indis1 + 1).equals("BX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    BX /= AX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    BX /= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    BX /= DX;
                } else {
                    BX /= Integer.parseInt(liste.get(indis1 + 2));
                }
                // System.out.println("İşlem Sonucu:"+BX);    
            }

            if (liste.get(indis1 + 1).equals("CX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    CX /= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    CX /= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    CX /= DX;
                } else {
                    CX /= Integer.parseInt(liste.get(indis1 + 2));
                }
                // System.out.println("İşlem Sonucu:"+CX);
            }

            if (liste.get(indis1 + 1).equals("DX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    DX /= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    DX /= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    DX /= CX;
                } else {
                    DX /= Integer.parseInt(liste.get(indis1 + 2));
                }

                //  System.out.println("İşlem Sonucu:"+DX);
            }
        }

        if (liste.get(indis1).equals("CRP")) {
            if (liste.get(indis1 + 1).equals("AX")) {
                if (liste.get(indis1 + 2).equals("BX")) {
                    AX *= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    AX *= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    AX *= DX;
                } else {
                    AX *= Integer.parseInt(liste.get(indis1 + 2));
                }
                //  System.out.println("İşlem Sonucu:"+AX);
            }

            if (liste.get(indis1 + 1).equals("BX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    BX *= AX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    BX *= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    BX *= DX;
                } else {
                    BX *= Integer.parseInt(liste.get(indis1 + 2));
                }
                // System.out.println("İşlem Sonucu:"+BX);    
            }

            if (liste.get(indis1 + 1).equals("CX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    CX *= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    CX *= CX;
                } else if (liste.get(indis1 + 2).equals("DX")) {
                    CX *= DX;
                } else {
                    CX *= Integer.parseInt(liste.get(indis1 + 2));
                }
                // System.out.println("İşlem Sonucu:"+CX);
            }

            if (liste.get(indis1 + 1).equals("DX")) {
                if (liste.get(indis1 + 2).equals("AX")) {
                    DX *= AX;
                } else if (liste.get(indis1 + 2).equals("BX")) {
                    DX *= BX;
                } else if (liste.get(indis1 + 2).equals("CX")) {
                    DX *= CX;
                } else {
                    DX *= Integer.parseInt(liste.get(indis1 + 2));
                }

               
            }
        }

               return indis1 + 3;
    }

    public static int HRKmetot(List<String> liste, int indis) {

        if (liste.get(indis).equals("HRK")) {
            if (liste.get(indis + 1).equals("AX")) {
                if (liste.get(indis + 2).equals("BX")) {
                    AX = BX;
                } else if (liste.get(indis + 2).equals("CX")) {
                    AX = CX;
                } else if (liste.get(indis + 2).equals("DX")) {
                    AX = DX;
                } else {
                   
                    AX = Integer.parseInt(liste.get(indis + 2));
                }
               
            } else if (liste.get(indis + 1).equals("BX")) {
                if (liste.get(indis + 2).equals("AX")) {
                    BX = AX;
                } else if (liste.get(indis + 2).equals("CX")) {
                    BX = CX;
                } else if (liste.get(indis + 2).equals("DX")) {
                    BX = DX;
                } else {
                   
                    BX = Integer.parseInt(liste.get(indis + 2));
                }
                //System.out.println("BX'in değeri: " + BX);
            } else if (liste.get(indis + 1).equals("CX")) {
                if (liste.get(indis + 2).equals("AX")) {
                    CX = AX;
                } else if (liste.get(indis + 2).equals("BX")) {
                    CX = BX;
                } else if (liste.get(indis + 2).equals("DX")) {
                    CX = DX;
                } else {
                    // liste.get(indis + 2) bir sayı olmalı, onu CX'e atayın
                    CX = Integer.parseInt(liste.get(indis + 2));
                }
                
            } else if (liste.get(indis + 1).equals("DX")) {
                if (liste.get(indis + 2).equals("AX")) {
                    DX = AX;
                } else if (liste.get(indis + 2).equals("BX")) {
                    DX = BX;
                } else if (liste.get(indis + 2).equals("CX")) {
                    DX = CX;
                } else {
                    // liste.get(indis + 2) bir sayı olmalı, onu DX'e atayın
                    DX = Integer.parseInt(liste.get(indis + 2));
                }
            }
        }

        return indis + 3;
    }

    public static int DallanmaMetot(List<String> liste, int indis) {
        String komut = liste.get(indis);
        String etiket = liste.get(indis + 1);
      
        
        if (liste.get(indis).equals("DK")) {
            if (s == 1 && z == 0) {
                return findLabelIndex(liste, etiket);
            }
            
            
            
        } if (komut.equals("DKE")) {
            if ((s == 1 && z == 0) || (s == 0 && z == 1)) {
                return findLabelIndex(liste, etiket);
                           }
               
        }  
        else if (komut.equals("DB")){
             if (s == 0 && z == 0){
                  return findLabelIndex(liste, etiket);
               
            }
        }
        
        else if (komut.equals("DBE") ) {
            if ((s == 0 && z == 1) || (s == 0 && z == 0)){
                 return findLabelIndex(liste, etiket);
               
            }
        } else if (komut.equals("DE")) {
            if  ((s == 0 && z == 1)){
                  return findLabelIndex(liste, etiket);
                           }
        } else if (komut.equals("DED")) {
            if  ((s == 0 && z == 0)||(s==1 && z==0)){
                  return findLabelIndex(liste, etiket);
              
            }
        }
        else if (komut.equals("D")) {
                return findLabelIndex(liste, etiket);
                         
        } else {
            return indis + 2; // Geçersiz komut durumunda bir sonraki komuta geç
        }
        return indis + 1;
    }

    private static int findLabelIndex(List<String> liste, String etiket) {
        int i = 0;
        while (i < liste.size()) {
            if (liste.get(i).equals(etiket)) {
                return i + 1;
            }
            i++;
        }
        return 0; // Etiket bulunamazsa -1 döndürülebilir.
    }

    public static int MantıkMetot(List<String> liste, int i) {
        if (liste.get(i).equals("VE")) {

            if (liste.get(i + 1).equals("AX")) {
                if (liste.get(i + 1).equals("BX")) {
                    AX = AX & BX;
                } else if (liste.get(i + 1).equals("CX")) {
                    AX = AX & CX;
                } else if (liste.get(i + 1).equals("DX")) {
                    AX = AX & DX;
                }
            }
            if (liste.get(i + 1).equals("BX")) {
                if (liste.get(i + 2).equals("AX")) {
                    BX = BX & AX;
                } else if (liste.get(i + 2).equals("CX")) {
                    BX = BX & CX;
                } else if (liste.get(i + 2).equals("DX")) {
                    BX = BX & DX;
                }
            }

            if (liste.get(i + 1).equals("CX")) {
                if (liste.get(i + 2).equals("BX")) {
                    CX = CX & BX;
                } else if (liste.get(i + 2).equals("AX")) {
                    CX = CX & AX;
                } else if (liste.get(i + 2).equals("DX")) {
                    CX = CX & DX;
                }
            }

            if (liste.get(i + 1).equals("DX")) {
                if (liste.get(i + 2).equals("AX")) {
                    DX = DX & AX;
                } else if (liste.get(i + 2).equals("BX")) {
                    DX = DX & BX;
                } else if (liste.get(i + 2).equals("CX")) {
                    DX = DX & CX;
                }
            }

        }

        if (liste.get(i).equals("VEY")) {
            if (liste.get(i + 1).equals("AX")) {
                if (liste.get(i + 2).equals("BX")) {
                    AX = AX | BX;
                } else if (liste.get(i + 2).equals("CX")) {
                    AX = AX | CX;
                } else if (liste.get(i + 2).equals("DX")) {
                    AX = AX | DX;
                }
            }
            if (liste.get(i + 1).equals("BX")) {
                if (liste.get(i + 2).equals("AX")) {
                    BX = BX | AX;
                } else if (liste.get(i + 2).equals("CX")) {
                    BX = BX | CX;
                } else if (liste.get(i + 2).equals("DX")) {
                    BX = BX | DX;
                }
            }

            if (liste.get(i + 1).equals("CX")) {
                if (liste.get(i + 2).equals("BX")) {
                    CX = CX | BX;
                } else if (liste.get(i + 2).equals("AX")) {
                    CX = CX | AX;
                } else if (liste.get(i + 2).equals("DX")) {
                    CX = CX | DX;
                }
            }

            if (liste.get(i + 1).equals("DX")) {
                if (liste.get(i + 2).equals("AX")) {
                    DX = DX | AX;
                } else if (liste.get(i + 2).equals("BX")) {
                    DX = DX | BX;
                } else if (liste.get(i + 2).equals("CX")) {
                    DX = DX | CX;
                }
            }

        }

        if (liste.get(i).equals("DEG")) {
            if (liste.get(i + 1).equals("AX")) {
                AX = AX ^ max;
            } else if (liste.get(i + 1).equals("BX")) {
                BX = BX ^ max;
            } else if (liste.get(i + 1).equals("CX")) {
                CX = CX ^ max;
            } else if (liste.get(i + 1).equals("DX")) {
                DX = DX ^ max;
            }
        }

        return i + 1;
    }

    private static Double getValue(String registerOrValue) {
        if (registerOrValue.equals("AX")) {
            return (double) AX;
        } else if (registerOrValue.equals("BX")) {
            return (double) BX;
        } else if (registerOrValue.equals("CX")) {
            return (double) CX;
        } else if (registerOrValue.equals("DX")) {
            return (double) DX;
        } else {
            return (double) Integer.parseInt(registerOrValue);
        }
    }

    public static void Yaz(List<String> liste, int indis) {

        if (liste.get(indis + 1).equals("AX")) {
            System.out.println(AX);
        } else if (liste.get(indis + 1).equals("BX")) {
            System.out.println(BX);
        } else if (liste.get(indis + 1).equals("CX")) {
            System.out.println(CX);
        } else if (liste.get(indis + 1).equals("DX")) {
            System.out.println(DX);
        }

    }

}



