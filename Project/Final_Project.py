import sys

class Graph():

    def __init__(self, vertices):
        self.V = vertices
        self.matrix = [[0 for a in range(self.V)] for b in range(self.V)]

    def printSolution(self, dist, src):
        list = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        print ("Vertex \tDistance from", list[src])
        for node in range(self.V):
            print (node, "\t", dist[node])

    def minDistance(self, dist, sptSet):


        min = sys.maxsize

        for v in range(self.V):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v

        return min_index

    def dijkstra(self, src):

        dist = [sys.maxsize] * self.V
        dist[src] = 0
        sptSet = [False] * self.V

        for count in range(self.V):
            u = self.minDistance(dist, sptSet)

            sptSet[u] = True

            for v in range(self.V):
                if self.matrix[u][v] > 0 and sptSet[v] == False and \
                dist[v] > dist[u] + self.matrix[u][v]:
                        dist[v] = dist[u] + self.matrix[u][v]

        self.printSolution(dist, src)

#this is where MST begins

    def showMatrix(self):
        print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in self.matrix]))  #print matrix

    def printMST(self, parent):
        list = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        print("Edge \tWeight")
        for i in range(1, self.V):
            print(list[parent[i]], "to", list[i], "\t", self.matrix[i][parent[i]])

    def minKey(self, key, mstSet):

        # Initilaize min value
        min = sys.maxsize

        for v in range(self.V):
            if key[v] < min and mstSet[v] == False:
                min = key[v]
                min_index = v

        return min_index

    def MST(self):

        key = [sys.maxsize] * self.V
        co = [None] * self.V
        key[0] = 0
        mstSet = [False] * self.V

        co[0] = -1

        for cout in range(self.V):

            u = self.minKey(key, mstSet)

            mstSet[u] = True
            for v in range(self.V):
                if self.matrix[u][v] > 0 and mstSet[v] == False and key[v] > self.matrix[u][v]:
                        key[v] = self.matrix[u][v]
                        co[v] = u

        self.printMST(co)

V = 5
# Driver program
g = Graph(V)
g.matrix = [[0, 2, 0 , 6, 0],
           [2, 0, 3, 8, 5],
           [0, 3, 0, 0, 7],
           [6, 8, 0, 0, 9],
           [0, 5, 7, 9, 0]
        ];

flag = 1
while(flag):
    algorithm = input("Choose an option: \n1: Minimum Spanning Tree\n2: Shortest Path\n3: Exit\n")
    if (algorithm == "1"):
        g.MST()
    elif (algorithm == "2"):
        for i in range(V):
            g.dijkstra(i)
    elif (algorithm == "3"):
        break
    else:
        print("Enter 1,2 or 3")
