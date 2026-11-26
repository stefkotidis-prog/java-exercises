import java.util.Objects;

public class CustomLinkedList<E> {
    private final E value;
    private final CustomLinkedList<E> next;

    public CustomLinkedList(E value) {
        this(value, null);
    }

    private CustomLinkedList(E value, CustomLinkedList<E> next) {
        this.value = value;
        this.next = next;
    }

    public CustomLinkedList<E> add(E value) {
        return new CustomLinkedList<>(value, this);
    }

    public int size() {
        return next == null ? 1 : 1 + next.size();
    }

    public boolean contains(E target) {
        if (Objects.equals(value, target)) {
            return true;
        }
        return next != null && next.contains(target);
    }

    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            return value;
        }
        if (next == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return next.get(index - 1);
    }

    public CustomLinkedList<E> reverse() {
        CustomLinkedList<E> reversed = new CustomLinkedList<>(value);
        CustomLinkedList<E> current = next;
        while (current != null) {
            reversed = reversed.add(current.value);
            current = current.next;
        }
        return reversed;
    }

    @Override
    public String toString() {
        String me = String.valueOf(value);
        return next == null ? me : me + " -> " + next;
    }
}