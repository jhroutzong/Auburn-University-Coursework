import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class Main {
    public static int sumHeight2;
    public static int averageHeight;
    public static void main(String[] args) throws IOException {
        
        //
        File filename = new File("data.txt");
        FileWriter fw = new FileWriter(filename);
        // java.io.file
        
        for (int n = 500; n < 20000; n += 500) {
            int sumHeight;
            for (int j = 1; j < 7; j++) {
                BST tree = new BST();
                for (int i = 1; i < n; i++) {
                    int randomNum = (int) Math.floor(Math.random() * 40000);
                    tree.add(randomNum);  //creates a node
                }
                sumHeight = tree.depth();
                sumHeight2 += sumHeight;
                //tree.addTrees();
                averageHeight = sumHeight2 / j;

            }


            String n1 = String.valueOf(n);
            String height = String.valueOf(averageHeight);
            String text = n1 + " " + height;
            fw.write(text + "\n");
            String file_content = text;
            System.out.println(file_content);
           
        }
         fw.close();
    }
    
    //Path fileName = Path.of("/mnt/c/users/mille/Desktop/Project/data.txt");
            //Files.writeString(fileName, text);
            //String file_content = Files.readString(fileName);'
}


