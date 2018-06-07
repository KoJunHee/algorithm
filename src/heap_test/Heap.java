package heap_test;

class Heap {

    private int heapSize;
    private int itemHeap[];

    public Heap() {
        heapSize = 0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++heapSize;
        while ((i != 1) && (item > itemHeap[i / 2])) {
            itemHeap[i] = itemHeap[i / 2];
            i /= 2;
        }
        itemHeap[i] = item;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public int deleteHeap() {
        int parent, child;
        int item, temp;
        item = itemHeap[1]; //root
        temp = itemHeap[heapSize--]; //마지막 노드 (위치를 찾아가는 과정)
        parent = 1;
        child = 2;

        while (child <= heapSize) {

            //자식 노드 간의 크기 비교
            if ((child < heapSize) && (itemHeap[child] < itemHeap[child + 1])) {
                child++;
            }

            //자식 노드보다 크거나 같으면 본 위치 찾음
            if (temp >= itemHeap[child]) {
                break;
            }

            //부모와 자식 같의 위치 변경
            itemHeap[parent] = itemHeap[child];


            //parent의 index는 이제 자식 노드의 index가 됨
            parent = child;
            child *= 2;
        }

        itemHeap[parent] = temp;
        return item;
    }

    public void printHeap() {
        System.out.printf("\nHeap >>> ");
        for (int i = 1; i <= heapSize; i++)
            System.out.printf("[%d] ", itemHeap[i]);
    }
}