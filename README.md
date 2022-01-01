# SubstitutionCipher
Summary
This program encrypts and decrypts a message via substitution cipher.

Design

The user is prompted to enter a message, which is written to a binary file in byte format. This serves as the "plaintext." The message is read and written to a new binary file with a user-supplied integer value added to each character, changing the ASCII value. This obscures the original message and serves as a "ciphertext." The enciphered message is displayed to the user. The ciphertext file is opened and decrypted by subtracting the ASCII value from every character, displaying the original message.

The RandomAccessFile library is used to create, read, and write data in a binary file .dat extension. The binary files store data as binary numbers, so each character of the message will be stored in bits. The RandomAccessFile class uses a File Pointer to track the binary location. In the case of characters, we advance the File Pointer by 2, as a character takes up 2 bits of space.
