#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

typedef pair<int, int> pii;

class Graph {
    int V;
    vector<vector<pii>> adj;

public:
    Graph(int V) : V(V), adj(V) {}

    void addEdge(int u, int v, int weight) {
        adj[u].emplace_back(v, weight);
        adj[v].emplace_back(u, weight);
    }

    vector<pii> primMST(int startNode) {
        vector<int> key(V, INT_MAX);
        vector<int> parent(V, -1);
        vector<bool> inMST(V, false);

        auto compare = [](const pii& lhs, const pii& rhs) {
            return lhs.second > rhs.second;
        };

        priority_queue<pii, vector<pii>, decltype(compare)> pq(compare);

        pq.push(make_pair(startNode, 0));
        key[startNode] = 0;

        while (!pq.empty()) {
            int u = pq.top().first;
            pq.pop();

            inMST[u] = true;

            for (const auto& neighbor : adj[u]) {
                int v = neighbor.first;
                int weight = neighbor.second;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.push(make_pair(v, key[v]));
                }
            }
        }

        vector<pii> mst;
        for (int i = 0; i < V; ++i) {
            if (parent[i] != -1) {
                mst.emplace_back(parent[i], i);
            }
        }

        return mst;
    }
};

int main() {
    int V, E;
    cout << "Enter the number of vertices: ";
    cin >> V;
    cout << "Enter the number of edges: ";
    cin >> E;

    Graph graph(V);

    cout << "Enter the edges and their weights:\n";
    for (int i = 0; i < E; ++i) {
        int u, v, weight;
        cin >> u >> v >> weight;
        graph.addEdge(u, v, weight);
    }

    int startNode;
    cout << "Enter the starting node: ";
    cin >> startNode;

    vector<pii> mst = graph.primMST(startNode);

    cout << "Minimum Spanning Tree:\n";
    for (const auto& edge : mst) {
        cout << edge.first << " - " << edge.second << endl;
    }

    return 0;
}
