package org.framework.VMPr.memeticAlgorithm;

/**
 * @author Leonardo Benitez.
 */
public interface Mutation {

    Population mutate(Population population);

    Individual mutate(Individual individual);

}
