package org.framework.iVMP;

import org.domain.PhysicalMachine;
import org.domain.VirtualMachine;
import org.framework.common.BestComparator;
import org.framework.common.Constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OpenStack {

    /**
     * OpenStack
     *
     * @param vm               VirtualMachine
     * @param physicalMachines Physical Machines
     * @param virtualMachines  Virtual MachinesV
     * @param derivedVMs       Derived Virtual Machines
     * @param isMigration      Indicates if the VM is being migrated
     * @return <b>True</b>, if VM was successfully allocated
     */
    public static Boolean openStack(VirtualMachine vm, List<PhysicalMachine> physicalMachines,
                                    List<VirtualMachine> virtualMachines, List<VirtualMachine> derivedVMs, Boolean isMigration) {

        List<PhysicalMachine> filtering = new ArrayList();

        //check PMs resources status (Filter Scheduler)
        for (PhysicalMachine pm : physicalMachines) {
            if (Constraints.checkResources(pm, null, vm, virtualMachines, false)) {
                //save pms that pass the first filter of ram, net and core
                filtering.add(pm);
            }
        }

        //make a comparison of weights between pms and normalize it
        Collections.sort(filtering, new BestComparator());
        //allocate in the largest weight
        if (iVMPConf.allocateVMToDC(vm, filtering, virtualMachines, isMigration)) {
            return true;
        }

        derivedVMs.add(vm);
        return false;

    }


}
