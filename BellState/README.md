# quantum-mechanics-java
Provides java implementation of some well-known quantum algorithms.
As for now, provides implementations of:
- Entangled Bell State
- Teleportation algorithm

## Getting Started

- Install the jdk 11 from here
- Install gradle from here
- If you are using Linux or MacOS X, call the <code>run</code> task by invoking <code>./gradlew run</code>
- If you are using Windows, call the <code>run</code> task by invoking <code>gradlew.bat run</code>


## Entangled Bell State

This [Main] (src/main/java/com/quantum/entanglement/bellstate/bell11/Main.java) java class implements the quantum circuit to get one of the four entangled Bell states, i.e |B11>.

Namely, it implements the following quantum circuit

<img src="https://einsteinrelativelyeasy.com/images/Quantum/CNOT_program1.png" >

which formally equates to:

<img src="https://einsteinrelativelyeasy.com/images/Quantum/Bellstate9.gif"/>

You can refer to this [page](https://einsteinrelativelyeasy.com/index.php/quantum-mechanics/156-c-not-gate-bell-state-and-entanglement) from einsteinrelativelyeasy.com to refresh your mind about this formalism.

