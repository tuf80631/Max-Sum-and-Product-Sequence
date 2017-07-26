package mss3;  
 import java.lang.Math;  
 import java.util.Scanner;  
 public class Mss3 {  
   private int [] a;  
   public static void main(String[] args) {  
     int number;  
     Scanner in = new Scanner(System.in);  
     number = in.nextInt();  
     Mss3 mss3 = new Mss3();  
     mss3.a= new int[number];  
     for (int i = 0; i<number;i++)  
     {  
       System.out.print("Position "+i+" : "); mss3.a[i]=in.nextInt();  
     }  
     int p1 = 0;  
     int p2 = mss3.a.length-1;  
     System.out.println(mss3.mss3(mss3.a,p1,p2));  
   }  
    public int mss3(int a[], int p1, int p2)  
    {  
      int maxProduct =1;  
      if (p1 == p2)  
      {  
        maxProduct = a[p1];  
      }  
      else  
      {  
        int m = (p1 + p2)/2;  
        int L = mss3(a,p1,m);int R = mss3(a,m+1,p2);  
        int prodlt = 1; int prodrt = 1; int PL = 0; int PR = 0;  
        int numberOfNegativeL = 0; int numberOfNegativeR = 0;  
        int lastPositionBeforeOddNegativeR =0;  
        int lastPositionBeforeOddNegativeL =0;  
        int lastProductBeforeOddNegativeR = 1;  
        int lastProductBeforeOddNegativeL = 1;  
        int lastProductBeforeEvenNegativeL = 1;  
        int lastProductBeforeEvenNegativeR = 1;  
        int lastPositionBeforeEvenNegativeL = 0;  
        int lastPositionBeforeEvenNegativeR = 0;  
        for (int i =m; i>=p1; i--)  
        {  
          if (a[i]!=0)  
          {prodlt = prodlt * a[i];  
          PL = prodlt;}  
          else  
          {  
          break;  
          }  
          if (a[i]<0)  
          {  
           numberOfNegativeL++;  
            if ((numberOfNegativeL%2)!=0)  
            {  
             lastPositionBeforeOddNegativeL = i;  
             lastProductBeforeOddNegativeL = PL;  
            }  
            if ((numberOfNegativeL%2)==0)  
            {  
              lastPositionBeforeEvenNegativeL = i;  
              lastProductBeforeEvenNegativeL = PL;  
            }  
          }  
        }  
        for (int i = m+1; i<=p2; i++)  
        {  
          if (a[i]!=0)  
          {prodrt = prodrt * a[i];  
          PR = prodrt;}  
          else  
          {  
            break;  
          }  
          if (a[i]<0)  
          {  
            numberOfNegativeR++;  
            if ((numberOfNegativeR%2)!=0)  
            {  
             lastPositionBeforeOddNegativeR = i;  
             lastProductBeforeOddNegativeR = PR;  
            }  
            if ((numberOfNegativeR%2)==0)  
            {  
              lastPositionBeforeEvenNegativeR = i;  
              lastProductBeforeEvenNegativeR = PR;  
            }  
          }  
        }  
        if ((numberOfNegativeL+numberOfNegativeR)%2==0)  
        {maxProduct = Math.max(Math.max(L,R),PL*PR);}  
        else  
        {  
          if ((numberOfNegativeR)%2!=0) //all product on left and product up til negative  
          {  
            int maxStraddleProduct1 =1;  
            int maxStraddleProduct2 =1;  
            int maxStraddleProduct3 =1;  
            if (a[lastPositionBeforeEvenNegativeL]!=0)  
            { maxStraddleProduct1 = PR*lastProductBeforeEvenNegativeL/a[lastPositionBeforeEvenNegativeL];}  
            if (a[lastPositionBeforeOddNegativeR]!=0)  
            { maxStraddleProduct2 = PL*lastProductBeforeOddNegativeR/a[lastPositionBeforeOddNegativeR];}  
            if (a[lastPositionBeforeEvenNegativeR]!=0)  
            {  
              maxStraddleProduct3 = PL*lastProductBeforeEvenNegativeR/a[lastPositionBeforeEvenNegativeR];  
            }  
            int maxStraddle = Math.max(maxStraddleProduct1, maxStraddleProduct2);  
            int maxStraddle2 = Math.max(maxStraddle,maxStraddleProduct3);  
            maxProduct = Math.max(Math.max(L,R),maxStraddle2);  
          }  
          if ((numberOfNegativeL)%2!=0)  
          {  
            int maxStraddleProduct1=1;  
            int maxStraddleProduct2=1;  
            int maxStraddleProduct3=1;  
            if (a[lastPositionBeforeEvenNegativeR]!=0)  
            { maxStraddleProduct1 = PL*lastProductBeforeEvenNegativeR/a[lastPositionBeforeEvenNegativeR];}  
            if (a[lastPositionBeforeOddNegativeL]!=0)  
            { maxStraddleProduct2 = PR*lastProductBeforeOddNegativeL/a[lastPositionBeforeOddNegativeL];}  
            if (a[lastPositionBeforeEvenNegativeR]!=0)  
            {  
              maxStraddleProduct3 = PL*lastProductBeforeEvenNegativeR/a[lastPositionBeforeEvenNegativeR];  
            }  
             int maxStraddle = Math.max(maxStraddleProduct1, maxStraddleProduct2);  
             int maxStraddle2 = Math.max(maxStraddle,maxStraddleProduct3);  
            maxProduct = Math.max(Math.max(L,R),maxStraddle2);  
          }  
        }  
      }  
      return maxProduct;  
    }  
 }  