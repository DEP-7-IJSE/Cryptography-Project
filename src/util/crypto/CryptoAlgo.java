package util.crypto;

/* Invoke the encrypt method and give parameters to it, when you want to encrypt,.
    * For the planText, give what you want to encrypt & to the key give what you want, but it will be your decrypt key.
*
* Invoke the decrypt method and give necessary parameters, when you want to decrypt which was encrypted by using this algorithm.
*   For the cipher you should give encrypted Text & for the key you should give key, which was you given for encryption.
* */

public class CryptoAlgo {

    public static String encrypt(String plainText, String key) {
        /* Let's combined the plain text and the key with @
        * Eg:
        * plainText = "dep"
        * key = "1234"
        * scrambledText = "dep@1234"
        * */
        plainText += "@" + key;
        /*Now let's reverse the whole thing with concat with "@@"
        * Eg:
        * scrambledText = "dep@1234"
        * reversedText = "@@4321@ped"
        * */
        String reversedText = "@@";

        for(int i = plainText.length() - 1; i >= 0; --i) {
            reversedText += plainText.charAt(i);
        }
        //Let's suffix "@!!" to reversedText
        reversedText += "@!!";
        String cipheText ="";
        /*Let's generate a secret key by getting ASCII number of each character and +127 to each character.
        *Specially +127 because to avoid adding character of DEL.
        */
        for(int i = 0; i < reversedText.length(); ++i) {
            int code = reversedText.charAt(i);
            code+= 127;
            char newChar = (char) code;
            cipheText += newChar;
        }
        //Let's add hashcode and get ASCII code its too.
        String hashCode= String.valueOf(cipheText.hashCode());
        for (int i = 0; i < hashCode.length(); i++) {
            int code = hashCode.charAt(i);
            code+= 127;
            char newChar = (char) code;
            cipheText += newChar;
        }
        //return concated additional characters to them
        return "^&*" + cipheText + "^%";
    }

    public static String decrypt(String cipher, String key) {
        //First of all we should check validity of entered cipher.
        if (cipher.length() < 15) {
            throw new RuntimeException("Invalid cipher");
        }
        /*Let's remove the characters which is added earlier, if entered cipher is valid.
        * So remove the hashcode and another characters we added separately.
        */
        String dec = cipher.substring(3, cipher.length() - 12);
        String reverseText = "";
        //Let's get real reversed text of what was we encrypted.
        for(int i = 0; i < dec.length(); ++i) {
            int code = dec.charAt(i);
            code-= 127;
            char originalChar = (char)code;
            reverseText += originalChar;
        }
        //Remove the another characters we added separately earlier.
        String gotreversedText = reverseText.substring(2, reverseText.length() - 3);
        //Split the raw reversed text from "@"
        String[] splitted = gotreversedText.split("@");
        String reversedKey = "";

        //Get the right key of cipher text
        for(int i = splitted[0].length() - 1; i >= 0; --i) {
            reversedKey += splitted[0].charAt(i);
        }
        //Let's check whether entered key is right.
        if (!reversedKey.equals(key)) {
            throw new RuntimeException("Invalid key");
        } else {
            //Let's get the real  text.
            String text = "";
            for(int i = splitted[1].length() - 1; i >= 0; --i) {
                text+= splitted[1].charAt(i);
            }
            return text;
        }
    }
}