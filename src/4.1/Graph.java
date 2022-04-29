import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Graph{

    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        // Create uninitialized graph
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v=0; v<V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(String file_path){
        // Read graph from file
        try{
            String buffer;
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            // Parse first two lines as V and E, and allocate adj array
            buffer = br.readLine();
            V = Integer.parseInt(buffer);
            buffer = br.readLine();
            int E_expected = Integer.parseInt(buffer);
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v=0; v<V; v++){
                adj[v] = new Bag<Integer>();
            }
            // Read in all edges
            while ((buffer = br.readLine()) != null){
                String[] nodes = buffer.split("\s");
                int v = Integer.parseInt(nodes[0]);
                int w = Integer.parseInt(nodes[1]);
                addEdge(v, w);
            }
            assert E == E_expected;
            br.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String s = "Graph: " + V + " vertices with " + E + " edges\n";
        for (int v=0; v<V; v++){
            s += "\t" + v + ": ";
            for (int w : adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String args[]){
        Graph G = new Graph(args[0]);
        System.out.print(G);
    }


}
