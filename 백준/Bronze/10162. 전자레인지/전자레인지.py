T = int(input())

buttons = [300, 60, 10]
button_num = []

for button in buttons:
    count = 0
    count += T // button
    T %= button
    button_num.append(count)

if T == 0:
    for i in button_num:
        print(i, end = " ")
else:
    print(-1)
    