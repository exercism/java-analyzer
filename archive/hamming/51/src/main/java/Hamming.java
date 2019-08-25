class Hamming {

String leftStrand;
String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        
			this.leftStrand=leftStrand;
			this.rightStrand=rightStrand;
			int distance= getHammingDistance();
				
    }

    int getHammingDistance(){
		int distance=0;
		
		if (leftStrand.length() != rightStrand.length()){
			if (rightStrand.length()<=0 )
					throw new IllegalArgumentException("right strand must not be empty.");
			else if (leftStrand.length()<=0)
				throw new IllegalArgumentException("left strand must not be empty.");

			else
				throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");	
		}					
		else{
			
				for (int i=0; i<leftStrand.length(); i++){
				
					if (leftStrand.charAt(i) != rightStrand.charAt(i)) 
						distance++;
				}
			}
		
		return distance;
		
    }

}
