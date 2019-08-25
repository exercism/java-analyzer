import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Hamming {
	
	private Strand left;
	private Strand right;

     Hamming(String leftStrandContent, String rightStrandContent) {
    	super(); 	    	    			
		left = new Strand(Strand.Side.LEFT, leftStrandContent);
		right = new Strand(Strand.Side.RIGHT, rightStrandContent);			
		new Validator(left, right).validate();
	}    

	int getHammingDistance() {	
		
		if(this.left.equals(this.right))
			return 0;
		
		if(this.left.getLength() == 1 && this.right.getLength() == 1)
			return 1;			
				
        return new Distance(this.left, this.right).calculate();
    }
	
	private static class Distance{
		
		private List<Pair> pairs;
				
		 Distance(Strand left, Strand right) {
			
			super();
			
			this.pairs = new ArrayList<Pair>();
			
			List<Character> leftChars = left.toChars();
			List<Character> rightChars = right.toChars();
			
			for(int i=0; i<leftChars.size(); i++) {
				
				pairs.add(new Pair(leftChars.get(i), rightChars.get(i)));				
				
			}
		}
		
		int calculate() {			
			
			Long hammingDistance = getPairs().stream().filter( pair -> ! pair.getLeft().equals(pair.getRight())).count();
			
			return hammingDistance.intValue();
			
		}
		
		List<Pair> getPairs() {			
			return pairs;
		}
		
		private static class Pair{
			
			private Character left;
			private Character right;
			
			 Pair(Character left, Character right) {
				super();
				this.left = left;
				this.right = right;
			}
			
			 Character getLeft() {
				return left;
			}
			
			 Character getRight() {
				return right;
			}
					
		}		
	}	
		
	private static class Validator{
		
		private Strand left;
		private Strand right;
		
		 Validator(Strand left, Strand right) {
			super();
			this.left = left;
			this.right = right;
		}
		
		Strand findEmptyStrand() {
			
			if(left.getContent().isEmpty())
				return this.left;
			
			return this.right;
			
		}
		
		boolean isOneStrandAtLeastEmpty() {
			
			return (this.left.isEmpty() && !this.right.isEmpty()) 
					|| (!this.left.isEmpty() && this.right.isEmpty());
		}
		
		boolean isStrandsEmpty(){
			
			return this.left.isEmpty() || this.right.isEmpty();
		}
		
		boolean isStrandsLengthEqual() {
			
			return this.left.getLength() == this.right.getLength();
		}
		
				
		boolean validate() {
			
			if(!isStrandsEmpty()) {
				
				if(!isStrandsLengthEqual()) {
		    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
				
				}			
			}
			else {
				
				if(isOneStrandAtLeastEmpty())
				
					throw new IllegalArgumentException(findEmptyStrand().getSide().getLabel() +" strand must not be empty.");
							
			}
			
			return true;
		}
		
		
	};
	
	private static class Strand{
		private Side side;
		private String content;	
		
		enum Side{
			LEFT, RIGHT;
			
			String getLabel() {
				return this.name().toLowerCase();
			}
		}
		
		Strand(Side side, String content) {
			super();	    		    	
			this.side = side;			
			this.content = content;
		}
		
		String getContent() {
			return content;
		}
		
		boolean isEmpty() {
			return content.isEmpty();
		}
		
		Side getSide() {
			return side;
		}
		
		int getLength() {
			return this.content.length();
		}
		
		List<Character> toChars(){
			
			return content.chars().mapToObj(x -> (char) x ).collect(Collectors.toList());
			
		}

		@Override
		public
		 int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((content == null) ? 0 : content.hashCode());
			return result;
		}

		@Override
		public
		 boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Strand other = (Strand) obj;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			return true;
		}	
	}

}
