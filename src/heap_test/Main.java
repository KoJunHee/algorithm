package heap_test;

public class Main {
    public static void main(String[] args) {
        int n, item;
        Heap h = new Heap();

        //insert
        h.insertHeap(13);
        h.insertHeap(8);
        h.insertHeap(10);
        h.insertHeap(15);
        h.insertHeap(20);
        h.insertHeap(19);

        //print
        h.printHeap();

        //delete
        n = h.getHeapSize();
        for (int i = 1; i <= n; i++) {
            item = h.deleteHeap();
            System.out.printf("\n deleted Item : [%d]", item);
        }
    }
}
