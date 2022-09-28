package impl.factory;

import core.factory.Factory;
import core.illnesses.AbstractIllness;
import impl.illnesses.Cold;
import impl.illnesses.Malaria;
import impl.illnesses.Scoliosis;
import impl.illnesses.Tuberculosis;

import java.util.ArrayList;
import java.util.List;

public class FactoryImpl implements Factory {
    final List<AbstractIllness> illnesses = new ArrayList<>();

    public FactoryImpl(){
        illnesses.addAll((List.of(new Cold(), new Malaria(), new Scoliosis(), new Tuberculosis())));
    }

    @Override
    public List<AbstractIllness> getList() {
        return illnesses;
    }
}
