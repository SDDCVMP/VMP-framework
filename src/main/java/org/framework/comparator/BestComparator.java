/*
 * Virtual Machine Placement: Overbooking and Elasticity
 * Author: Rodrigo Ferreira (rodrigofepy@gmail.com)
 * Author: Saúl Zalimben (szalimben93@gmail.com)
 * Author: Leonardo Benitez  (benitez.leonardo.py@gmail.com)
 * Author: Augusto Amarilla (agu.amarilla@gmail.com)
 * 30/8/2016.
 */

/*
 * Virtual Machine Placement: Overbooking and Elasticity
 * Author: Rodrigo Ferreira (rodrigofepy@gmail.com)
 * Author: Saúl Zalimben (szalimben93@gmail.com)
 * Author: Leonardo Benitez  (benitez.leonardo.py@gmail.com)
 * Author: Augusto Amarilla (agu.amarilla@gmail.com)
 * 28/8/2016.
 */

package org.framework.comparator;

import org.domain.PhysicalMachine;

import java.util.Comparator;

/**
 * Compares {@link PhysicalMachine} by Weight (Best Comparator)
 *
 * @author Saul Zalimben.
 * @since 8/28/16.
 */
public class BestComparator implements Comparator<PhysicalMachine> {

    public BestComparator() {
        // Default Constructor
    }

    @Override
    public int compare(final PhysicalMachine pm1, final PhysicalMachine pm2) {

        return pm1.getWeight().compareTo(pm2.getWeight());

    }
}
