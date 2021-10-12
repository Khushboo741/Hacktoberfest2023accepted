.intel_syntax noprefix
.global _start
.text
.include "../inc.S"
.include "parant.inc"

_start:
    xor rax, rax
    xor rdi, rdi

    //touch 
    xor rbx, rbx
    xor rdx, rdx
    xor rcx, rcx
    xor rsi, rsi

    lea rdi, [array]
    mov rsi, 200

    call read_string

loop1:

    call isValid
    
    mov rdi, rax
    call print_hex

    jmp pexit

pexit:
    mov rax, 60
    syscall


.data

array:
.fill 200, 1, 0
