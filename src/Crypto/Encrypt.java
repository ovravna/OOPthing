package Crypto;

// Æ lagde den hær den 31.01.2016.
public class Encrypt {
    private int encryptor;

    public Encrypt() {



    }

    public String getEncrypted(String encryptText) {
        this.encryptor = getPrime(encryptText.length());
        String returnString = "";
        for (int i = 0;i < encryptText.length();i++) {
            int charVal = (int) encryptText.charAt(i);
            int tempVal = (i*i+1)*charVal-(11-i)*encryptor;
            returnString += (char) tempVal;
        }
        return returnString;

    }

    public String getDecrypter(String decryptText) {
        this.encryptor = getPrime(decryptText.length());
        String returnString = "";
        for (int i = 0;i < decryptText.length();i++) {
            int charVal = (int) decryptText.charAt(i);
            int newVal = (charVal+(11-i)*encryptor)/(i*i+1);
            returnString += (char) newVal;
        }
        return returnString;
    }





    public int getPrime(int num) {
        // returns lowest prime higher then num
        boolean isPrime;
        for (int i = (num%2 == 0) ? num+1:num;true;i += 2) {
            isPrime = true;
            for (int j = 3;j < i;j += 2) {
                if (i%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                return i;
            }

        }

    }


}
