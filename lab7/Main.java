package lab7;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "/Users/arseniy/Documents/GitHub/knot241_template";
        FileTreeWalker fileTreeWalker = new FileTreeWalker(directoryPath);
        fileTreeWalker.walkFileTreeAndCountWordsInTxts();
    }
}