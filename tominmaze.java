import java.util.*;
class tominmaze
{
static int track(int steps,int x,int y,int prev,int a[][],int n)
{
int k,l,o,p;
k=32767;
l=32767;
o=32767;
p=32767;
if(x==0&&y==0)
{
return steps;
}
if(x-1>=0)
{
if(a[x-1][y]==1&&prev!=2)
{
k=track(steps+1,x-1,y,1,a,n);
}
}
if(x+1<n)
{
if(a[x+1][y]==1&&prev!=1)
{
l=track(steps+1,x+1,y,2,a,n);
}
}
if(y-1>=0)
{
if(a[x][y-1]==1&&prev!=4)
{
o=track(steps+1,x,y-1,3,a,n);
}
}
if(y+1<n)
{
if(a[x][y+1]==1&&prev!=3)
{
p=track(steps+1,x,y+1,4,a,n);
}
}
if(k==32767&&l==32767&&o==32767&&p==32767)
return 32767;
else
{
if(k<l&&k<o&&k<p)
{
System.out.println("Down");
return k;
}
if(l<o&&l<p)
{
System.out.println("UP");
return l;
}
if(o<p)
{
System.out.println("RIGHT");
return o;
}
else
{
System.out.println("LEFT");
return p;
}
}
}
public static void main(String ...args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the size of grid");
int n=sc.nextInt();
int i,j;
int array[][]=new int[n][n];
for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
array[i][j]=sc.nextInt();
}
}

int m;int c;
int min;
System.out.println("Enter destination point");
m=sc.nextInt();
c=sc.nextInt();
min=track(0,m,c,-1,array,n);
System.out.println(min);
}
}
