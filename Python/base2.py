import math

def binaryToDecimal(binary):
    binaryStr = str(binary)
    i = len(binaryStr)-1
    result = 0
    
    for char in binaryStr:
        number = int(char)
        result = (number * pow(2,i)) + result
        i-=1

    return result

def decimalToBinary(decimal):
    result = ""
    trans = decimal

    while trans >= 1 :
        trans= trans/2
        reste = trans%2
        result = result + str(int(reste))
    
    return result

def main():
    print("Binary to Decimal: "+ str(binaryToDecimal(1000101010011100110011010101110010101)))

    print("Decimal to Binary: "+ str(decimalToBinary(10)))



main()