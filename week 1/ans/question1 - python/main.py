#  question 1
# 4003623039
# 100 point
total = 0
onOff = 1
numberOfNum = input()
numberOfNumbers = int(numberOfNum)
newNum = [int(x) for x in input().split()]
# number[i] = int(newNum)
# newNum2 = int(newNum)
# number.append(newNum2)
# start
for i in range(numberOfNumbers):
    total = 0
    for j in range(i,numberOfNumbers):
        total += newNum[j]
        if total == 0:
            print("TRUE")
            onOff = 5
            break
    if onOff == 5:
        break
if onOff == 1:
    print("FALSE")