#!/usr/bin/env python
# coding: utf-8

# In[6]:


### This Minimum Spanning Tree is based on Prim's (Greedy) Algorithm

import sys


# In[7]:


class graph:
    
    
    def __init__(self, vertices):
        self.V = vertices  #init the number of nodes in graph
        self.matrix = [[0 for a in range(self.V)] for b in range(self.V)]  #init the matrix of the graph
    
    def showMatrix(self):
        print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in self.matrix]))  #print matrix
    
    """
    def MST(self):
        print("running MST")
        _mstlist = []
        count = 0
        flag = True
        min = 0
        j = 0
        while(flag):
            for i in range(self.n):
                #print("In for loop " + str(i) )
                if(self.matrix[i][j] != 0):
                    if(min > self.matrix[i][j]):
                        min = self.matrix[i][j]
                        j = i
            print("count is " + str(count) +  " and n is "+ str(self.n))
            count = count + 1
            min = 0
            _mstlist.append(j)
            if(count == self.n):
                flag = False
                
    """
    
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
        


# In[10]:


g = graph(5)
g.matrix = [ [0, 2, 0, 6, 0], 
            [2, 0, 3, 8, 5], 
            [0, 3, 0, 0, 7], 
            [6, 8, 0, 0, 9], 
            [0, 5, 7, 9, 0]]

g.MST()


# In[ ]:





# In[ ]:




