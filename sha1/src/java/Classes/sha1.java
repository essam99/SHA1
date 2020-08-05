package Classes;

public class sha1 {
    
    public String get_SHA1(String message)
    {
        String binary = toBinary(message);
        String length = calculateLength(binary.length());
        int zeros = calculateZeros(binary.length());
        String messageBinary = concatenateMessage(binary, "1", zeros, length);
        int[] HexaArray = new int[messageBinary.length()/32];
        toHexa(HexaArray, messageBinary);
        String result = hash(HexaArray);
        return(result);
    }
    
    private String toBinary(String text)
    { 
        //convert character to ascii code (decimal)
        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        //convert ascii code to binary
        for (byte b : bytes)
        {
            for (int i = 0; i < 8; i++)
            {
                binary.append((b & 128) == 0 ? 0 : 1);
                // left shift(add zero at the end)
                b <<= 1;
            }
        }
        return binary.toString();
    }
    
    private String calculateLength(int binaryLength)
    {
        //convert integer to binary
        String tempLength = Integer.toBinaryString(binaryLength);
        StringBuilder sb = new StringBuilder(tempLength);
        //message length is stored in 64 bits
        int temp = 64 - tempLength.length();
        //add zeros at the start
        while (temp > 0)
        {
            sb.insert(0, 0);
            temp--;
        }
        return sb.toString();
    }
    
    private int calculateZeros(int binaryLength)
    {
        //512(block size) - 1(one padding) - 64(message size) = 447
        if (binaryLength > 447) 
        {
            int temp = binaryLength - 447;
            int counter = 2;
            while ( temp > 512)
            {
                temp -= 512;
                counter++;
            }
            
            return( (512 * counter) - 64 - 1 - binaryLength);
        }
        else
            return(447 - binaryLength);    
    }

    private String concatenateMessage(String binary, String one, int zeros, String length)
    {
        StringBuilder messageBinary = new StringBuilder(binary);
        messageBinary.insert(messageBinary.toString().length(), one);
        while (zeros > 0) 
        {
            messageBinary.insert(messageBinary.toString().length(), 0);
            zeros--;
        }
        messageBinary.insert(messageBinary.toString().length(), length);
        return messageBinary.toString();
    }

    private void toHexa(int[] array, String message)
    {
        for (int i = 0; i < message.length(); i+=32) 
        {
            //convert binary(base 2) to integer
            array[i/32] = Integer.valueOf(message.substring(i+1, i+32), 2);
            //convert integer to hexa
            if(message.charAt(i) == '1')
                array[i/32] |= 0X80000000;
            else
                array[i/32] |= 0X00000000;

        }
    }
    
     private String hash(int[] HexaArray)
    {
        int[] w = new int[80];
        int[] h = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0};
        int[] k = {0x5A827999, 0x6ED9EBA1, 0x8F1BBCDC, 0xCA62C1D6};
        
        for(int i = 0; i < HexaArray.length; i += 16) 
        {
            for(int j = 0; j <= 15; j++)
                w[j] = HexaArray[j + i];
            
            for (int j = 16; j <= 79; j++ ) 
                w[j] = leftShift(w[j - 3] ^ w[j - 8] ^ w[j - 14] ^ w[j - 16], 1);
            
            int A = h[0];
            int B = h[1];
            int C = h[2];
            int D = h[3];
            int E = h[4];
            int temp = 0;
            
            for ( int x = 0; x <= 79; x++ )
            {
                if (x <= 19)
                    temp = leftShift(A,5) + ((B&C)|((~B)&D)) + E + w[x] + k[0];
                else if (x <= 39)
                    temp = leftShift(A,5) + (B^C^D) + E + w[x] + k[1];
                else if (x <= 59)
                    temp = leftShift(A,5) + ((B&C)|(B&D)|(C&D)) + E + w[x] + k[2];
                else if (x <= 79)
                    temp = leftShift(A,5) + (B^C^D) + E + w[x] + k[3];
                
                E = D; 
                D = C;
                C = leftShift(B,30);
                B = A;
                A = temp;
            }
            
            h[0] += A;
            h[1] += B;
            h[2] += C;
            h[3] += D;
            h[4] += E;
        }
        
        String[] hLength = new String[5];
        String hash = "";
        
        for(int i = 0; i < hLength.length; i++)
        {
            hLength[i] = Integer.toHexString(h[i]);
            if(hLength[i].length() < 8)
            {
                StringBuilder hL = new StringBuilder(hLength[i]);
                hL.insert(0,0);
                hLength[i] = hL.toString();
            }
            hash += hLength[i];
        }
        
        return hash;
    }
     
    private int leftShift(int num, int shift)
    {
        return ((num << shift) | (num >>> (32 - shift)));  
    }
}