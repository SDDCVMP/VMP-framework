package org.framework.iVMP;

import org.domain.PhysicalMachine;
import org.domain.VirtualMachine;

import java.util.List;


public class WorstFit {
    /**
     * Worst Fit
     *
     * @param vm               VirtualMachine
     * @param physicalMachines Physical Machines
     * @param virtualMachines  Virtual Machines
     * @param derivedVMs       Derived Virtual Machines
     * @param isMigration      Indicates if the VM is being migrated
     * @return <b>True</b>, if VM was successfully allocated
     */
    public static Boolean worstFit(VirtualMachine vm, List<PhysicalMachine> physicalMachines,
                                   List<VirtualMachine> virtualMachines, List<VirtualMachine> derivedVMs, Boolean isMigration) {

        return BestFit.bestOrWorstFit(false, vm, physicalMachines, virtualMachines, derivedVMs, isMigration);

    }


}
