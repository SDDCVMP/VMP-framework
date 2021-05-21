package org.domain;

import org.framework.Utils;
import org.framework.common.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a Physical Machine.
 *
 * @author Saul Zalimben.
 * @since 8/14/16.
 */
public class PhysicalMachine {

    private Integer id;

    private Integer powerMax;

    private List<Float> resources;

    private List<Float> resourcesRequested;

    private List<Float> utilization;

    private List<Float> resourcesReserved;

    /* Constructors **/

    /**
     * Constructor
     *
     * @param id        New ID
     * @param powerMax  Power Max
     * @param resources Resources
     */
    public PhysicalMachine(Integer id, Integer powerMax, List<Float> resources) {

        this.id = id + 1;
        this.powerMax = powerMax;
        this.resources = resources;
        this.resourcesRequested = new ArrayList<>();
        this.utilization = new ArrayList<>();
        this.resourcesReserved = new ArrayList<>();

        for (int i = 0; i < resources.size(); i++) {
            Float newResource = 0F;
            resourcesRequested.add(newResource);
            Float newUtilization = 0F;
            utilization.add(newUtilization);
            Float newResourceReserved = 0F;
            resourcesReserved.add(newResourceReserved);
        }
    }

    /**
     * Constructor
     *
     * @param id                 New ID
     * @param powerMax           Power Max
     * @param resources          Resources
     * @param resourcesRequested Requested Resources
     * @param utilization        Utilization
     * @param resourcesReserved  Reserved Resources
     */
    public PhysicalMachine(Integer id, Integer powerMax, List<Float> resources,
                           List<Float> resourcesRequested, List<Float> utilization, List<Float> resourcesReserved) {

        this.id = id;
        this.powerMax = powerMax;
        this.resources = resources;
        this.resourcesRequested = Utils.getListClone(resourcesRequested);
        this.utilization = Utils.getListClone(utilization);
        this.resourcesReserved = Utils.getListClone(resourcesReserved);
    }

    /* Getters and Setters */

    /**
     * Get PM by Id
     *
     * @param pmId             Physical Machine Id
     * @param physicalMachines List of PMs
     * @return Physical Machine
     */
    public static PhysicalMachine getById(Integer pmId, List<PhysicalMachine> physicalMachines) {

        for (PhysicalMachine pm : physicalMachines) {
            if (pm.getId().equals(pmId)) {
                return pm;
            }
        }
        return null;
    }

    /**
     * Create a copy of each PM in a list
     *
     * @param physicalMachines List of Virtual Machines
     * @return Copy of physicalMachines
     */
    public static List<PhysicalMachine> clonePMsList(List<PhysicalMachine> physicalMachines) {

        List<PhysicalMachine> clonePM = new ArrayList<>();

        physicalMachines.forEach(pm ->
                clonePM.add((PhysicalMachine) pm.clonePM()));

        return clonePM;
    }

    public Integer getPowerMax() {
        return this.powerMax;
    }

    public void setPowerMax(Integer powerMax) {
        this.powerMax = powerMax;
    }

    public List<Float> getResourcesRequested() {
        return this.resourcesRequested;
    }

    public void setResourcesRequested(List<Float> resourcesRequested) {
        this.resourcesRequested = resourcesRequested;
    }

    public List<Float> getUtilization() {

        return utilization;
    }

    public void setUtilization(List<Float> utilization) {

        this.utilization = utilization;
    }

    public List<Float> getResourcesReserved() {
        return this.resourcesReserved;
    }

    public void setResourcesReserved(List<Float> resourcesReserved) {
        this.resourcesReserved = resourcesReserved;
    }

    public List<Float> getResources() {

        return resources;
    }

    public void setResources(List<Float> resources) {

        this.resources = resources;
    }

    /* Methods */

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    /**
     * Print Physical Machine with {@link System#out}
     */
    public void printPM() {

        System.out.print(this.getUtilization().get(0) + "\t");
        System.out.print(this.getUtilization().get(1) + "\t");
        System.out.print(this.getUtilization().get(2) + "\t");
        System.out.print(this.getPowerMax());
        System.out.println();
    }

