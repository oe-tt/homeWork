package family_tree;

import java.util.List;
import java.util.ArrayList;
// import java.util.function.Function;


// public class FamilyTree implements Serializable {
public class FamilyTree {
    private List<Human> humanList;
    
    public FamilyTree(List<Human> humanList) {this.humanList = humanList;}

    public FamilyTree() {this (new ArrayList<>());}

    public boolean add (Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            
            addToParents(human);
            addToChildren(human);
            addToWifes(human);
            addToHusbands(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParents(human);
        }
    }

    private void addToWifes(Human human) {
        for (Human wife: human.getWifes()) {
            wife.addHusbands(human);
        }
    }

    private void addToHusbands(Human human) {
        for (Human husband: human.getHusbands()) {
            husband.addWifes(human);
        }
    }

    public Human getByName (String name) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}