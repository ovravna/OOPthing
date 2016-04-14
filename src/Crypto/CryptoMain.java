package Crypto;

public class CryptoMain {
    public static void main(String[] args) {

        Encrypt encrypt = new Encrypt();

        String text = "kake er godt og kult";
        System.out.println(text.length());
        text = encrypt.getEncrypted(text);
        System.out.println(text);
        text = encrypt.getDecrypter(text);
        System.out.println(text);
    }

}