    /**
     * Update Physical Machine Resource
     *
     * @param resource       Resources index
     * @param newUtilization Delta Utilization
     */
    private void updateUtilizationResource(Integer resource, Float newUtilization) {

        this.getUtilization().remove(resource.intValue());
        this.getUtilization().add(resource, newUtilization);
    }

    /**
     * Updated ResourcesRequested of a Physical Machine
     *
     * @param resource      Resources index
     * @param vmResource    VM Resource
     * @param vmUtilization VM Utilization
     * @param operation     Operation
     */
    public void updateResource(Integer resource, Float vmResource, Float vmUtilization,
                               String operation) {

        Float deltaResource = vmResource * vmUtilization / 100;

        if ("SUM".equals(operation)) {
            Float newResource = deltaResource + this.getResourcesRequested().get(resource);
            Float newResourceReserved = this.getResourcesReserved().get(resource) + deltaResource + vmResource * (1 - vmUtilization / 100) * Parameter.PROTECTION_FACTOR.get(resource);
            this.getResourcesRequested().remove(resource.intValue());
            this.getResourcesRequested().add(resource, newResource);
            this.getResourcesReserved().remove(resource.intValue());
            this.getResourcesReserved().add(resource, newResourceReserved);
            return;
        }

        if ("SUB".equals(operation)) {
            Float newResource = this.getResourcesRequested().get(resource) - deltaResource;
            Float newResourceReserved = this.getResourcesReserved().get(resource) - (deltaResource + vmResource * (1 - vmUtilization / 100) * Parameter.PROTECTION_FACTOR.get(resource));
            this.getResourcesRequested().remove(resource.intValue());
            this.getResourcesRequested().add(resource, newResource);
            this.getResourcesReserved().remove(resource.intValue());
            this.getResourcesReserved().add(resource, newResourceReserved);
            return;
        }

        if ("MAX".equals(operation)) {
            this.getResourcesRequested().remove(resource.intValue());
            this.getResourcesRequested().add(resource, this.getResources().get(resource));
            this.getResourcesReserved().remove(resource.intValue());
            this.getResourcesReserved().add(resource, this.getResources().get(resource));
        }
    }

    /**
     * Get Physical Machine Weight
     *
     * @return weight
     */
    public Float getWeight() {

        Float weight = 0F;
        for (Float utilizationPM : this.getUtilization()) {
            weight += (1F - utilizationPM);
        }

        return weight;

    }

    /**
     * Update Physical Machine Utilization
     */
    private void updateUtilization() {

        for (int k = 0; k < this.getResources().size(); k++) {
            Float newUtilization = this.getResourcesRequested().get(k) / this.getResources().get(k);
            this.updateUtilizationResource(k, newUtilization);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.getResources().size(); i++) {
            sb.append(this.getResources().get(i)).append("\t");
        }
        sb.append(this.getPowerMax()).append("\n");

        return sb.toString();

    }

    /**
     * Create a copy of the Physical Machine
     *
     * @return Cloned Physical Machine
     */
    private PhysicalMachine clonePM() {

        return new PhysicalMachine(this.getId(), this.getPowerMax(), this.getResources(),
                this.getResourcesRequested(), this.getUtilization(), this.getResourcesReserved());

    }

    /**
     * Update Physical Machine Resources
     * <p>
     * - {@link Utils#SUM}: Increase the requested resources
     * - {@link Utils#SUB}: Decrease the requested resources.
     * </p>
     *
     * @param vm        Virtual Machine
     * @param operation Operation ({@link Utils#SUM} or {@link Utils#SUB})
     */
    public void updatePMResources(VirtualMachine vm, String operation) {

        for (int k = 0; k < this.getResources().size(); k++) {
            this.updateResource(k, vm.getResources().get(k), vm.getUtilization().get(k), operation);
        }
        this.updateUtilization();
    }

}
