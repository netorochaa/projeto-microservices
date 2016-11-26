package br.unipe.funcionario.domain;

public enum EnumCargo {
	
	PROGRAMADOR("PROGRAMADOR"), ANALISTA("ANALISTA"), GERENTE("GERENTE");
	
	private final String cargo;
	
	EnumCargo (String cargo){	
		this.cargo = cargo.toUpperCase();
	}

	public String getCargo() {
		return cargo;
	}

	public static String getMessageError() {
		
		String msg = "Os cargos disponíveis para um funcionário são: ";
		
		int qtdCargos = EnumCargo.values().length;
		int cont = 0;
		
		for(EnumCargo cargo : EnumCargo.values()){
			cont++;
			
			msg += cargo.getCargo();
			
			if(cont != qtdCargos){
				msg += ", ";
			}
		}
		
		return msg;
		
	}
	
	
}
