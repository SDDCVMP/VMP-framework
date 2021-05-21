package org.framework.VMPr.configuration;

import org.domain.APrioriValue;
import org.domain.Placement;
import org.framework.VMPr.memeticAlgorithm.MASettings;
import org.framework.VMPr.memeticAlgorithm.MoMaVMP;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Leonardo Benitez
 */
public class StaticReconfMemeCall implements Callable<Placement> {

    private List<APrioriValue> aPrioriValuesList;
    private Placement actualPlacement;
    private MASettings settings;

    public StaticReconfMemeCall(Placement actualPlacement, List<APrioriValue> aPrioriValuesList, MASettings settings) {
        this.actualPlacement = actualPlacement;
        this.aPrioriValuesList = aPrioriValuesList;
        this.settings = settings;
    }

    @Override
    public Placement call() throws Exception {
        MoMaVMP memetic = new MoMaVMP();
        return memetic.reconfiguration(actualPlacement, aPrioriValuesList, settings);
    }
}

