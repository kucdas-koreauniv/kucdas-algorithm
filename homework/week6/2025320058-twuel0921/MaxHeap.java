public class MaxHeap extends Heap<Integer> {
    public MaxHeap() {
        super((o1, o2) -> o1-o2);
    }
}