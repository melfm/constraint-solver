package constraints;

import core.IntVariable;

public abstract class constraintArrayVariable extends Constraint{

	public constraintArrayVariable(IntVariable[][] arrayvariables) {
		
		for(int i=0; i < arrayvariables.length; ++i){
			for(int j = 0; j < arrayvariables[i].length; ++j){
				this.variables.add(arrayvariables[i][j]);
				arrayvariables[i][j].constraints().add(this);
				
			}
		}
		
	}
	
}
