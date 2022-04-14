import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        WeightedGraph wg = new WeightedGraph();
        String content = new String(Files.readAllBytes(Path.of("text.txt")));
        String[]arr1 = content.split("\n");
        String[][] arrSon=new String[352][3];
        for (int i = 0;i< arr1.length;i++){
            arrSon[i]=arr1[i].split(",");
        }
        for (int j =0;j< arr1.length;j++){
            for (int k = 0;k<2;k++){
                wg.addNode(arrSon[j][k]);
            }
            wg.addEdge(arrSon[j][0],arrSon[j][1],Integer.parseInt(arrSon[j][2].strip()));
        }


        System.out.println("1: Print All data" +
                "2: Print Closest Characters" +
                "3: Print Farthest Characters" +
                "4: Check two of characters is connected" +
                "5: Delete a connection between characters" +
                "6: Update the weight of connection between characters" +
                "7: Search by weight" +
                "8: Prints all froms to entered character");
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        switch (a){
            case 1:
                wg.print();
            case 2:
                System.out.println("Enter character:");
                String firstChar = scn.next();
                System.out.println("Enter threshold:");
                int tresHold = scn.nextInt();
                wg.printClosestCharacters(firstChar,tresHold);
            case 3:
                System.out.println("Enter character:");
                String firstChar2 = scn.next();
                System.out.println("Enter threshold:");
                int tresHold2 = scn.nextInt();
                wg.printFarthestCharacters(firstChar2,tresHold2);
            case 4:
                System.out.println("Enter first character:");
                String firstChar3 = scn.next();
                System.out.println("Enter second character:");
                String secondChar = scn.next();
                wg.isConnected(firstChar3,secondChar);
            case 5:
                System.out.println("Enter first character:");
                String firstChar4 = scn.next();
                System.out.println("Enter second character:");
                String secondChar2 = scn.next();
                wg.delete(firstChar4,secondChar2);
            case 6:
                System.out.println("Enter first character:");
                String firstChar5 = scn.next();
                System.out.println("Enter second character:");
                String secondChar3 = scn.next();
                System.out.println("Enter weight");
                int weight = scn.nextInt();
                wg.change(firstChar5,secondChar3,weight);
            case 7:
                System.out.println("enter weight");
                int weight2= scn.nextInt();
                wg.searchByWeight(weight2);
            case 8:
                System.out.println("Enter a Character");
                String fromChar = scn.next();
                wg.printAllFroms(fromChar);




        }
       























    }
}
