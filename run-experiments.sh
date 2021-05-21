#!/bin/sh


##directory where jar file is located    
dir=target

##jar file name
jar_name=DynamicVMPFramework.jar

for i in {1..10}
do
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A1.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_1_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A2.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_2_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A3.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_3_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A4.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_4_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A5.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_5_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A6.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_6_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A7.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_7_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A8.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_8_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A9.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_9_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A10.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_10_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A11.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_11_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A12.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_12_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A13.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_13_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A14.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_14_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A15.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_15_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A16.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_16_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A17.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_17_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A18.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_18_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A19.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_19_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A20.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_20_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A21.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_21_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A22.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_22_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A23.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_23_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A24.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_24_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A25.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_25_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A26.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_26_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A27.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_27_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A28.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_28_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A29.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_29_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A30.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_30_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A31.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_31_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A32.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_32_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A33.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_33_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A34.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_34_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A35.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_35_INS_$i/
java -Xms8192m -Xmx8192m -jar $dir/$jar_name inputs/A36.conf inputs/vmpr.conf inputs/scenarios.conf oi$i/_36_INS_$i/
done
