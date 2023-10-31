public class CBC {
    //初始向量 
    static String IV  = "1010101010101010";
    

    public static String CBCcipher(String Begin, String Key) {
        int length = Begin.length();
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char change = Begin.charAt(i);
            int asciiValue = (int) change;
            String Binary = ASCII.decimalToBinary(asciiValue);
            Binary = RoundKey.key_addition(IV, Binary);
            String Binary_en = Cipher.cipher(Binary, Key);
            IV = Binary_en;
            out.append(Binary_en);
        }
        return out.toString();
    }

    public static String CBCdecipher(String Begin, String Key) {
        String IVB = "1010101010101010";
        int length = Begin.length();
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char change = Begin.charAt(i);
            int asciiValue = (int) change;
            String Binary = ASCII.decimalToBinary(asciiValue);
            String Binary_en = Decipher.decipher(Binary, Key);
            Binary_en = RoundKey.key_addition(IVB, Binary_en);
            IVB = Binary;
            out.append(Binary_en);
        }
        return out.toString();
    }
}
