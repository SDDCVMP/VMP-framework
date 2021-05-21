package org.framework.VMPr.mmtAlgorithm;

import org.domain.PhysicalMachine;
import org.domain.VirtualMachine;
import org.framework.DynamicVMP;
import org.framework.Utils;
import org.framework.common.Constraints;

import java.util.*;

public class MinimumMigrationTime {

    public static ArrayList<VirtualMachine> minimumMigrationTime(List<PhysicalMachine> physicalMachines,
                                                                 Integer heuristicCode,
                                                                 List<VirtualMachine> virtualMachines,
                                                                 List<VirtualMachine> derivedVMs,
                                                                 List<VirtualMachine> vmsToMigrateFromPM,
                                                                 List<VirtualMachine> vmsToMigrate) {
        List<VirtualMachine> vmsInPM;

        for (PhysicalMachine pm : physicalMachines) {
            vmsInPM = Utils.filterVMsByPM(virtualMachines, pm.getId());
            if (Constraints.isPMOverloaded(pm) && !vmsInPM.isEmpty()) {
                vmsToMigrateFromPM.clear();
                //the physical machine is overloaded, select the vms to migrate from this pm
                vmsToMigrateFromPM = Utils.getVMsToMigrate(pm, vmsInPM);
                //move virtual machines selected
                DynamicVMP.runHeuristics(heuristicCode, physicalMachines, virtualMachines, derivedVMs,
                        vmsToMigrateFromPM);
                //add virtual machines selected to a list of migration
                vmsToMigrate.addAll(vmsToMigrateFromPM);
            } else if (Constraints.isPMUnderloaded(pm) && !vmsInPM.isEmpty()) {
                vmsToMigrateFromPM.clear();
                //the physical machine is underloaded, move all the virtual machine from this pm
                vmsToMigrateFromPM.addAll(vmsInPM);
                //move virtual machines
                DynamicVMP.runHeuristics(heuristicCode, physicalMachines, virtualMachines,
                        derivedVMs, vmsToMigrateFromPM);
                //add virtual machines to a list of migration
                vmsToMigrate.addAll(vmsToMigrateFromPM);
            }
        }

        return (ArrayList<VirtualMachine>) vmsToMigrate;


    }
}

//PhysicalMachine
//physicalMachines
//heuristicCode
//virtualMachines
//derivedVMs
