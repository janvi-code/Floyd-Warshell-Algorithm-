import java.util.*;
import java.lang.*;
public class allPairsShotestPath 
{
  final static int INF=9999;
  int v;
    allPairsShotestPath(int v)
    {
      this.v=v;
    }
    
    public void floydWarshell(int [][]graph)
    {
    	int dist[][]=new int[v][v];
    	for(int i=0;i<v;i++)
    		for(int j=0;j<v;j++)
    		dist[i][j]=graph[i][j];
    	
    	for(int k=0;k<v;k++)
    	{
    		for(int i=0;i<v;i++)
    		{
    			for(int j=0;j<v;j++)
    			{
    				if(dist[i][j]>dist[i][k]+dist[k][j] )
    					dist[i][j]=dist[i][k]+dist[k][j];
    			}
    		}
    	}
    	printSolution(dist);
    }
    
    void printSolution(int dist[][]) 
    { 
        System.out.println("The following matrix shows the shortest "+ 
                         "distances between every pair of vertices"); 
        for (int i=0; i<v; ++i) 
        { 
            for (int j=0; j<v; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
    
	public static void main(String args[])
	{
		int v=4;
		int graph[][]= {
						{0,5,INF,10},
						{INF,0,3,INF},
						{INF,INF,0,1},
						{INF,INF,INF,0}
			          };
		
		allPairsShotestPath path=new allPairsShotestPath(v);
		
		path.floydWarshell(graph);
	}
	
}
