
## Entangled Bell State

### Getting Started

- Install the jdk 11 from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Install gradle from here [here](https://gradle.org/releases/)
- If you are using Linux or MacOS X, call the <code>run</code> task by invoking <code>./gradlew run</code> from <code>bellState</code> folder.
- If you are using Windows, call the <code>run</code> task by invoking <code>gradlew.bat run</code> from <code>bellState</code> folder.


This [Main](BellState/src/main/java/com/quantum/entanglement/bellstate/bell11/Main.java) java class implements a quantum circuit to illustrate the concept of entanglement with two qubits.

This first quantum program brings two qubits to one of the four simplest and maximal entangled two-qubit states, i.e the Bell state |B11>.

Namely, it implements the following quantum circuit:

<img src="https://einsteinrelativelyeasy.com/images/Quantum/CNOT_program1.png" >

which formally equates to:

<img src="https://einsteinrelativelyeasy.com/images/Quantum/Bellstate9.gif"/>

You can refer to this article [C-NOT gate, Bell State and Entanglement ](https://einsteinrelativelyeasy.com/index.php/quantum-mechanics/156-c-not-gate-bell-state-and-entanglement) on my website [einsteinrelativelyeasy.com](https://einsteinrelativelyeasy.com/) to refresh your memory about this formalism.

And you may also find it useful to read this article [Introduction-to-entanglement](https://einsteinrelativelyeasy.com/index.php/quantum-mechanics/147-introduction-to-entanglement) to give you an overall view of entanglement and to remind you that an entanglement state **can not be written as product state**.

### Program

This sample create a `Program` that requires 2 qubits via the instruction `Program p = new Program(2);`.

It create two steps (`step1` and `step2`).

The first step adds a Paul-X (NOT) Gate to the first qubit (index 0) via the line  `step1.addGate(new X(0))`. The first qubit then flips from |0> to |1>.

The second steps adds a Hadamard Gate `H` to the first qubit (index 0), and a NOT gate `X` to the second qubit  (index 1), so we get finally the two-qubit state H|11>. 

```
step2.addGate(new Hadamard(0));
step2.addGate(new X(1));
```

Both steps are added to the Program via
```
  p.addStep(step1);
  p.addStep(step2);
```
  
We then apply the CNOT gate on both qubits, which has for effect to invert the target (the second qubit) only when the control (the first qubit) is 1

```
Step step3 = new Step();
step3.addGate(new Cnot(0,1));
p.addStep(step3);
```
That's it. We only have to execute the program via

```
SimpleQuantumExecutionEnvironment sqee = new SimpleQuantumExecutionEnvironment();
Result res = sqee.runProgram(p);
```
 
### Running the Bellstate

Run this program simply by invoking (on Windows)
```
 > cd BellState
 > gradlew.bat run
```

1 First a nice graphical representation of the quantum circuit will show up with each qubit having 50% probability of being observed in the |0> state and so 50% probability of being observed in the |1> state.

<img src="https://einsteinrelativelyeasy.com/images/Quantum/CNOT_program42.png" />

2 However, this graphic does still not show the main interest of this quantum circuit, i.e. its entangled nature:
 the two-qubit states are never being observed as |00> or |11>.

To illustrate this fundamental feature, we use the last instruction line `Renderer.showProbabilities(p, 1000)` which gives the probabilities of the final measured states over 1000 runs: in our case, we measure 526 times |01> and 474 times |10>, but **we get a zero probability to observe either |00> and |11> states**.

<img src="https://einsteinrelativelyeasy.com/images/Quantum/CNOT_program51.png" />






