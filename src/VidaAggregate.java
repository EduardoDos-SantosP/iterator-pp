import java.util.Iterator;

public class VidaAggregate implements Iterable {

    @Override
    public Iterator iterator() {
        return new TempoIterator();
    }
    
}
