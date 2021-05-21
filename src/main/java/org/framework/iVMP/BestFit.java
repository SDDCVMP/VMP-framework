package org.framework.iVMP;

import org.domain.PhysicalMachine;
import org.domain.VirtualMachine;
import org.framework.common.BestComparator;
import org.framework.common.WorstComparator;

import java.util.Collections;
import java.util.List;

public class BestFit {

    /**
     * Best Fit
     *
     * @param vm               VirtualMachine
     * @param physicalMachines Physical Machines
     * @param virtualMachines  Virtual Machines
     * @param derivedVMs       Derived Virtual Machines
     * @param isMigration      Indicates if the VM is being migrated
     * @return <b>True</b>, if VM was successfully allocated
     */
    public static Boolean bestFit(VirtualMachine vm, List<PhysicalMachine> physicalMachines,
                                  List<VirtualMachine> virtualMachines, List<VirtualMachine> derivedVMs, Boolean isMigration) {

        return bestOrWorstFit(true, vm, physicalMachines, virtualMachines, derivedVMs, isMigration);

    }

    /**
     * Best/Worst Fit
     *
     * @param isBest           Boolean
     * @param vm               VirtualMachine
     * @param physicalMachines Physical Machines
     * @param virtualMachines  Virtual Machines
     * @param derivedVMs       Derived Virtual Machines
     * @param isMigration      Indicates if the VM is being migrated
     * @return <b>True</b>, if VM was successfully allocated
     */
    public static Boolean bestOrWorstFit(Boolean isBest, VirtualMachine vm, List<PhysicalMachine> physicalMachines,
                                         List<VirtualMachine> virtualMachines, List<VirtualMachine> derivedVMs, Boolean isMigration) {

        if (isBest) {
            Collections.sort(physicalMachines, new BestComparator());
        } else {
            Collections.sort(physicalMachines, new WorstComparator());
        }

        if (iVMPConf.allocateVMToDC(vm, physicalMachines, virtualMachines, isMigration)) {
            return true;
        }

        derivedVMs.add(vm);

        return false;
    }


}
