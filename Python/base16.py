def base16_to_base10(s):
    r = 0
    dic = {'0':0,'1':1,'2':2,'3':3,'4':4,'5':5, '6':6, '7':7, '8':8,'9':9,'a':10,'b':11,'c':12,'d':13,'e':14,'f':15}
    for i, c in enumerate(s[::-1]):
        r += dic[c]*(16**i)

    return r

def base10_to_base2(n):
    s = ""
    while n > 0:
        rest = n % 2
        if rest == 0:
            s = '0' + s
        else:
            s = '1' + s

        n = n // 2
    return s

print(base10_to_base2(59437283743287548))
print(base16_to_base10('32'))

print(hex(50))
print(int("32",16))