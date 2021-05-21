# Dynamic Virtual Machine Placement Simulation Framework

This project contains the source code and results of the following research:

Coming soon...
##  

To develop and execute the following items are required:

### To develop:

1. Maven 3 or greater
2. Java 8 (JDK 1.8)
3. Java IDE (e.g. eclipse, intellij, ...)

### To run:
The framework could be compile with maven.

1. Go to the project root and execute (Linux):
``` bash
$ mvn clean package
$ java -jar target/DynamicVMPFramework.jar inputs/ivmp.conf inputs/vmpr.conf inputs/scenarios.conf outputs/
```

##
#### Input File Structure: ivmp.conf
```
# defines the decision approach [1]. NULL indicates N/A. When set to Distributed, VMPr must be set to MMT
- APPROACH= [CENTRALIZED, DISTRIBUTED, NULL] 
# defines the iVMP algorithm: First-Fit (FF), Best-Fit (BF), Worst-Fit (WF), FF-Decreasing (FFD), BF-Decreasing (BFD), OpenStack (OS).
- iVMP= [FF, BF, WF, FFD, BFD, OS]
# defines the datacenter infrastructure considered [1]: DC1, DC2, DC3, DC4, DC5 
- PM_CONFIG= [PM_CONFIG_LOW_LOAD, PM_CONFIG_MED_LOAD, PM_CONFIG_HIGH_LOAD, PM_CONFIG_FULL_LOAD, PM_CONFIG_INS_LOAD]
# defines the parameter for the Leasing Costs (0.7 in [1]). 
- DERIVE_COST= [real number from 0 to 1]
# defines the protection factor for CPU, RAM and NETWORK overbooking [1]. 
- PROTECTION_FACTOR_01 = [real number from 0 to 1]
- PROTECTION_FACTOR_02 = [real number from 0 to 1]
- PROTECTION_FACTOR_03 = [real number from 0 to 1]
# defines the penalty factor for CPU, RAM and NETWORK SLA violations [1].
- PENALTY_FACTOR_01= [real number > 1]
- PENALTY_FACTOR_02= [real number > 1]
- PENALTY_FACTOR_03= [real number > 1]
# defines the scalarization method [1]: Euclidean Distance (ED), Manhathan Distance (MD), Chernobyl Distance (CD), Weighted Sum (WS).
- SCALARIZATION_METHOD= [ED, MD, CD, WS] 
```
##
#### Input File Structure: vmpr.conf
```
# define the VMPr algorithm: Memetic Algorithm (MA). When set to MMT, APPROACH must be set to DISTRIBUTED.
- VMPr= [MEMETIC, MMT]
# parameters of the VMPr Algorithm when using MEMETIC.
- POPULATION_SIZE=100
- INTERVAL_EXECUTION_MEMETIC=10
- NUMBER_GENERATIONS=100
- EXECUTION_DURATION=1
- LINK_CAPACITY=100
- MIGRATION_FACTOR_LOAD=10
# defines the VMPr Triggering method: Periodically or Prediction-Based [1].
- VMPr_TRIGGERING= [PERIODICALLY, PREDICTION-BASED]
# when using Prediction-Based VMPr Triggering method. See Section 5.3.3 in [1].
- FORECAST_SIZE=5
- HISTORICAL_DATA_SIZE=10
# defines the VMPr Recovering method: Cancelation or Update-Based [1].
- VMPr_RECOVERING= [CANCELLATION, UPDATE-BASED]
```

NOTE: inputs folder already have pre-configured files A1.conf to A32.conf based on [2]. This files must be passed as parameters with an empty vmpr.conf like:

``` bash
$ mvn clean package
$ java -jar target/DynamicVMPFramework.jar inputs/A1.conf inputs/vmpr.conf inputs/scenarios.conf outputs/
```

##
#### Output Files

The framework generates the following files:

- *economical_penalties*: Average economical penalties per each SLA violation. 
- *economical_revenue*: Average ecomical revenue per each VM hosted in the main provider.
- *leasing_costs*: Average economical revenue lost per each VM hosted in an alternative provider from federation.
- *power_consumption*: Average power energy consumed 
- *reconfiguration_call_times*: Number of reconfiguration calls.
- *wasted_resources*: Average of wasted resources (one column per resource)
- *wasted_resources_ratio*: Average of wasted resources (considering all resources)
- *scenarios_scores*: Score per each executed scenario.

##
#### References
- [1] López-Pires, F., Barán, B., Benítez, L., Zalimben, S., & Amarilla, A. (2018). Virtual machine placement for elastic infrastructures in overbooked cloud computing datacenters under uncertainty. Future Generation Computer Systems, 79, 830-848.
- [2] López-Pires, F., Barán, B., Pereira, C., Velázquez, M., & González, O. (2019). Evaluation of Two-Phase Virtual Machine Placement Algorithms for Green Cloud Datacenters. In 2019 IEEE 4th International Workshops on Foundations and Applications of Self* Systems (FAS* W) (pp. 62-67). IEEE.
