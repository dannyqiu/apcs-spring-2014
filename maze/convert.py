import sys

mapData = []
with open(sys.argv[1], "r") as f:
    data = f.read().split('\n')
    for line in data:
        if len(line) > 0:
            mapData.append([ch for ch in line])

mapCopy = [line[:] for line in mapData]

for i in range(len(mapData)):
    for j in range(len(mapData[0])):
        if mapData[i][j] == "#":
            vertical = False
            horizontal = False
            if j-1 > 0:
                if mapData[i][j-1] == "#":
                    horizontal = True
            if j+1 < len(mapData[0]):
                if mapData[i][j+1] == "#":
                    horizontal = True
            if i-1 > 0:
                if mapData[i-1][j] == "#":
                    vertical = True
            if i+1 < len(mapData):
                if mapData[i+1][j] == "#":
                    vertical = True
            if vertical and horizontal:
                mapCopy[i][j] = "+"
            elif vertical:
                mapCopy[i][j] = "|"
            elif horizontal:
                mapCopy[i][j] = "-"

for line in mapCopy:
    print ''.join(line)
