import java.util.Scanner;

public class Condo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int floor = 0,room = 0;
        int choice=0;
        String[][] condo = new String[0][];
        System.out.println("------welcmoe-----\n");
        boolean bl=false;
        do {
            System.out.println("<><><><><><>Condo Still Building<><><><><>");
            System.out.print("Enter Number of floor = ");
            floor=input.nextInt();
            if (floor>0){
                bl=true;
                System.out.print("Enter Number of Room = ");
                room=input.nextInt();
                do {
                    if (room>0){
                        bl=true;
                        condo=new  String[floor][room];
                        System.out.println("Condo can live ");
                        System.out.println("Floor = "+ floor);
                        System.out.println("Room = "+ room);
                        System.out.println("Total = " + (floor*room));
                    }
                }while (!true);
            }else {
                System.out.println("You Enter the wrong number");
            }
        }while (!true);
        do {
            System.out.println("______Welcome To My Condo_______");
            System.out.println("1. Buy Condo ");
            System.out.println("2. Sell Condo ");
            System.out.println("3. Search Information of Condo ");
            System.out.println("4. Display Information of Condo ");
            System.out.println("5. Enter to Exit");
            System.out.print("chose Your Option : ");
            choice = input.nextInt();
            switch (choice){
                case 1:               //Buy Condo
                    int needFloor, needRoom;
                    String name ;
                    do {
                        System.out.println("-----Buy Condo-----");
                        System.out.print("Please Input Number of floor You Need : ");
                        needFloor=input.nextInt();
                        if (needFloor>0 && needFloor<=floor){
                            bl=true;
                            System.out.print("Please Input Number of Room You Need : ");
                            needRoom=input.nextInt();
                            if (needRoom>0 && needRoom<=room){
                                if (condo[needFloor-1][needRoom-1]==null){
                                    bl=true;
                                    System.out.print("Enter Your Name : ");
                                    input.nextLine();
                                    name=input.nextLine();
                                    condo[needFloor-1][needRoom-1]=name;
                                    System.out.println("\nYou Already Buy Condo");
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                }else {
                                    System.out.println("\nThe Room have bought\n");
                                    bl=false;
                                }
                            }else {
                                System.out.println("\nThis room does not have !!!!!\n");
                                bl=false;
                            }
                        }else {
                            System.out.println("\nThis floor does not have !!!!!\n");
                        }
                    }while (!true);
                    break;
                case 2:                    //sell condo
                    int sell;
                    int buyFloor=0, buyRoom = 0;
                    String Myname ;
                    do {
                        System.out.println("-----Sell Condo-----");
                        System.out.print("Please Input Number of floor You buy : ");
                        buyFloor=input.nextInt();
                        if(buyFloor>0 && buyFloor<=floor){
                            System.out.print("Please Input Number of room You buy :");
                            buyRoom=input.nextInt();
                            if ( buyRoom>0 &&buyRoom<=room){
                                first :
                                for (int i=(condo.length-1); i>=0; i--){
                                    for (int j=0; j<condo[i].length; j++){
                                        if(condo[buyFloor-1][buyRoom-1]!=null){
                                            if(condo[buyFloor-1][buyRoom-1]==condo[i][j]){
                                                name= condo[i][j];
                                                System.out.println("\n>>>> The owner information ");
                                                System.out.println("Floor "+buyFloor+ " Room "+ buyRoom+ " belong to "+name);
                                                System.out.print("Press 1 to confirm or 0 to cancel : ");
                                                sell = input.nextInt();
                                                if(sell==1){
                                                    condo[buyFloor-1][buyRoom-1]=null;
                                                    System.out.println("yeye..... Congratulation...! You have sold the condo.\n");
                                                    break first;
                                                }else {
                                                    System.out.println("\nThe plan to sell the condo was cancel...!\n");
                                                }
                                            }
                                        }else {
                                            System.out.println("\nThis condo does have the owner.\n");
                                            break first;
                                        }

                                    }
                                    System.out.println();
                                }
                            }else {
                                System.out.println("\nThis room doesn't have !!!\n");
                            }
                        }else {
                            System.out.println("\nThis floor doesn't have !!! \n");
                        }

                    }while (!true);
                    break;
                case 3:            //Search floor & Room
                    int searchOption;
                    System.out.println("\n--------------search Condo--------------");
                    System.out.println("1. search by name ");
                    System.out.println("2. search by floor and room");
                    System.out.println("3. Exit program ");
                    System.out.print("Chose number 1 to 3 = ");
                    searchOption=input.nextInt();
                    switch (searchOption){
                        case 1:
                            System.out.println("_________Search by name user_________");
                            String searchName;
                            System.out.print("Search name user = ");
                            input.nextLine();
                            searchName = input.nextLine();
                            for (int i=(condo.length-1); i>=0; i--){
                                for (int j=0; j<condo[i].length; j++){
                                    if (condo[i][j]!=null){
                                        if (condo[i][j].equalsIgnoreCase(searchName)){
                                            bl=true;
                                            System.out.println("Owner Name : (  "+ searchName+ "  )\tlive on Floor :  " + (i+1)+"\tAt Room :  "+(j+1));
                                        }else {
                                            condo[i][j]=null;
                                            System.out.println("\nUser : [ "+ searchName+ " ] does not exist in the system \n");
                                        }
                                    }
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("\n");
                            System.out.println("__________Search by floor__________\n ");
                            int searchfloor=0;
                            System.out.print("Enter floor want to search : ");
                            searchfloor=input.nextInt();
                            if (searchfloor>0 && searchfloor<=floor){
                                System.out.println("Floor"+ searchfloor+" : ");
                                for (int i=0; i<condo[searchfloor-1].length; i++){
                                    System.out.println("\t"+ condo[searchfloor-1][i]);
                                }
                                System.out.println();
                            }else {
                                System.out.println("ERROR! Invalid Floor (Choose from 1 to "+floor+" )\n ");
                            }
                            break;
                        default:
                            System.out.println("Exit ");
                    }
                    break;
                case 4:      //Show information
                    System.out.println("------ Show Condo on screen ------");
                    for (int i=(condo.length-1); i>=0; i--){
                        System.out.print("Floor["+(i+1)+"]");
                        for (int j=0; j<condo[i].length; j++){
                            System.out.print("\t\t"+ condo[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println("\n");
                    break;
                case 5: break;
            }
        }while (choice!=5);
    }
}
