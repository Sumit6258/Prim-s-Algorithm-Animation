package sumit;


import java.util.*;

class Nodes
{
    private int v;
    private int weight;

    Nodes(int _v, int _w) { v = _v; weight = _w; }

    Nodes() {}

    int getV() { return v; }
    int getWeight() { return weight; }
}

class Main
{
    void primsAlgo(ArrayList<ArrayList<Nodes>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for(int i = 0;i<N;i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;


        for(int i = 0;i<N-1;i++) {
            int mini = 100000000, u = 0;
            for(int v = 0;v<N;v++) {
                if(mstSet[v] == false && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;


            for(Nodes it: adj.get(u)) {
                if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }
        }

        for(int i = 1;i<N;i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Nodes> > adj = new ArrayList<ArrayList<Nodes> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Nodes>());

        adj.get(0).add(new Nodes(1, 2));
        adj.get(1).add(new Nodes(0, 2));

        adj.get(1).add(new Nodes(2, 3));
        adj.get(2).add(new Nodes(1, 3));

        adj.get(0).add(new Nodes(3, 6));
        adj.get(3).add(new Nodes(0, 6));

        adj.get(1).add(new Nodes(3, 8));
        adj.get(3).add(new Nodes(1, 8));

        adj.get(1).add(new Nodes(4, 5));
        adj.get(4).add(new Nodes(1, 5));

        adj.get(2).add(new Nodes(4, 7));
        adj.get(4).add(new Nodes(2, 7));

        Main obj = new Main();
        obj.primsAlgo(adj, n);

    }
}


public class Prims_Code {
}
