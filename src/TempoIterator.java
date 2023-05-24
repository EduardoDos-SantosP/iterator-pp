import java.util.Iterator;
import java.util.Random;

public class TempoIterator implements Iterator<Object> {
    private Object vida = 0;
    private Object nextValue = null;
    private boolean morreu = false;

    @Override
    public boolean hasNext() {
        System.out.println("vida: " + vida);

        if (!morreu && nextValue == null) nextValue = generateNextValue();
        var value = !morreu && nextValue != null;
        System.out.println("Possui próximo: " + value);
        return value;
    }

    @Override
    public Object next() {
        System.out.println("vida: " + vida);

        if (nextValue == null)
            return generateNextValue();
        var current = nextValue;
        nextValue = null;
        return current;
    }

    private Object generateNextValue() {
        if (vida == null) return 0;

        double potencia = Math.pow(2, (int)vida + 1);
        double percentBase = (potencia - 1) / potencia;
        double chanceMorrer = Math.pow(percentBase, 6);

        System.out.println("Chance de morrer: " + chanceMorrer);
            
        var novaVida = new Random().nextDouble() <= chanceMorrer 
            ? null 
            : (int)vida + 1;

        if (novaVida == null) {
            morreu = true;
            System.out.println("Morreu aos " + vida);
        }
        vida = novaVida;

        return vida;
    }
}
