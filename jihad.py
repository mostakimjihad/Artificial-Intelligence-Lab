from collections import defaultdict


def dls(source, target, limit):


    visited.append(source)
    print(source, end =" ")

    if source == target:
        return True
    if limit <= 0:
        return False

    for node in graph[source]:
        if node not in visited:
            if dls(node, target, limit-1):
                return True
    return False


def ids(source, target, max_depth):

    for i in range(max_depth):
        
        visited.clear()
        print("iteration " + str(i) + " : ")
        if dls(source, target, i):
            return True
    return False

graph = defaultdict(list)

v, e = map(int, input("Enter number of vertex and edge \n").split())

visited=[]

for i in range(e):
    
    parent, child = map(str, input("Enter parent node and child node \n").split())
    graph[parent].append(child)
    graph[child].append(parent)

source = input("Enter source node \n")
max_depth = int(input("Enter max depth \n"))
target = input("Enter target node \n")

if ids(source, target, max_depth):

    print("node found")
else:
    print("node not found")


