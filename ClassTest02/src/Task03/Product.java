package Task03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Product {
    private boolean isReady;
    File file1;
    File file2;
    private char c;
    FileInputStream sc = null;
    PrintWriter pr = null;
    boolean pl = false;
    public boolean isProduced() {
        return isReady;
    }

    public Product(File file1, File file2) {
        this.file1 = file1;
        this.file2 = file2;
        try{
            sc = new FileInputStream(file1);
            pr = new PrintWriter(file2);
        }
        catch(IOException e){
            System.out.println(":c");
        }
    }
    public boolean isEnd(){
        return pl;
    }

    public boolean isConsumed() {
        return !isReady;
    }

    public void produce() {
        int i = 0;
        try {
            i = sc.read();
        }
        catch(IOException e){
            System.out.println(":c");
        }
        if( i != -1){
            this.c = (char) i;
        }
        else pl  = true;
        isReady = true;
    }

    public void consume() {
        if(!pl){
            pr.print(c);
        }
        else pr.close();
        isReady = false;
    }

}