package lab11;

import java.util.Scanner;

public class FileApp {
    private final FileDAO fileDAO;

    public FileApp(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor(fileDAO);
        processor.processFiles(path);
    }
}
