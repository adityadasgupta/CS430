"""
Final Project
CS430, Spring 2020
TEAM NULL
Aditya Dasgupta -- A20410323 -- Seat Number 14
Devyani Gauri -- A20396296 -- Seat Number 25
"""

import sys

class Graph():
    # inititating a Graph variable
    def __init__(self, vertices):
        self.V = vertices       #set the number of nodes in graph
        self.matrix = [[0 for a in range(self.V)] for b in range(self.V)]       #the adjacency matrix for the graph is initiated to 0
   
    def showMatrix(self):
        print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in self.matrix]))  #print matrix

    # Helper Functions
    
    def printSolution(self, dist, src):     #pretty prints the Shortest Path for all the nodes in the graph. For n nodes, there are n^2 outputs.
        list = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        print ("Vertex \tDistance from", list[src])
        for node in range(self.V):
            print (node, "\t", dist[node])

    def minDistance(self, dist, spt):        #returns edge that has the shortest weight (that is not already included in the Shortest Path)

        # Initilaize min value with infinity
        min = sys.maxsize

        # loop searches for a non-nearest node not in the Shortest Path
        for v in range(self.V):
            if dist[v] < min and spt[v] == False:
                min = dist[v]
                min_index = v       # min_index gets updated with shortest edge

        return min_index
        
    # Shortest Path Function

    def dijkstra(self, src):

        dist = [sys.maxsize] * self.V
        dist[src] = 0       # The Dist list stores the minimum distances
        spt = [False] * self.V
        
        # Choses the minimum weighted edge 
        # In the first iteration, u is always equal to src
        for count in range(self.V):
            u = self.minDistance(dist, spt)

            # The minimum edge is added to the shortest path list in its respective index
            spt[u] = True

            for v in range(self.V):
                if self.matrix[u][v] > 0 and spt[v] == False and \
                dist[v] > dist[u] + self.matrix[u][v]:
                        dist[v] = dist[u] + self.matrix[u][v]

        self.printSolution(dist, src)

    # More Helper Functions


    def printMST(self, parent): # This function prints the edges that are included in the Minimum Spanning Tree
        list = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        print("Edge \tWeight")
        for i in range(1, self.V):
            print(list[parent[i]], "to", list[i], "\t", self.matrix[i][parent[i]])


    # MST Function
    
    def MST(self):

        key = [sys.maxsize] * self.V #keys to put minimum edge values in 
        co = [None] * self.V    # array to store the MST
        key[0] = 0 
        mstSet = [False] * self.V  

        co[0] = -1  # First node is the root

        for cout in range(self.V):
            # Choses min edge from list of non chosen edges.
            u = self.minDistance(key, mstSet)
            
            # Put the minimum edge value in the mstSet list and evetually in the co list
            mstSet[u] = True
            for v in range(self.V):
                if self.matrix[u][v] > 0 and mstSet[v] == False and key[v] > self.matrix[u][v]:
                        key[v] = self.matrix[u][v]
                        co[v] = u

        self.printMST(co)

# Driver program
g1 = Graph(5)
g1.matrix = [[0, 2, 0 , 6, 0],
           [2, 0, 3, 8, 5],
           [0, 3, 0, 0, 7],
           [6, 8, 0, 0, 9],
           [0, 5, 7, 9, 0]
        ];
        
g2 = Graph(4)
g2.matrix = [[0, 2, 0 , 6],
           [2, 0, 3, 8],
           [0, 3, 0, 0],
           [6, 8, 0, 0],
        ];
        
g3 = Graph(5)
g3.matrix = [[0, 7, 0 , 2, 0],
           [7, 0, 3, 8, 5],
           [0, 3, 0, 0, 7],
           [2, 8, 0, 0, 9],
           [0, 5, 7, 9, 0]
        ];

flag = 1
while(flag):
    print("\n")
    g1.showMatrix()
    print("\n\n\n")
    g2.showMatrix()
    print("\n\n\n")
    g3.showMatrix()
    print("\n\n\n")
    g = input("Chose a graph that you want to work with. (Enter 1, 2 or 3) \n")
    
    algorithm = input("Choose an option: \n1: Minimum Spanning Tree\n2: Shortest Path\n3: Exit\n")
    if (algorithm == "1" and g == "1"):
        g1.MST()
    elif (algorithm == "1" and g == "2"):
        g2.MST()
    elif (algorithm == "1" and g == "3"):
        g3.MST()
    elif (algorithm == "2" and g == "1"):
        for i in range(V):
            g1.dijkstra(i)
    elif (algorithm == "2" and g == "2"):
        for i in range(V):
            g2.dijkstra(i)
    elif (algorithm == "2" and g == "3"):
        for i in range(V):
            g3.dijkstra(i)
    elif (algorithm == "3"):
        break
    else:
        print("Enter 1,2 or 3")
        
    
        
        
