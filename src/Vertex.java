import java.util.Objects;

public class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;

        Vertex other = (Vertex) obj;
        return Objects.equals(label, other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}