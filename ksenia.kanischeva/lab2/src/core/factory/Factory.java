package core.factory;

import core.illnesses.AbstractIllness;
import java.util.List;

public interface Factory {
    List<AbstractIllness> getList();
}
