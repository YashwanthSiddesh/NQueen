import java.util.*;
public class QuEEn
{
public static int ac=0;
public static int n; 
public static int[][] a=new int[1000][1000];
public static boolean c(int p,int q)
{
    for(int i=0;i<n;++i)
    if(a[p][i]==1)
    return false;
     
    for(int i=0;i<n;++i)
    if(a[i][q]==1)
    return false;

    for(int i=0;i<n;++i)
    {
        for(int r=0;r<n;++r)
        if((i+r)==(p+q))
        if(a[i][r]==1)
        return false;
    }

    for(int i=p,r=q;i>=0 && r>=0;--i,--r)
         if (a[i][r]==1)
         return false;

         for(int i=p,r=q;i<n && r<n;++i,++r)
         if (a[i][r]==1)
         return false;

         return true;
}
public static boolean fill(int j){
    if(j==n)
    return true;
    for(int i=0;i<n;++i)
    if(c(i,j)){
        a[i][j]=1;
        if(fill(j+1)){
            if(j==n-1)
            {
                print();
                a[i][j]=0;
                break;
            }
        return true;
    }
        else
        a[i][j]=0;
    }
    return false;
}
public static void print()
{
    ++ac;int y=1;
    for(int i=0;i<n;++i){
       for(int r=0;r<n;++r){
        if(a[i][r]==y)
       System.out.print("Q | ");
       else
       System.out.print("  | ");
    }
       System.out.println();
       for(int t=0;t<(4*n);++t)
       System.out.print("-");
       System.out.println();
    }
    System.out.println();
    for(int t=0;t<(2*n);++t)
    System.out.print("!#");
    for(int o=0;o<2;++o)
    System.out.println();
   
}
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many no of queens (>3)");
        int l=sc.nextInt();n=l;
        int z[][]=new int[n][n];
        if(fill(0)){
        ac-=1;++ac;}
        System.out.println("------------>>>>>>> :There exist "+ac+" unique solutions of this problem: <<<<<<<-------------");
        }
}
