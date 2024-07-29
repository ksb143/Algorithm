string = input()
a_count = string.count('a')

string += string[0:a_count-1]
min_value = float('inf')

for i in range(len(string) - (a_count - 1)):
    min_value = min(min_value, string[i:i + a_count].count('b'))

print(min_value)