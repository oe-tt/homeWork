package family_tree.model.human.comparators;

import java.util.Comparator;

import family_tree.model.family_tree.*;

public class HumanComparatorByBirthDate<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
