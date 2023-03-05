import java.util.Comparator;

public class BaseClassComparator implements Comparator<Base> {
    @Override
    public int compare(Base first, Base second) {
        return first.getValue() - second.getValue();
    }
}
