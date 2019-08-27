class Hamming extends Main{
    public void functionHamming(){
        int hammingDistance = 0;
        String string1 = "rameshgangwar";
        String string2 = "gangwarramesh";
        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();
        if( string1.length() != string2.length()){
            System.out.println("Strings are of different length. So, test is " +
                    "invalid");
        } else {
            for(int i = 0; i< string1.length(); i++){
                if(array1[i] != array2[i]){
                    hammingDistance = hammingDistance + 1;
                }
            }
            System.out.println(hammingDistance);
        }
    }
}
