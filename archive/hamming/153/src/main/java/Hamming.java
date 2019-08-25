class Hamming {

   
String l;
String r;
Hamming(String leftStrand, String rightStrand) {
  l = leftStrand;
  r = rightStrand;
if(l.equals("") && r.equals("")){}
else{
if(l.equals("")){
throw new IllegalArgumentException("left strand must not be empty.");
}
if(r.equals("")){
throw new IllegalArgumentException("right strand must not be empty.");
    }
if(l.length() != r.length()){
throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length."); 
}
}
}

int getHammingDistance() {
int i = 0, count = 0;
while(i < l.length()){
  if(l.charAt(i) != r.charAt(i))
       count++;
  i++;
}
return count;

}
}
