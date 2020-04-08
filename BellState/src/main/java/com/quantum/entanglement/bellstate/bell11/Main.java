package com.quantum.entanglement.bellstate.bell11;

import com.gluonhq.strange.*;
import com.gluonhq.strange.gate.*;
import com.gluonhq.strange.local.*;
import com.gluonhq.strangefx.render.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
      runH11();
    }

	private static void runH11() {
		
		Program p = new Program(2);
		Step step1 = new Step();
		step1.addGate(new X(0));
		p.addStep(step1);
		Step step2 = new Step();
		step2.addGate(new Hadamard(0));
		step2.addGate(new X(1));
		p.addStep(step2);
		Step step3 = new Step();
		step3.addGate(new Cnot(0,1));
		p.addStep(step3);
		
        SimpleQuantumExecutionEnvironment sqee = new SimpleQuantumExecutionEnvironment();
		
		for (int i=0; i<10; i++){
			Result res = sqee.runProgram(p);
			Qubit[] qubits = res.getQubits();
			System.out.println(" iteration: " + i);
			Arrays.asList(qubits).forEach(q -> System.out.println("qubit with probability on 1 = "+q.getProbability()+", measured it gives "+ q.measure()));	
		}
	
        Renderer.renderProgram(p);
        Renderer.showProbabilities(p, 1000);
    }

}



