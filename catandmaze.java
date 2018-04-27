import java.util.Scanner;
public class catandmaze
{
static int n;
static int destination_x,destination_y;
static boolean isvalid(int maze[][],int x,int y)
{
if(x>=0&&x<n&&y>=0&&y<n&&maze[x][y]==1)
return true;
else
return false;
}
static boolean findpath(int [][]maze,int x,int y,int prev,int [][]solution)
{
if(x==destination_x&&y==destination_y)
{
return true;
}
if(isvalid(maze,x-1,y)&&prev!=2)
{
solution[x-1][y]=1;
if(findpath(maze,x-1,y,1,solution)==true)
return true;
}
if(isvalid(maze,x+1,y)&&prev!=1)
{
solution[x+1][y]=1;
if(findpath(maze,x+1,y,2,solution)==true)
return true;
}
if(isvalid(maze,x,y-1)&&prev!=4)
{
solution[x][y-1]=1;
if(findpath(maze,x,y-1,3,solution)==true)
return true;
}
if(isvalid(maze,x,y+1)&&prev!=3)
{
solution[x][y+1]=1;
if(findpath(maze,x,y+1,4,solution)==true)
return true;
}
solution[x][y]=0;
return false;
}
public static void main(String ...args)
{
int maze[][];
Scanner sc=new Scanner(System.in);
System.out.println("Enter the length of grid\n");
n=sc.nextInt();
maze=new int[n][n];
System.out.println("Enter the values of grid\n");
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
maze[i][j]=sc.nextInt();
}
}
System.out.println("Enter the start point\n");
int start_x=sc.nextInt();
int start_y=sc.nextInt();
System.out.println("Enter the destination point\n");
destination_x=sc.nextInt();
destination_y=sc.nextInt();
int solution[][]=new int[n][n];
solution[start_x][start_y]=1;
if(findpath(maze,start_x,start_y,-1,solution))
{
System.out.println("yes");
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
System.out.print(solution[i][j]);
}
System.out.print("\n");
}
}
else
System.out.println("NO");
}
}
