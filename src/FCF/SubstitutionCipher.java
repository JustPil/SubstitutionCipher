package FCF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SubstitutionCipher
{
    private int shift;
    private StringBuilder ciphertext;
    private char[] charArray;
    private final String PLAINFILE = "Plain.dat";
    private final String CIPHERFILE = "Cipher.dat";
    private RandomAccessFile rafPlain;
    private RandomAccessFile rafCipher;
    private boolean cipherSet;

    /**
     * Constructor Sets a plaintext message into a character array and binary file. When writing the characters to
     * the binary file, the RandomAccessFile's file pointer increases by a long value of 2 due to each character
     * utilizing 2 bytes of space.
     * @param plain The plaintext message.
     * @param s The integer to add to each character of the message.
     * @throws IOException An I/O exception has occurred.
     */
    public SubstitutionCipher(String plain, int s) throws IOException
    {
        shift = s;
        rafPlain = new RandomAccessFile(PLAINFILE, "rw");
        long seeker = 0;
        charArray = plain.toCharArray();
        for(int i = 0; i < charArray.length; i++)
        {
            rafPlain.seek(seeker);
            rafPlain.writeChar(charArray[i]);
            seeker += 2;
        }
        rafPlain.close();
        cipherSet = false;
    }

    /**
     * createCipher Reads the binary file containing the plaintext one character at a time. Each character read is
     * written to a ciphertext binary file with the shift integer added, changing the ASCII value of each character.
     * @throws IOException An I/O exception has occurred.
     */
    public void createCipher() throws IOException
    {
        rafPlain = new RandomAccessFile(PLAINFILE, "r");
        rafCipher = new RandomAccessFile(CIPHERFILE, "rw");
        for(int i = 0; i < charArray.length; i++)
        {
            char ch = rafPlain.readChar();
            ch += shift;
            rafCipher.writeChar(ch);
        }
        rafPlain.close();
        rafCipher.close();
        cipherSet = true;
    }

    /**
     *readPlain Reads the plaintext message from the plaintext binary file.
     * @throws IOException An I/O exception has occurred.
     */
    public void readPlain() throws IOException
    {
        rafPlain = new RandomAccessFile(PLAINFILE, "r");
        for(int i = 0; i < charArray.length; i++)
        {
            char ch = rafPlain.readChar();
            System.out.print(ch);
        }
        rafPlain.close();
    }

    /**
     *readCipher Reads the ciphertext message from the ciphertext binary file.
     * @throws IOException An I/O exception has occurred.
     */
    public void readCipher() throws IOException
    {
        rafCipher = new RandomAccessFile(CIPHERFILE, "r");
        for(int i = 0; i < charArray.length; i++)
            System.out.print(rafCipher.readChar());
        System.out.println();
        rafCipher.close();
    }

    /**
     *decrypt Reads the ciphertext from the ciphertext binary file and decrypts the message by appending each
     * character to a StringBuilder with the shift integer subtracted, revealing the original message.
     * @return The decrypted message in a StringBuilder.
     * @throws IOException An I/O exception has occurred.
     */
    public StringBuilder decrypt() throws IOException
    {
        if(!cipherSet)
        {
            ciphertext = new StringBuilder();
            ciphertext.append("Error: There is no cipher set to decrypt.");
            return ciphertext;
        }
        ciphertext = new StringBuilder();
        rafCipher = new RandomAccessFile(CIPHERFILE, "r");
        for(int i = 0; i < charArray.length; i++)
        {
            char ch = rafCipher.readChar();
            ch -= shift;
            ciphertext.append(ch);
        }
        rafCipher.close();
        return ciphertext;
    }
}
