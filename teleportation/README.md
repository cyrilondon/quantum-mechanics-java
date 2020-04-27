## Teleportation algorithm

### Getting Started

- Install the jdk 11 from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Install maven from here [here](https://maven.apache.org/download.cgi)
- Run the program by invoking <code>mvn javafx:run</code> from the <code>teleportation</code> folder.

The [Main](src/main/java/com/quantum/teleportation/algorithm/Main.java) java class implements the teleportation algorithm as described in our article [The quantum teleportation algorithm](https://einsteinrelativelyeasy.com/index.php/quantum-mechanics/163-the-quantum-teleportation-algorithm)

<img src="src/main/resources/teleportation1.png"/>

### Algorithm

We assume that the first qubit (the top qubit q[0] in the above diagram) belongs to Alice and starts out in any `|phi>` state, since this is what the quantum teleportation algorithm assumes. 

The second qubit (q[1] in the same diagram) belongs to Alice as well. 

The first thing to do is to share an entangled state between Alice and Bob by applying a `Hadamard` gate on Alice's q[1] qubit and then performing a `Controlled-Not` gate on Bob's q[2] qubit.

<img src="src/main/resources/teleportation11.png"/>

In the lines below A stands for Alice and B stands for Bob, as the first qubit belongs to Alice (q[1] in the diagram above) and the second qubit belongs to Bob (q[2] in the diagram above).

<img src="src/main/resources/teleportation12.gif"/>

This is almost an `EPR` pair. To make it exactly an `EPR` pair, as we know we have to  perform a `C-NOT` gate, controlling on the first qubit. Doing so yields

<img src="src/main/resources/teleportation13.gif"/>

We now have **Alice and Bob sharing an EPR pair**.

The next step is to have Alice perform a `C-NOT` gate between her qubit `|phi>` and her half of the entangled pair.

<img src="src/main/resources/teleportation14.png"/>

or more formally

<img src="src/main/resources/teleportation15.png"/>

Note that the state of the entire system (Alice + Bob qubits) is

<img src="src/main/resources/teleportation16.gif"/>

If we express |phi> in terms of the computational basis states `|phi> = alpha |0> + beta |1>` with (alpha,beta) complex numbers, we get four terms describing the whole state

<img src="src/main/resources/teleportation17.gif"/>

This expression enables us to easily perform a `C-NOT` gate between the first and second qubits.  We are doing so by flipping the second qubit only if the first qubit is `|1>`, and we obtain the state:

<img src="src/main/resources/teleportation18.gif"/>

We now have to perform a `Hadamard` gate on the first qubit:

<img src="src/main/resources/teleportation19.png"/>

Reminding us that applying the `Hadamard` gate to the basis states, we get:

<img src="src/main/resources/teleportation20.gif"/>

so

<img src="src/main/resources/teleportation21.gif"/>

or by expanding

<img src="src/main/resources/teleportation22.gif"/>

We are done with all the gate operations we have to do before the measurement.

#### Alice's measurements and Bob's operations

<img src="src/main/resources/teleportation23.png"/>











