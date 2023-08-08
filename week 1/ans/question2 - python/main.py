# question 2
# week 1
# 100 point
number1 = list(int(x) for x in input())
number2 = list(int(x) for x in input())
number1.reverse()
number2.reverse()
num1 = len(number1)
num2 = len(number2)
pre = 1
if num1 > num2:
    for i in range(len(number1)):
        if i > num2 - 1:
            if number1[i] > 9:
                number1[i] = int(number1[i] % 10)
                if i + 1 > len(number1)-1:
                    # number1.append(int(number1[i] % 10))
                    number1.append(int(1))
                else:
                    number1[i + 1] += 1
                continue
            break
        res = number1[i] + number2[i]
        if res > 9:
            number1[i] = int(res % 10)
            number1[i + 1] += 1
        else:
            number1[i] += number2[i]
else:
    pre = 2
    for i in range(num2):
        if i > num1 - 1:
            if number2[i] > 9:
                number2[i] = int(number2[i] % 10)
                if i + 1 > len(number2) - 1:
                    # number1.append(int(number1[i] % 10))
                    number2.append(int(1))
                else:
                    number2[i + 1] += 1
                continue
            break
        res = number1[i] + number2[i]
        if res > 9:
            number2[i] = int(res % 10)
            if i + 1 > len(number2) - 1:
                number2.append(int(1))
            else:
                number2[i + 1] += int(res/10)
        else:
            number2[i] += number1[i]
res = ""
if pre == 1:
    number1.reverse()
    for i in range(len(number1)):
        res += str(number1[i])
    print(res)
else:
    number2.reverse()
    for i in range(len(number2)):
        res += str(number2[i])
    print(res)
