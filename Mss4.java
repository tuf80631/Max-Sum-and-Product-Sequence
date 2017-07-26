package mss4;  
 import java.util.Scanner;  
 public class Mss4 {  
   private int [] a;  
   public static void main(String[] args) {  
     int number;  
     Scanner in = new Scanner(System.in);  
     number = in.nextInt();  
     Mss4 mss4 = new Mss4();  
     mss4.a= new int[number];  
     for (int i = 0; i<number;i++)  
     {  
       System.out.print("Position "+i+" : "); mss4.a[i]=in.nextInt();  
     }  
     int p1 = 0;  
     int p2 = mss4.a.length-1;  
     System.out.println(mss4.mss4(mss4.a,p1,p2));  
   }  
   public int mss4(int a[], int p1, int p2)  
   {  
     int maxsum = 0; int sum = 0; int i = p1;  
     int minPosition = -1;  
     int maxPosition = -1;  
     int prevMinPosition = -1;  
     int prevMaxPosition = -1;  
     int prevMax = 0;  
     boolean foundGreaterThan0Sum = false;  
     while (i <= p2)  
     {  
       sum = sum + a[i];  
       if(foundGreaterThan0Sum){  
         if(sum > 0 && minPosition == -1){  
           minPosition = i;  
           maxPosition = i;  
         }  
       }  
       if (sum > maxsum)  
       {  
         maxsum = sum;  
         if(minPosition < 0){  
           minPosition = i;  
           maxPosition = i;  
           foundGreaterThan0Sum = true;  
         }  
         else{  
           maxPosition = i;  
         }  
       }  
       else if (sum < 0)  
       {  
         sum = 0;  
         if(foundGreaterThan0Sum){  
           prevMinPosition = minPosition;  
           prevMaxPosition = maxPosition;  
           prevMax = maxsum;  
           minPosition = -1;  
           maxPosition = -1;  
         }  
       }  
       i++;  
     }  
     if(prevMax == maxsum){  
       minPosition = prevMinPosition;  
       maxPosition = prevMaxPosition;  
     }  
     System.out.println("start sequence:" + minPosition);  
     System.out.println("end sequence:" + maxPosition);  
     return maxsum;  
   }  
 }  