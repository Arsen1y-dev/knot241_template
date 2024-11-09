package lab2.num5;

interface FileSystemComponent {
    String getName();
    long getSize();
    void add(FileSystemComponent component);
    void remove(FileSystemComponent component);
    void display(String indent);
}
