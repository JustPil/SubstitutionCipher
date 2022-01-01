package FCF;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a secret message: ");
        String message = scn.nextLine();
        System.out.print("Enter an integer to shift each character: ");
        int off = scn.nextInt();
        SubstitutionCipher demonstrationMessage = new SubstitutionCipher(message, off);
        System.out.print("Plaintext: ");
        demonstrationMessage.readPlain();
        demonstrationMessage.createCipher();
        System.out.print("\nCiphertext: ");
        demonstrationMessage.readCipher();
        System.out.print("Decrypted: ");
        StringBuilder sb = demonstrationMessage.decrypt();
        System.out.println(sb);
        scn.close();
    }
}
