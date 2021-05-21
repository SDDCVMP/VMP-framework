package org.framework.iVMP;

import org.domain.PhysicalMachine;
import org.domain.VirtualMachine;

import java.util.List;


public class FirstFit {
    /**
     * First Fit
     *
     * @param vm               VirtualMachine
     * @param physicalMachines Physical Machines
     * @param virtualMachines  Virtual Machines
     * @param derivedVMs       Derived Virtual Machines
     * @param isMigration      Indicates if the VM is being migrated
     * @return <b>True</b>, if VM was successfully allocated
     */
    public static Boolean firstFit(VirtualMachine vm, List<PhysicalMachine> physicalMachines,
                                   List<VirtualMachine> virtualMachines, List<VirtualMachine> derivedVMs, Boolean isMigration) {
        //System.out.println("FirstFit");
        if (iVMPConf.allocateVMToDC(vm, physicalMachines, virtualMachines, isMigration)) {
            return true;
        }
        // Set PM for derived VM to null
        derivedVMs.add(vm);
        return false;
    }


}
