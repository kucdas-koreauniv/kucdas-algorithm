public class MinHeap extends Heap<Integer> {
    public MinHeap() {
        super((o1, o2) -> -(o1-o2));
    }
}