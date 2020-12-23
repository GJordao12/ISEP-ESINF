package Tree;

import java.util.List;

/**
 * The type Utils.
 *
 * @author DEI -ESINF
 */
public class Utils {

    /**
     * Sort by BST iterable.
     *
     * @param <E>          the type parameter
     * @param listUnsorted the list unsorted
     * @return the iterable
     */
    public static <E extends Comparable<E>> Iterable<E> sortByBST(List<E> listUnsorted) {
        BST<E> BSTTree = new BST<>();
        for (E element : listUnsorted) {
            BSTTree.insert(element);
        }
        return BSTTree.inOrder();
    }
}
