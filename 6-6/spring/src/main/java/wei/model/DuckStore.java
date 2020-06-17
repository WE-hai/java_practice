package wei.model;

import java.util.List;

public class DuckStore {
    List<Duck> ducks;

    @Override
    public String toString() {
        return "DuckStore{"+"ducks"+ducks+"}";
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }
}
