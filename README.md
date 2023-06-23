# Betweenness-and-Closeness-centrality-metrics

The Betweenness and Closeness centrality metrics and rank the nodes of the given two graph datasets which are Zachary Karate Club Network and Facebook Social Network.

Centrality metrics are used to identify the most important nodes within a graph. There are various centrality metrics including Degree, Closeness, Betweenness, Eigenvector, Katz, PageRank, etc. In the scope of this project, implement the following two centrality metrics and test on the given two graph datasets.

1. **Betweenness Centrality**

   Betweenness centrality shows the strategic location of a node in a graph. Betweenness centrality of a node *n* is defined as the number of shortest paths going through the node *n*. For each pair of nodes, shortest paths between them are computed and the fraction of shortest paths passing through *n* is calculated. The betweenness of node *n* is obtained by summing this fraction for all pairs of nodes as defined in the following equation.

   ![image](https://github.com/kaans4nli/Betweenness-and-Closeness-centrality-metrics/assets/107371841/56d985f3-38b2-4187-9000-fa8f3f60283e)

   where, 𝜎<sub>*st*</sub> is the total number of shortest paths from node *s* to node *t*; 𝜎<sub>*st*</sub>(𝑛) is the number of those paths that pass-through node *n*.

2. Closeness Centrality

   Closeness centrality depends on measure of how close a node is to the other nodes in the graph. A node in a more central location is considered closer to all other nodes. Closeness is calculated by taking the average length of the shortest paths between the node *n* and all other nodes as given in the following equation.

   ![image](https://github.com/kaans4nli/Betweenness-and-Closeness-centrality-metrics/assets/107371841/79022d61-92b3-46e8-9c38-3c2a33ec455a)

   where *dist(i, n)* is the minimum distance between nodes *i* and *n*.

# GRAPH DATASETS

1. Zachary Karate Club Network

   The dataset contains social ties among the members of a university karate club collected by Wayne Zachary in 1977.

   ![image](https://github.com/kaans4nli/Betweenness-and-Closeness-centrality-metrics/assets/107371841/b9d4cdf1-c1bf-433d-b8c7-56ae1615c6dc)

2. Facebook Social Network

   This social friendship network extracted from Facebook consists of people (nodes) with edges representing friendship ties.

   ![image](https://github.com/kaans4nli/Betweenness-and-Closeness-centrality-metrics/assets/107371841/2977e5b0-ecb0-4882-b5f0-5b9ff6171d37)
