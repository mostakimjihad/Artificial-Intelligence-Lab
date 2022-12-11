from collections import defaultdict


def isSafe():

    for parent in graph:
        for child in graph[parent]:
            if color[parent] == color[child]:
                return False
    return True

def graphColor(node, c):

    if(node >= v):
        if isSafe():
            return True
        else:
            return False
    for i in range(c):
        
        color[list(graph)[node]] = i
        
        if graphColor(node+1, c):
            return True

        color[list(graph)[node]] = 0
        

    return False
        

graph = defaultdict(list)
color = {}

v, e = map(int, input("Enter number of vertcies and edge : ").split())

for i in range(e):

    x, y = map(str, input("Enter parent and child node :").split())
    graph[x].append(y)
    graph[y].append(x)


c = int(input("Enter number of color : "))

if graphColor(0, c):
    print(color)
else:
    print("solution doesn't exist")

