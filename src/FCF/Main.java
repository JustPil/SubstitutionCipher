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
        /*char[] array = createPlain();
        readPlain(array);
        createCipher(array);
        readCipher(array);
        decrypt(array);*/
    }

    /**
     * createPain Creates a binary file of a plaintext message supplied by user input.
     * @return Returns a character array of the plaintext message.
     * @throws IOException Detects if a specified file exists.
     */
 /*   public static char[] createPlain() throws IOException
    {
        System.out.println("CREATING PLAIN");
        RandomAccessFile raf = new RandomAccessFile("Plain.dat", "rw");
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a message in plaintext: ");
        String code = scn.nextLine();
        scn.close();
        long seeker = 0;
        char arr[] = code.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            raf.seek(seeker);
            raf.writeChar(arr[i]);
            seeker += 2;
        }
        raf.close();
        System.out.println("Plaintext file created. Check Your folder for Plain.dat\n");
        return arr;
    }

    /**
     * readPlain Reads the message from the plaintext binary file.
     * @param a The character array of the message.
     * @throws IOException Detects if a specified file exists.
     */
/*    public static void readPlain(char[] a) throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("Plain.dat", "r");
        System.out.println("READING PLAINTEXT: ");
        for(int i = 0; i < a.length; i++)
        {
            char ch = raf.readChar();
            System.out.print(ch);
        }
        raf.close();
    }

    /**
     * createCipher Creates a ciphertext binary file containing the ASCII characters of the plaintext with 10 added
     * to each charater.
     * @param a The character array of the message.
     * @throws IOException Detects if a specified file exists.
     */
/*    public static void createCipher(char[] a) throws IOException
    {
        System.out.println("\n\nCREATING CIPHER");
        RandomAccessFile raf1 = new RandomAccessFile("Plain.dat", "r");
        RandomAccessFile raf2 = new RandomAccessFile("Cipher.dat", "rw");
        for(int i = 0; i < a.length; i++)
        {
            char ch = raf1.readChar();
            ch += 10;
            raf2.writeChar(ch);
        }
        raf1.close();
        raf2.close();
        System.out.println("Ciphertext file created. Check folder for Cipher.dat\n");
    }

    /**
     *readCipher Reads the message from the ciphertext binary file.
     * @param a The character array of the message.
     * @throws IOException Detects if a specified file exists.
     */
/*    public static void readCipher(char[] a) throws IOException
    {
        System.out.println("READING CIPHER");
        RandomAccessFile raf = new RandomAccessFile("Cipher.dat", "r");
        for(int i = 0; i < a.length; i++)
            System.out.print(raf.readChar());
        System.out.println();
        raf.close();
    }

    /**
     *decrypt Reads the message from the ciphertext binary file and subtracts 10 from each character, which are
     * stored in a StringBuilder to output the decrypted message.
     * @param a The character array of the message.
     * @throws IOException Detects if a specified file exists.
     */
/*    public static void decrypt(char[] a) throws IOException
    {
        System.out.println("\nDECRYPTION");
        StringBuilder str = new StringBuilder();
        RandomAccessFile raf = new RandomAccessFile("Cipher.dat", "r");
        for(int i = 0; i < a.length; i++)
        {
            char ch = raf.readChar();
            ch -= 10;
            str.append(ch);
        }
        raf.close();
        System.out.println(str);
    }*/
}
