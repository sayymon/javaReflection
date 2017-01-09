class Data{
		private int dia; 
		private int mes; 
		private int ano; 
		
		Data(int dia,int mes,int ano){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;

			if(!validaData(dia,mes,ano)){
				throw new IllegalArgumentException("Data Invalida " + getFormatada());	
			}
		}
		
		String getFormatada(){
			return this.dia+"/"+this.mes+"/"+this.ano;
		}
		
		public int getDia(){return this.dia;}
		public int getMes(){return this.mes;}
		public int getAno(){return this.ano;}
		
		public void setDia(int dia){ this.dia = dia    ;}
		public void setMes(int mes){ this.mes = mes    ;}
		public void setAno(int ano){ this.ano = ano    ;}

		private boolean validaData(int dia,int mes,int ano){
			boolean validaData = true;			
			if(dia <= 0 && mes <= 0 && ano <= 0){
				validaData = false;
			}else if(mes == 2){ 
				//Verifica ano Bissexto
				if((ano % 4 == 0 && dia > 29) || dia > 28){
					validaData = false;
				}
			}//Entre outras validações de data
			
			return validaData;
		}

		
}

class TestaDataInvalida{
	public static void main(String... vargs){
		new Data(31,2,2017);
	}
}