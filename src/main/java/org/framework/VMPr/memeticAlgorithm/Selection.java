package org.framework.VMPr.memeticAlgorithm;

import java.util.List;

/**
 * @author Leonardo Benitez.
 */
public interface Selection {

    List<Individual> select(Population population, int arity);

    Individual select(Population population);

}
